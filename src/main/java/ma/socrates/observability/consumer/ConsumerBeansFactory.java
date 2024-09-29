package ma.socrates.observability.consumer;

import ma.socrates.observability.consumer.config.KafkaConfig;
import ma.socrates.observability.consumer.core.model.Message;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerBeansFactory {

    @Bean
    @ConfigurationProperties(prefix = "app.kafka")
    KafkaConfig createKafkaConfig() {
        return new KafkaConfig();
    }

    @Bean
    public ConsumerFactory<String, Message> createConsumerFactory(KafkaConfig kafkaConfig) {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getBootstrap());
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        config.put("spring.json.type.mapping", kafkaConfig.getConfig().getMapping());
        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Message> createListenerContainerFactory(
            ConsumerFactory<String, Message> consumerFactory) {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, Message> ();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

}
