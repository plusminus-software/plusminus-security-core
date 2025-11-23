package software.plusminus.security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import software.plusminus.security.Security;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@AllArgsConstructor
@Service
public class LoginService {

    private List<LoginProvider> providers;

    @Nullable
    public Security login(String username, String password) {
        return providers.stream()
                .map(loginProvider -> loginProvider.login(username, password))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }
}
