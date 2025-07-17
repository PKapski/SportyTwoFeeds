package com.sporty.feeds.providers.beta.dto;

import com.sporty.feeds.odds.OddsChangeMessage;
import com.sporty.feeds.providers.FeedProvider;
import com.sporty.feeds.providers.dto.OddsChangeValueDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BetaOddsChangeMessageDto extends BetaBaseMessageDto{
    private OddsChangeValueDto odds;

    public OddsChangeMessage toOddsChangeMessage() {
        return OddsChangeMessage.builder()
                .provider(FeedProvider.BETA)
                .eventId(getEventId())
                .odds(odds.toOddsChangeValue())
                .build();
    }
}
