package com.sporty.feeds.providers.alpha.dto;

import com.sporty.feeds.providers.dto.BetSettlementOutcomeDto;
import com.sporty.feeds.providers.FeedProvider;
import com.sporty.feeds.settlement.BetSettlementMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlphaBetSettlementMessageDto extends AlphaBaseMessageDto {
    private BetSettlementOutcomeDto outcome;

    public BetSettlementMessage toBetSettlementMessage() {
        return BetSettlementMessage.builder()
                .provider(FeedProvider.ALPHA)
                .eventId(getEventId())
                .result(outcome.toBetSettlementResult())
                .build();
    }
}
