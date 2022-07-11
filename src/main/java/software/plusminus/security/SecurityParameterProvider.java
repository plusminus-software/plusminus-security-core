package software.plusminus.security;

import org.springframework.lang.Nullable;

import java.util.Map;

public interface SecurityParameterProvider {
    
    @Nullable
    Map.Entry<String, String> provideParameter();
    
}
