package silva.daniel.project.study;

import java.util.List;

public class Service {

    private List<String> stringNames;

    public Service(List<String> stringNames) {
        this.stringNames = stringNames;
    }

    public void deleteName(String name) throws Exception {
        if (name.equalsIgnoreCase("Error")) {
            System.out.println("Error");
            throw new Exception("Error");
        }
        stringNames.remove(name);
    }

    public int sizeListService() {
        return stringNames.size();
    }

}
