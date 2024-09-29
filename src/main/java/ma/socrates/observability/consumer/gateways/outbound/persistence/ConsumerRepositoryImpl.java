package ma.socrates.observability.consumer.gateways.outbound.persistence;

import lombok.AllArgsConstructor;
import ma.socrates.observability.consumer.core.model.Message;
import ma.socrates.observability.consumer.core.service.ConsumerRepository;
import ma.socrates.observability.consumer.gateways.outbound.persistence.jpa.MessageEntity;
import ma.socrates.observability.consumer.gateways.outbound.persistence.jpa.MessageRepository;

@AllArgsConstructor
public class ConsumerRepositoryImpl implements ConsumerRepository {

    private final MessageRepository messageRepository;

    @Override
    public void save(Message message) {
        messageRepository.save(MessageEntity.of(message));
    }

    @Override
    public Message getById(Long id) {
        return messageRepository.getReferenceById(id).toDomain();
    }
}
