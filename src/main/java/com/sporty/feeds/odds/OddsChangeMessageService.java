package com.sporty.feeds.odds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OddsChangeMessageService {

    private static final Logger logger = LoggerFactory.getLogger(OddsChangeMessageService.class);

    public void sendOddsChangeMessage(OddsChangeMessage message) {
        logger.info("Mock sent odds change message to queue: {}", message.toString());
    }
}
