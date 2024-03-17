package silva.daniel.project.study;

public interface Factory<R, P> {
    R create(P param);
}
