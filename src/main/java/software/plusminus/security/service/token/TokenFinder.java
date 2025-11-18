package software.plusminus.security.service.token;

import javax.annotation.Nullable;

public interface TokenFinder {

    @Nullable
    String findToken();

}
