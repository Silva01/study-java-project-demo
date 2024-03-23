package silva.daniel.project.study;

import silva.daniel.project.study.factory.FactoryProcessor;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        long startTime = System.nanoTime();

        Runtime runtime = Runtime.getRuntime();

        // Consumo de memória antes da execução
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memória antes da execução: " + beforeMemory + " bytes");

        var service = new Service();
        var response = FactoryProcessor.process(service.getClass(), () -> service.createAnimal("Rino", 2));
        System.out.println(response);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Em milissegundos
        System.out.println("Tempo de execução: " + duration + "ms");

        long afterMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memória após a execução: " + afterMemory + " bytes");
    }
}
