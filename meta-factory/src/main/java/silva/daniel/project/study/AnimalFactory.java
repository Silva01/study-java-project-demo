package silva.daniel.project.study;

import silva.daniel.project.study.factory.Factory;

public class AnimalFactory implements Factory<String, Animal> {
    @Override
    public String create(Animal param) {
        return param.getName();
    }
}
