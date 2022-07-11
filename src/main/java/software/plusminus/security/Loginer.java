package software.plusminus.security;

import org.springframework.lang.Nullable;

public interface Loginer {

    @Nullable
    Security login(String username, String password);
    
}
