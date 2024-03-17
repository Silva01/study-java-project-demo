package silva.daniel.project.study.processor;

import com.google.auto.service.AutoService;
import silva.daniel.project.study.annotations.ReturnPersonalResponse;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.HashSet;
import java.util.Set;

@SupportedAnnotationTypes("ReturnPersonalResponse")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@AutoService(Processor.class)
public class UniqueAnnotationProcessor extends AbstractProcessor {

    private final Set<String> annotatedMethods = new HashSet<>();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(ReturnPersonalResponse.class)) {
            if (element.getKind() == ElementKind.METHOD) {
                String methodName = element.getSimpleName().toString();
                if (annotatedMethods.contains(methodName)) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                            "More than one method in the same class cannot be annotated with UniqueAnnotation", element);
                } else {
                    annotatedMethods.add(methodName);
                }
            }
        }
        return true;
    }
}
