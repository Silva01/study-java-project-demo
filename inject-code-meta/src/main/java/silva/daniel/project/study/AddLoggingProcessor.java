package silva.daniel.project.study;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import java.io.PrintWriter;
import java.util.Set;

@SupportedAnnotationTypes("AddLogging")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class AddLoggingProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(AddLogging.class)) {
            if (element.getKind() == ElementKind.METHOD) {
                ExecutableElement method = (ExecutableElement) element;
                if (!method.getModifiers().contains(Modifier.STATIC)) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,
                            "Skipping non-static method: " + method.getSimpleName());
                    continue;
                }

                String methodName = method.getSimpleName().toString();
                String className = method.getEnclosingElement().getSimpleName().toString();
                String loggerName = className + "." + methodName;
                String loggerStatement = "System.out.println(\"Logging: " + loggerName + "\");";

                try {
                    PrintWriter writer = new PrintWriter(methodName + ".log");
                    writer.println(loggerStatement);
                    writer.close();
                } catch (Exception e) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                            "Failed to write logging statement for method " + methodName);
                }
            }
        }
        return false;
    }
}
