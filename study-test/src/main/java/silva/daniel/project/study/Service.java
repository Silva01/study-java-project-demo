package silva.daniel.project.study;

import java.util.List;

public class Service {

    private final List<String> stringNames;

    public Service(List<String> stringNames) {
        this.stringNames = stringNames;
    }

    public void deleteName(String name) {
        stringNames.remove(name);
    }

}
