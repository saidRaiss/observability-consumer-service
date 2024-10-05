package ma.socrates.observability.consumer.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class KafkaConfig {

    private String bootstrap;
    private String topic;
    private Config config;

    @NoArgsConstructor
    @Getter
    @Setter
    public static class Config {
        private String mapping;
    }
}

