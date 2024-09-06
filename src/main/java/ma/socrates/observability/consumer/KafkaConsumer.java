package ma.socrates.observability.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaConsumer {

    private static final String TOPIC = "topic-observability";
    private static final String GROUP_ID = "group-consumer-service";

    private final MessageRepository messageRepository;

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consume(Message message) {
        log.info("Received: {}", message);
        messageRepository.save(MessageEntity.of(message));
    }

}
