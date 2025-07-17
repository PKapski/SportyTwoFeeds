package com.sporty.feeds.providers.beta.dto;

import com.sporty.feeds.providers.FeedProvider;
import com.sporty.feeds.providers.dto.BetSettlementOutcomeDto;
import com.sporty.feeds.settlement.BetSettlementMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BetaBetSettlementMessageDto extends BetaBaseMessageDto {
    private BetSettlementOutcomeDto result;

    public BetSettlementMessage toBetSettlementMessage() {
        return BetSettlementMessage.builder()
                .provider(FeedProvider.BETA)
                .eventId(getEventId())
                .result(result.toBetSettlementResult())
                .build();
    }
}
