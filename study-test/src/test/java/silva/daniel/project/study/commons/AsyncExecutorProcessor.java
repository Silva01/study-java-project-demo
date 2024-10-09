package silva.daniel.project.study.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutorProcessor {


    public static ThreadNumberMatcher prepare() {
        return new ThreadExecutor(new ArrayList<>());
    }

    public interface ThreadNumberMatcher {
        ThreadPrepareMatcher withSizeThreads(int threadNumber);
    }

    public interface ThreadPrepareMatcher {
        ThreadPrepareMatcher withExecutionMethod(ExecutorMatcher executor);
        ThreadExecutorMatcher andWithExecutionMethod(ExecutorMatcher executor);

    }

    @FunctionalInterface
    public interface ExecutorMatcher {
        void execute() throws Exception;
    }

    public interface ThreadExecutorMatcher {
        void execute() throws Exception;
    }

    public final static class ThreadExecutor implements ThreadNumberMatcher, ThreadPrepareMatcher, ThreadExecutorMatcher {

        private final List<Callable<Void>> executors;
        private ExecutorService executorService;

        public ThreadExecutor(List<Callable<Void>> executors) {
            this.executors = executors;
        }

        @Override
        public void execute() {
            try {
                this.executorService.invokeAny(this.executors);
            } catch (ExecutionException | InterruptedException e) {
                this.executorService.shutdown();
                throw new RuntimeException(e);
            }
        }

        @Override
        public ThreadPrepareMatcher withSizeThreads(int threadNumber) {
            this.executorService = Executors.newFixedThreadPool(threadNumber);
            return this;
        }

        @Override
        public ThreadPrepareMatcher withExecutionMethod(ExecutorMatcher executor) {
            addExecutors(executor);
            return this;
        }

        @Override
        public ThreadExecutorMatcher andWithExecutionMethod(ExecutorMatcher executor) {
            addExecutors(executor);
            return this;
        }

        private void addExecutors(ExecutorMatcher executor) {
            this.executors.add(() -> {
                try {
                    executor.execute();
                    return null;
                } catch (Exception e) {
                    throw new ExecutionException(e);
                }
            });
        }
    }
}
