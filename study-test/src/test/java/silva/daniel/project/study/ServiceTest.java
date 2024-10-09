package silva.daniel.project.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import silva.daniel.project.study.commons.AsyncExecutorProcessor;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ServiceTest {

    private Service service;

    @Captor
    ArgumentCaptor<String> captor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        var list = new ArrayList<String>();
        list.add("Daniel");
        list.add("Opa");
        this.service = new Service(list);
    }

    @Test
    void testName() throws Exception {

        service.deleteName("Daniel");
        service.deleteName("Opa");

        verify(service, times(2)).deleteName(captor.capture());
        assertThat(captor.getAllValues()).hasSize(2);
        assertThat(captor.getAllValues().get(0)).isEqualTo("Daniel");
        assertThat(captor.getAllValues().get(1)).isEqualTo("Opa");
    }

    @Test
    void parallelTest() {

        assertThatCode(() -> AsyncExecutorProcessor
                .prepare()
                    .withSizeThreads(2)
                    .withExecutionMethod(() -> service.deleteName("Daniel"))
                    .andWithExecutionMethod(() -> service.deleteName("Error"))
                    .execute())
            .doesNotThrowAnyException();
    }

    /**
     * Test static method mock
     */
    @Test
    void testStaticMethodMock() {
        try (MockedStatic<UUID> uuidMock = mockStatic(UUID.class)) {
            UUID uuidResultMock = UUID.fromString("00000000-0000-0000-0000-000000000000");
            uuidMock.when(UUID::randomUUID).thenReturn(uuidResultMock);

            assertThat(UUID.randomUUID()).isEqualTo(uuidResultMock);
        }
    }

    /**
     * Test constructor mock
     */
    @Test
    void testConstrutorMock() {
        try(MockedConstruction<Service> serviceMock = mockConstruction(Service.class, (mock, context) -> {
            when(mock.sizeListService()).thenReturn(2);
        })) {
            var calServiceList = new CalServiceList();
            assertThat(calServiceList.sizeListService()).isEqualTo(2);
        }
    }
}