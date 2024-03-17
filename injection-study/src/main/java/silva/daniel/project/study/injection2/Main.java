package silva.daniel.project.study.injection2;

public class Main {
    public static void main(String[] args) {
        IoCContainer container = LoadProcessor.loadContext(Main.class);

        // Criar uma instância da classe que possui dependências
        Client client = new Client();

        // Injetar dependências automaticamente
        container.autowire(client);

        // Usar a instância
        client.doSomething();
    }
}
