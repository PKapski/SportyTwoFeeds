package com.sporty.feeds.settlement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BetSettlementMessageService {

    private static final Logger logger = LoggerFactory.getLogger(BetSettlementMessageService.class);

    public void sendBetSettlementMessage(BetSettlementMessage message) {
        logger.info("Mock sent bet settlement message to queue: {}", message.toString());
    }
}
