package silva.daniel.project.study;

import silva.daniel.project.study.factory.Factory;

public class GatoFactory implements Factory<Gato, Animal> {
    @Override
    public Gato create(Animal param) {
        var gato = new Gato();
        gato.setAge(param.getAge());
        gato.setName(param.getName() + " Criado para ser Gato");
        return gato;
    }
}
