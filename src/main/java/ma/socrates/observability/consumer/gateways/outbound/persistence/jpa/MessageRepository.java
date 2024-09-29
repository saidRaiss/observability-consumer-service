package ma.socrates.observability.consumer.gateways.outbound.persistence.jpa;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
}
