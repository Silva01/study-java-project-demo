package silva.daniel.project.study.injection2;

import silva.daniel.project.study.injection1.Dependency;
import silva.daniel.project.study.injection2.annotations.Autowired;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class IoCContainer {
    private Map<Class<?>, Object> beans = new HashMap<>();

    public void registerBean(Class<?> clazz, Object instance) {
        beans.put(clazz, instance);
    }

    public void autowire(Object instance) {
        Class<?> clazz = instance.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Class<?> fieldType = field.getType();
                Object bean = beans.get(fieldType);
                if (bean == null) {
                    throw new RuntimeException("Bean of type " + fieldType.getName() + " not found in IoC container");
                }
                field.setAccessible(true);
                try {
                    field.set(instance, bean);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to inject dependency for field: " + field.getName(), e);
                }
            }
        }
    }

    public <T> T getBean(Class<T> clazz) {
        Object bean = beans.get(clazz);
        if (bean == null) {
            throw new RuntimeException("Bean of type " + clazz.getName() + " not found in IoC container");
        }
        return clazz.cast(bean);
    }
}
