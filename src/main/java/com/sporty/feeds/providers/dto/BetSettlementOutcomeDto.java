package com.sporty.feeds.providers.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sporty.feeds.settlement.BetSettlementResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum BetSettlementOutcomeDto {
    HOME(List.of("1", "home")),
    DRAW(List.of("X", "draw")),
    AWAY(List.of("2", "away"));

    @JsonValue
    private final List<String> codes;

    @JsonCreator
    public static BetSettlementOutcomeDto fromValue(String value) {
        for (BetSettlementOutcomeDto c : BetSettlementOutcomeDto.values()) {
            if (c.codes.contains(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    public BetSettlementResult toBetSettlementResult() {
        return switch (this) {
            case HOME -> BetSettlementResult.HOME;
            case DRAW -> BetSettlementResult.DRAW;
            case AWAY -> BetSettlementResult.AWAY;
        };
    }
}
