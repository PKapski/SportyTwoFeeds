# Local environment setup:
Note: Application was developed and tested on openjdk-24.0.1 and Intellij Community 2025.1.3. 
It will probably work on lower versions (starting from Java 17 as newest Spring Boot was used), but it was not tested due to limited time.
1. Run clean install in the root directory of the project:
```mvn clean install```
2. Run com.sporty.SportyApplication from IntelliJ IDEA or cmd: ```java -jar target/SportyTwoFeeds-1.0-SNAPSHOT.jar```
3. Application will start on port 8080 using Tomcat

# Test cases:
Call these curls using Your http client of choice (for example Postman):

**ALPHA ODDS_CHANGE:**\
curl --location 'http://localhost:8080/provider-alpha/feed' \
--header 'Content-Type: application/json' \
--data '{
"msg_type": "odds_update",
"event_id": "ev123",
"values": {
"1": 2.0,
"X": 3.1,
"2": 3.8
} }'

**ALPHA BET_SETTLEMENT:**\__
curl --location 'http://localhost:8080/provider-alpha/feed' \
--header 'Content-Type: application/json' \
--data '{
"msg_type": "settlement",
"event_id": "ev123",
"outcome": "1"
}'

**BETA ODDS_CHANGE:**\
curl --location 'http://localhost:8080/provider-beta/feed' \
--header 'Content-Type: application/json' \
--data '{
"type": "ODDS",
"event_id": "ev456",
"odds": {
"home": 1.95,
"draw": 3.2,
"away": 4.0 
} }'

**BETA BET_SETTLEMENT:**\
curl --location 'http://localhost:8080/provider-beta/feed' \
--header 'Content-Type: application/json' \
--data '{
"type": "SETTLEMENT",
"event_id": "ev456",
"result": "home"
}'

These curls should result in **http 200** response and the result will be seen in console, for example:\
_2025-07-17 14:11:28 INFO  c.s.f.odds.OddsChangeMessageService - Mock sent odds change message to queue: OddsChangeMessage(provider=BETA, eventId=ev456, odds=OddsChangeValue(homeWinOdds=1.95, drawOdds=3.2, awayWinOdds=4.0))_
