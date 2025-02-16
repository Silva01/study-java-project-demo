package silva.daniel.project.study.streams.lambda;

import java.util.List;

public class Usuario {

    private final String nome;
    private final List<String> tags;

    public Usuario(String nome, List<String> tags) {
        this.nome = nome;
        this.tags = tags;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getTags() {
        return tags;
    }

}
