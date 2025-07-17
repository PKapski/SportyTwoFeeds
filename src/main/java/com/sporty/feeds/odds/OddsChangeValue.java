package com.sporty.feeds.odds;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class OddsChangeValue {
    private float homeWinOdds;
    private float drawOdds;
    private float awayWinOdds;
}