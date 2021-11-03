package rs.carrot.productservice.security;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@RequiredArgsConstructor
public class FeignConfig {
    private final JwtProvider jwtProvider;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null)
                requestTemplate.header(HttpHeaders.AUTHORIZATION,
                        "Bearer " + jwtProvider.createToken(authentication.getName(), authentication.getAuthorities()));
        };
    }
}
