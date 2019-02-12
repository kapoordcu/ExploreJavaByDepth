package explore.topics.design.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static explore.topics.design.facade.UserRecommendationSource.BI;
import static explore.topics.design.facade.UserRecommendationSource.INWT;
import static explore.topics.design.facade.UserRecommendationSource.VAIX;
import static java.util.Collections.emptyList;

@Service
public class RecommendationFacade {

    private final VaixService vaixService;
    private final InwtService inwtService;
    private final ProfileService profileService;

    private final EventAndGroupIdsSupplier biEventAndGroupIdsSupplier;
    private final EventAndGroupIdsSupplier vaixEventAndGroupIdsSupplier;
    private final EventAndGroupIdsSupplier inwtEventAndGroupIdsSupplier;


    @Autowired
    public RecommendationFacade(VaixService vaixService, InwtService inwtService,
                                ProfileService profileService) {
        this.vaixService = vaixService;
        this.inwtService = inwtService;
        this.profileService = profileService;

        this.biEventAndGroupIdsSupplier = new BIEventAndGroupIdsSupplier()
                .withFallback(new VaixEventAndGroupIdsSupplier()
                        .withFallback(new INWTEventAndGroupIdsSupplier()));

        this.vaixEventAndGroupIdsSupplier = new VaixEventAndGroupIdsSupplier()
                .withFallback(new INWTEventAndGroupIdsSupplier());

        this.inwtEventAndGroupIdsSupplier = new INWTEventAndGroupIdsSupplier();
    }

    public List<Long> getEventIds(String userValue, boolean confidenceSort) {
        List<Long> eventIds;
        switch (UserRecommendationSource.valueOf(userValue)) {
            case VAIX:
                eventIds = vaixEventAndGroupIdsSupplier.supplyEventIds(userValue, confidenceSort);
                break;
            case BI:
                eventIds = biEventAndGroupIdsSupplier.supplyEventIds(userValue, confidenceSort);
                break;
            case INWT:
                eventIds = inwtEventAndGroupIdsSupplier.supplyEventIds();
                break;
            default:
                eventIds = emptyList();
        }
        return eventIds;
    }

    private static abstract class EventAndGroupIdsSupplier {

        private EventAndGroupIdsSupplier fallback;

        public EventAndGroupIdsSupplier withFallback(EventAndGroupIdsSupplier fallback) {
            this.fallback = fallback;
            return this;
        }

        public List<Long> supplyEventIds(String uuid, boolean confidenceSort) {
            final List<Long> eventIds = getEventIds(uuid, confidenceSort);

            if (fallback == null || !eventIds.isEmpty()) {
                if (uuid != null) {
//                    MobileContextHelper.getSession().setAttribute(USER_RECOMMENDATION_SOURCE,
//                            decideSourceByFallbackClass(getClass().getSimpleName()));
                }
                return eventIds;
            }

            return fallback.supplyEventIds(uuid, confidenceSort);
        }

        private UserRecommendationSource decideSourceByFallbackClass(String className) {
            if (className.equals("VaixEventAndGroupIdsSupplier")) {
                return VAIX;
            } else if (className.equals("BIEventAndGroupIdsSupplier")) {
                return BI;
            } else {
                return INWT;
            }
        }

        public List<Long> supplyEventIds() {
            return supplyEventIds(null, false);
        }

        protected abstract List<Long> getEventIds(String uuid, boolean confidenceSort);

    }

    private class VaixEventAndGroupIdsSupplier extends EventAndGroupIdsSupplier {

        @Override
        protected List<Long> getEventIds(String uuid, boolean confidenceSort) {
            return vaixService.getEventIds(uuid, confidenceSort);
        }

    }

    private class BIEventAndGroupIdsSupplier extends EventAndGroupIdsSupplier {

        @Override
        protected List<Long> getEventIds(String uuid, boolean confidenceSort) {
            return profileService.getBIEventIds(uuid);
        }

    }

    private class INWTEventAndGroupIdsSupplier extends EventAndGroupIdsSupplier {

        @Override
        protected List<Long> getEventIds(String uuid, boolean confidenceSort) {
            return inwtService.getEventIdsByTurnover();
        }
    }
}
