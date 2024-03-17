package silva.daniel.project.study.injection1;

import silva.daniel.project.study.injection1.annotations.Load;

import java.lang.reflect.Field;

public class DependenceInjector {
    public static void injectDependencies(Object object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Load.class)) {
                try {
                    Class<?> dependencyClass = field.getType();
                    Object dependencyInstance = dependencyClass.getDeclaredConstructor().newInstance();
                    field.setAccessible(true);
                    field.set(object, dependencyInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
