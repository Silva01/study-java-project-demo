package silva.daniel.project.poc.kafka.patternmodule.patterns.observer;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPlublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public EventPlublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(final Request request) {
        applicationEventPublisher.publishEvent(request);
    }
}
