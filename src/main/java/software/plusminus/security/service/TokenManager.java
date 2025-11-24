package software.plusminus.security.service;

import javax.annotation.Nullable;

public interface TokenManager {

    @Nullable
    String fetchToken();

    boolean setToken(String token);

    void clearToken();

}
