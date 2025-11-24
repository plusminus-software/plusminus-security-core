package software.plusminus.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import software.plusminus.security.service.CredentialService;
import software.plusminus.security.service.SecurityProvider;
import software.plusminus.security.service.TokenManager;

import java.util.List;

@Profile("!test")
@Component
public class SecurityContextCheck {

    @Autowired
    void check(List<SecurityProvider> securityProviders,
               List<CredentialService> credentialServices,
               List<TokenManager> tokenManagers) {
        if (securityProviders.isEmpty()) {
            throw new IllegalStateException("At least one SecurityProvider is expected to be present in the context");
        }
        if (credentialServices.isEmpty()) {
            throw new IllegalStateException("At least one CredentialService is expected to be present in the context");
        }
        if (tokenManagers.isEmpty()) {
            throw new IllegalStateException("At least one TokenManager is expected to be present in the context");
        }
    }
}
