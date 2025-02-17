package silva.daniel.project.poc.kafka.patternmodule.patterns.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NonTesteListener {

    @EventListener(condition = "#request.event == 'FLUX'")
    public void executeEvent(Request request) {
        System.out.println("Request received na Classe NonTesteListener: " + request.getEvent() + " - " + request.getMessage());
    }

}
