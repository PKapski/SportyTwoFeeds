package com.sporty.feeds.providers.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.sporty.feeds.odds.OddsChangeValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OddsChangeValueDto {
    @JsonAlias({"1", "home"})
    private float homeWinOdds;
    @JsonAlias({"X", "draw"})
    private float drawOdds;
    @JsonAlias({"2", "away"})
    private float awayWinOdds;

    public OddsChangeValue toOddsChangeValue() {
        return OddsChangeValue.builder()
                .homeWinOdds(homeWinOdds)
                .drawOdds(drawOdds)
                .awayWinOdds(awayWinOdds)
                .build();
    }
}
