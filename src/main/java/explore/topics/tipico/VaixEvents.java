package explore.topics.tipico;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VaixEvents {

    @JsonProperty("event_id")
    private Long eventId;

    @JsonProperty("confidence")
    private double confidence;

    @JsonProperty("sport")
    private String sport;

    public Long getEventId() {
        return eventId;
    }

    public double getConfidence() {
        return confidence;
    }

    public String getSport() {
        return sport;
    }
}
