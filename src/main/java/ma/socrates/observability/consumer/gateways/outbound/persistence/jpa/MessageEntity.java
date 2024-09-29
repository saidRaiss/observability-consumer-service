package ma.socrates.observability.consumer.gateways.outbound.persistence.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.socrates.observability.consumer.core.model.Message;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    public MessageEntity(String content) {
        this.content = content;
    }

    public static MessageEntity of(Message message) {
        return new MessageEntity(message.content());
    }

    public Message toDomain() {
        return new Message("" + id, content);
    }
}
