package silva.daniel.project.study.factory;

import silva.daniel.project.study.annotations.ReturnPersonalResponse;

import java.lang.reflect.InvocationTargetException;

public interface FactoryProcessor {

    static Object process(UseCase response) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        if (response.getClass().isAnnotationPresent(ReturnPersonalResponse.class)) {
            ReturnPersonalResponse annotation = response.getClass().getAnnotation(ReturnPersonalResponse.class);
            Class<? extends Factory> factory = annotation.value();
            Factory instance = factory.getDeclaredConstructor().newInstance();
            return instance.create(response.createBaseAnimal());
        }

        return response.createBaseAnimal();
    }

}
