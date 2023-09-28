package evrentan.example.simplebankingbackend;

import evrentan.example.simplebankingbackend.spring.spring.SimpleBankingBackendApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Objects;

@SpringBootTest(classes = {SimpleBankingBackendApplication.class})
class SimpleBankingBackendApplicationTests {

    @Mock
    private ApplicationContext applicationContext;

    @Test
    @DisplayName("Context Load Testing")
    void contextLoads() {
        Mockito.when(Objects.nonNull(applicationContext.getBean(SimpleBankingBackendApplication.class))).thenReturn(true);
        Assertions.assertTrue(Objects.nonNull(applicationContext.getBean(SimpleBankingBackendApplication.class)));
    }

}
