package ma.socrates.observability.consumer.controller;

import lombok.AllArgsConstructor;
import ma.socrates.observability.consumer.core.model.Message;
import ma.socrates.observability.consumer.core.usecase.MessageRetriever;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ConsumerController {

    private final MessageRetriever messageRetrieve;

    @GetMapping("/message")
    public Message getMessageById(@RequestParam String id) {
        return messageRetrieve.handle(id);
    }

}
