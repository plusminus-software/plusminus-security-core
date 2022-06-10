package software.plusminus.security;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenPlace {

    private String key;
    private boolean inHeaders = true;
    private boolean inCookies;

}
