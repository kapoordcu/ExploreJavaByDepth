package explore.topics.tipico;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VaixEventsDTO {

    @JsonProperty("count")
    private Long count;

    @JsonProperty("sports")
    private List<String> sports;

    @JsonProperty("results")
    private List<VaixEvents> results;

    public Long getCount() {
        return count;
    }

    public List<VaixEvents> getRecommendationEventList() {
        return Collections.unmodifiableList(results);
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setResults(List<VaixEvents> results) {
        this.results = new ArrayList<VaixEvents>(results);
    }

    public List<String> getSports() {
        return Collections.unmodifiableList(sports);
    }

    public void setSports(List<String> sports) {
        this.sports = new ArrayList<String>(sports);
    }
}
