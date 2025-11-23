package software.plusminus.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import software.plusminus.context.Context;
import software.plusminus.security.Security;
import software.plusminus.security.service.SecurityProvider;

import java.util.List;
import java.util.Objects;

@Configuration
@ComponentScan("software.plusminus.security")
public class SecurityAutoconfig {

    @Bean
    Context<Security> securityContext(List<SecurityProvider> providers) {
        return Context.of(() -> providers.stream()
                .map(SecurityProvider::provideSecurity)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null));
    }
}
