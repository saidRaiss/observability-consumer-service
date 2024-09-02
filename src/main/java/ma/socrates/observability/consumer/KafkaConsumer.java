package ma.socrates.observability.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    private static final String TOPIC = "topic-observability";
    private static final String GROUP_ID = "group_id";

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consume(String message) {
        log.info("Message received: {}", message);
    }

}
