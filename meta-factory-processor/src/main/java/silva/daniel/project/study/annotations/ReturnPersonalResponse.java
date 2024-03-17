package silva.daniel.project.study.annotations;

import silva.daniel.project.study.Factory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ReturnPersonalResponse {
    Class<? extends Factory<?, ?>> factory();
    String method();
}
