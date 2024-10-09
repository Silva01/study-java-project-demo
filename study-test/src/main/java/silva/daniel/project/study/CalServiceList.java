package silva.daniel.project.study;

import java.util.ArrayList;
import java.util.List;

public class CalServiceList {

    private List<String> listService = new ArrayList<>();

    public int sizeListService() {
        var service = new Service(listService);
        return service.sizeListService();
    }
}
