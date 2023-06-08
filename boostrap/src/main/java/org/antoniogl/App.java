package org.antoniogl;

import org.antoniogl.ports.input.PricesManagementInputPort;
import org.antoniogl.ports.output.PricesManagementOutputPort;
import org.antoniogl.usecass.PricesManagementUseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.antoniogl"})
@EntityScan(basePackages = {"org.antoniogl.data"})
@EnableJpaRepositories(basePackages = {"org.antoniogl.repository"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    PricesManagementUseCase pricesManagementUseCase(PricesManagementOutputPort pricesManagementOutputPort) {
        return new PricesManagementInputPort(pricesManagementOutputPort);
    }
}