package software.plusminus.security.service;

import org.springframework.lang.Nullable;
import software.plusminus.security.model.Security;

public interface LoginProvider {

    @Nullable
    Security login(String username, String password);
    
}
