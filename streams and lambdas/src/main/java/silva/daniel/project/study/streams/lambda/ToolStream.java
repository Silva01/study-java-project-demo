package silva.daniel.project.study.streams.lambda;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ToolStream {

    public static void studyInfiniteStream() {
        // Create a stream infinite of numbers
        IntStream numbers = new Random().ints();

        // It is necessary to be careful with infinite streams, always use the short-circuit methods intelligently
        var num = numbers
                .limit(1)
                .boxed()
                .findFirst()
                .orElse(0);

        System.out.println(STR."Numero Obtido = \{num}");
    }

    public static void studyInfiniteStreamWithProblem() {
        // Create a stream infinite of numbers
        IntStream numbers = new Random().ints();

        // It is necessary to be careful with infinite streams, always use the short-circuit methods intelligently
        var num = numbers
                .filter(n -> n == 0)
                .boxed()
                .findFirst()
                .orElse(0);

        System.out.println(STR."Numero Obtido = \{num}");
    }

    public static void studyFlatMapStream() {
        var usuario1 = new Usuario("Daniel", List.of("Java", "Spring", "Hibernate"));
        var usuario2 = new Usuario("João", List.of("JS", "Node", "React"));

        List<Usuario> usuarios = List.of(usuario1, usuario2);

        // FlatMap is used to flatten a stream of streams
        usuarios.stream()
                .map(Usuario::getTags)
                .flatMap(List::stream)
                .distinct()
                .forEach(System.out::println);
    }

    public static void studyCreateMapWithStream() {
        var usuario1 = new Usuario("Daniel", List.of("Java", "Spring", "Hibernate"));
        var usuario2 = new Usuario("João", List.of("JS", "Node", "React"));

        List<Usuario> usuarios = List.of(usuario1, usuario2);

        // FlatMap is used to flatten a stream of streams
        Map<String, List<String>> map = usuarios.stream()
                .collect(Collectors.toMap(Usuario::getNome, Usuario::getTags));

        map.forEach((nome, tags) -> System.out.println(STR."Nome = \{nome} Tags = \{tags}"));
    }
}
