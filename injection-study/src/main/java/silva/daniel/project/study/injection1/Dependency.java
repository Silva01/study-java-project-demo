package silva.daniel.project.study.injection1;


import silva.daniel.project.study.injection1.annotations.LoadFactory;

@LoadFactory
public class Dependency {
    public void performAction() {
        System.out.println("Performing action");
    }
}
