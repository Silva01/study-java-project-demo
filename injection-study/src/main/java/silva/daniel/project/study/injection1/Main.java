package silva.daniel.project.study.injection1;

import silva.daniel.project.study.injection1.annotations.Load;

public class Main {

    @Load
    private Dependency dependency;

    public void performAction() {
        DependenceInjector.injectDependencies(this);
        dependency.performAction();
    }

    public static void main(String[] args) {
        final var main = new Main();
        main.performAction();
    }
}
