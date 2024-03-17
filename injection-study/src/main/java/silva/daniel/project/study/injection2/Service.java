package silva.daniel.project.study.injection2;

import silva.daniel.project.study.injection1.annotations.LoadFactory;

@LoadFactory
public class Service {
    public void doService() {
        System.out.println("Service is being executed");
    }
}
