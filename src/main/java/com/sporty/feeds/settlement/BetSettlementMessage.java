package com.sporty.feeds.settlement;

import com.sporty.feeds.providers.FeedProvider;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class BetSettlementMessage {
    private FeedProvider provider;
    private String eventId;
    private BetSettlementResult result;
}
