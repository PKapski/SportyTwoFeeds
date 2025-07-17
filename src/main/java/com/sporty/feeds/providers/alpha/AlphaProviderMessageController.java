package com.sporty.feeds.providers.alpha;

import com.sporty.feeds.odds.OddsChangeMessageService;
import com.sporty.feeds.providers.alpha.dto.AlphaBaseMessageDto;
import com.sporty.feeds.providers.alpha.dto.AlphaBetSettlementMessageDto;
import com.sporty.feeds.providers.alpha.dto.AlphaOddsChangeMessageDto;
import com.sporty.feeds.settlement.BetSettlementMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider-alpha")
@RequiredArgsConstructor
public class AlphaProviderMessageController {

    private final OddsChangeMessageService oddsChangeMessageService;
    private final BetSettlementMessageService betSettlementMessageService;

    @PostMapping("/feed")
    public ResponseEntity<Void> sendAlphaFeed(@RequestBody AlphaBaseMessageDto message) {
        if (message instanceof AlphaOddsChangeMessageDto oddsMsg) {
            oddsChangeMessageService.sendOddsChangeMessage(oddsMsg.toOddsChangeMessage());
            return ResponseEntity.ok().build();
        } else if (message instanceof AlphaBetSettlementMessageDto betMsg) {
            betSettlementMessageService.sendBetSettlementMessage(betMsg.toBetSettlementMessage());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
