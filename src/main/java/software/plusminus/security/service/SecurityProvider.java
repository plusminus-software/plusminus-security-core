package software.plusminus.security.service;

import software.plusminus.security.Security;

import javax.annotation.Nullable;

public interface SecurityProvider {

    @Nullable
    Security provideSecurity();

}
