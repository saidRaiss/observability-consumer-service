package ma.socrates.observability.consumer.core.usecase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.socrates.observability.consumer.core.model.Message;
import ma.socrates.observability.consumer.core.service.ConsumerRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MessageRetrieve {

    private final ConsumerRepository consumerRepository;

    public Message handle(String id) {
        log.info("Retrieving message with id: {}", id);
        return consumerRepository.getById(Long.parseLong(id));
    }

}
