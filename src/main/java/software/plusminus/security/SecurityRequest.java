package software.plusminus.security;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class SecurityRequest extends HttpServletRequestWrapper {

    private Security security;

    public SecurityRequest(HttpServletRequest request,
                          Security security) {

        super(request);
        this.security = security;
    }

    @Override
    public Principal getUserPrincipal() {
        return this::getRemoteUser;
    }

    @Override
    public String getRemoteUser() {
        return security.getUsername();
    }

    @Override
    public boolean isUserInRole(String role) {
        return security.getRoles().contains(role);
    }

    public Security getSecurity() {
        return security;
    }
}
