package silva.daniel.project.study.injection2;

import silva.daniel.project.study.injection1.annotations.LoadFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class LoadProcessor {
    public static <T> IoCContainer loadContext(Class<T> clazzType) {
        Package mainPackage = clazzType.getPackage();
        var ioCContainer = new IoCContainer();

        // Obtém o nome do pacote
        String packageName = mainPackage.getName();

        try {
            // Carrega todas as classes do pacote e subpacotes
            List<Class<?>> classes = getClasses(packageName);

            // Itera sobre as classes carregadas
            for (Class<?> clazz : classes) {
                System.out.println(clazz.getName());
                // Verifica se a classe está anotada com @Load
                if (clazz.isAnnotationPresent(LoadFactory.class)) {
                    // Cria uma instância da classe e a adiciona ao contêiner
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    ioCContainer.registerBean(clazz, instance);
                }
            }

            return ioCContainer;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Class<?>> getClasses(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> directories = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            directories.add(new File(resource.getFile()));
        }
        List<Class<?>> classes = new ArrayList<>();
        for (File directory : directories) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
