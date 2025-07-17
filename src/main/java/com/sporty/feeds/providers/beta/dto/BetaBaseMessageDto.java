package com.sporty.feeds.providers.beta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BetaOddsChangeMessageDto.class, name = "ODDS"),
        @JsonSubTypes.Type(value = BetaBetSettlementMessageDto.class, name = "SETTLEMENT")
})
public class BetaBaseMessageDto {
    private String type;
    @JsonProperty("event_id")
    private String eventId;
}
