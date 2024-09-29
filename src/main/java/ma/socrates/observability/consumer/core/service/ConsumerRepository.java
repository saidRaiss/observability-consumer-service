package ma.socrates.observability.consumer.core.service;

import ma.socrates.observability.consumer.core.model.Message;

public interface ConsumerRepository {

    void save(Message message);
    Message getById(Long id);

}
