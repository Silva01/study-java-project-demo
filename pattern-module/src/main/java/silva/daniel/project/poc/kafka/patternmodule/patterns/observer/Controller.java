package silva.daniel.project.poc.kafka.patternmodule.patterns.observer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/observer")
public class Controller {

    private final EventPlublisher eventPlublisher;

    public Controller(EventPlublisher eventPlublisher) {
        this.eventPlublisher = eventPlublisher;
    }

    @GetMapping("/execute/{type}")
    public void executeEvent(@PathVariable String type) {
        System.out.println("Request received: " + type);
        eventPlublisher.publishEvent(new Request(type, "Qualquer coisa"));
    }
}
