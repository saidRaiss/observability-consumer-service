package ma.socrates.observability.consumer.gateways.inbound.broker;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.socrates.observability.consumer.core.model.Message;
import ma.socrates.observability.consumer.core.service.ConsumerRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class KafkaConsumer {

    private static final String TOPIC = "topic-observability";
    private static final String GROUP_ID = "group-consumer-service";

    private final ConsumerRepository consumerRepository;

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consume(Message message) {
        log.trace("Trace details: consumer try publish new message: {}", message);
        log.debug("Debug details: Received: {}", message);
        consumerRepository.save(message);
        log.info("Info details: consumer saved new message: {}", message);
    }

}
