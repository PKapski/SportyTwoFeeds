package com.sporty.feeds.odds;

import com.sporty.feeds.providers.FeedProvider;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class OddsChangeMessage {
    private FeedProvider provider;
    private String eventId;
    private OddsChangeValue odds;
}
