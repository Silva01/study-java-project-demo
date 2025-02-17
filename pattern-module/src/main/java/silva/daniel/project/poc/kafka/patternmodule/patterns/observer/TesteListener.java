package silva.daniel.project.poc.kafka.patternmodule.patterns.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TesteListener  {

    @EventListener(condition = "#request.event == 'TESTE'")
    public void executeEvent(Request request) {
        System.out.println("Request received na Classe TesteListener: " + request.getEvent() + " - " + request.getMessage());
    }

}
