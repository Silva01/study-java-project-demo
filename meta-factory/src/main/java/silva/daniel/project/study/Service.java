package silva.daniel.project.study;

import silva.daniel.project.study.annotations.ReturnPersonalResponse;
import silva.daniel.project.study.factory.UseCase;

@ReturnPersonalResponse(GatoFactory.class)
public class Service implements UseCase {

    @Override
    public Object createBaseAnimal() {
        var animal = new Animal();
        animal.setName("Base Animal");
        animal.setAge(1);
        animal.setType("Base");
        return animal;
    }

    public Object createAnimal(String name, int age) {
        var animal = new Animal();
        animal.setName(name);
        animal.setAge(age);
        animal.setType("Personality");
        return animal;
    }

    public Animal method2() {
        return new Animal();
    }
}
