package silva.daniel.project.poc.kafka.patternmodule.patterns.observer;

public class Request {
    private String message;
    private String event;

    public Request(String type, String message) {
        this.message = message;
        this.event = type;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
