package silva.daniel.project.study.injection2;

import silva.daniel.project.study.injection2.annotations.Autowired;

public class Client {
    @Autowired
    private Dependency dependency;
    @Autowired
    private Service service;

    public void doSomething() {
        dependency.performAction();
        service.doService();
    }
}
