package silva.daniel.project.study.injection1;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private static final Map<Class<?>, Object> instances = new HashMap<>();

    public static void addInstance(Class<?> clazz, Object instance) {
        instances.put(clazz, instance);
    }

    public static Object getInstance(Class<?> clazz) {
        return instances.get(clazz);
    }
}
