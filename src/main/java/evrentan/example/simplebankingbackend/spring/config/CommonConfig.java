package evrentan.example.simplebankingbackend.spring.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(value = "evrentan.example.simplebankingbackend")
@EnableJpaRepositories(value = "evrentan.example.simplebankingbackend.repository")
@EntityScan(value = "evrentan.example.simplebankingbackend.entity")
public class CommonConfig {
}
