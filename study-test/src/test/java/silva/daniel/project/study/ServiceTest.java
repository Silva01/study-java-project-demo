package silva.daniel.project.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ServiceTest {

    @Mock
    private Service service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testName() {

        service.deleteName("Daniel");
        service.deleteName("Opa");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(service, times(2)).deleteName(captor.capture());
        assertThat(captor.getAllValues()).hasSize(2);
        assertThat(captor.getAllValues().get(0)).isEqualTo("Daniel");
        assertThat(captor.getAllValues().get(1)).isEqualTo("Opa");
    }
}