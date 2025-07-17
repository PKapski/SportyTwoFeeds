package com.sporty.feeds.providers.beta;

import com.sporty.feeds.odds.OddsChangeMessageService;
import com.sporty.feeds.providers.beta.dto.BetaBaseMessageDto;
import com.sporty.feeds.providers.beta.dto.BetaBetSettlementMessageDto;
import com.sporty.feeds.providers.beta.dto.BetaOddsChangeMessageDto;
import com.sporty.feeds.settlement.BetSettlementMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider-beta")
@RequiredArgsConstructor
public class BetaProviderMessageController {

    private final OddsChangeMessageService oddsChangeMessageService;
    private final BetSettlementMessageService betSettlementMessageService;

    @PostMapping("/feed")
    public ResponseEntity<Void> sendBetaFeed(@RequestBody BetaBaseMessageDto message) {
        if (message instanceof BetaOddsChangeMessageDto oddsMsg) {
            oddsChangeMessageService.sendOddsChangeMessage(oddsMsg.toOddsChangeMessage());
            return ResponseEntity.ok().build();
        } else if (message instanceof BetaBetSettlementMessageDto betMsg) {
            betSettlementMessageService.sendBetSettlementMessage(betMsg.toBetSettlementMessage());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
