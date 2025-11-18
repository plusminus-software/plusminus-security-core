package software.plusminus.security.service;

import software.plusminus.security.model.Security;

import javax.annotation.Nullable;

public interface SecurityProvider {

    @Nullable
    Security provideSecurity();

}
