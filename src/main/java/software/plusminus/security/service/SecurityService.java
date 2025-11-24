package software.plusminus.security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import software.plusminus.security.Security;
import software.plusminus.security.exception.SecurityException;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@AllArgsConstructor
@Service
public class SecurityService {

    private List<TokenManager> tokenManagers;
    private List<SecurityProvider> securityProviders;
    private List<CredentialService> credentialServices;

    @Nullable
    public Security getSecurity() {
        String token = tokenManagers.stream()
                .map(TokenManager::fetchToken)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
        if (token == null) {
            return null;
        }
        return securityProviders.stream()
                .map(securityProvider -> securityProvider.getSecurity(token))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    @Nullable
    public String getToken(String user, String password) {
        Security security = credentialServices.stream()
                .map(credentialService -> credentialService.provideSecurity(user, password))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
        if (security == null) {
            return null;
        }
        String token = securityProviders.stream()
                .map(securityProvider -> securityProvider.getToken(security))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
        if (token == null) {
            throw new SecurityException("Cannot get token for user " + user);
        }
        boolean tokenSet = tokenManagers.stream()
                .map(tokenManager -> tokenManager.setToken(token))
                .filter(value -> value)
                .findFirst()
                .orElse(Boolean.FALSE);
        if (!tokenSet) {
            throw new SecurityException("Cannot set token for user " + user);
        }
        return token;
    }

    public void clearToken() {
        tokenManagers.forEach(TokenManager::clearToken);
    }
}

