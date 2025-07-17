package com.sporty.feeds.providers.alpha.dto;

import com.sporty.feeds.odds.OddsChangeMessage;
import com.sporty.feeds.providers.FeedProvider;
import com.sporty.feeds.providers.dto.OddsChangeValueDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlphaOddsChangeMessageDto extends AlphaBaseMessageDto {
    private OddsChangeValueDto values;

    public OddsChangeMessage toOddsChangeMessage() {
        return OddsChangeMessage.builder()
                .provider(FeedProvider.ALPHA)
                .eventId(getEventId())
                .odds(values.toOddsChangeValue())
                .build();
    }
}
