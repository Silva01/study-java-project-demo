package silva.daniel.project.study.factory;

import silva.daniel.project.study.Process;
import silva.daniel.project.study.annotations.ReturnPersonalResponse;

import java.lang.reflect.InvocationTargetException;

public interface FactoryProcessor {

    static Object process(Class<?> clazz, Process process) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        if (clazz.isAnnotationPresent(ReturnPersonalResponse.class)) {
            ReturnPersonalResponse annotation = clazz.getAnnotation(ReturnPersonalResponse.class);
            Class<? extends Factory> factory = annotation.value();
            Factory instance = factory.getDeclaredConstructor().newInstance();
            return instance.create(process.process());
        }

        return process.process();
    }

}
