package evrentan.example.simplebankingbackend.spring.spring;

import evrentan.example.simplebankingbackend.spring.config.CommonConfig;
import evrentan.example.simplebankingbackend.spring.config.SwaggerConfig;
import evrentan.example.simplebankingbackend.spring.config.TransactionManagementConfig;
import evrentan.example.simplebankingbackend.spring.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(
        value = {
                CommonConfig.class,
                SwaggerConfig.class,
                TransactionManagementConfig.class,
                WebConfig.class
        }
)
public class SimpleBankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleBankingBackendApplication.class, args);
    }

}
