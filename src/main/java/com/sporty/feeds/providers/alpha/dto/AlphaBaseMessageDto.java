package com.sporty.feeds.providers.alpha.dto;

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
        property = "msg_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AlphaOddsChangeMessageDto.class, name = "odds_update"),
        @JsonSubTypes.Type(value = AlphaBetSettlementMessageDto.class, name = "settlement")
})
public class AlphaBaseMessageDto {
    @JsonProperty("msg_type")
    private String messageType;
    @JsonProperty("event_id")
    private String eventId;
}
