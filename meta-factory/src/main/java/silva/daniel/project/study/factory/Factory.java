package silva.daniel.project.study.factory;

public interface Factory<R, P> {
    R create(P param);
}
