package com.example.antin_cinema_backend.config;

import com.example.antin_cinema_backend.security.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    // CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    // INTERCEPTOR - Thêm JWT Interceptor vào đây luôn
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/v1/movie/**")
                .excludePathPatterns("/api/v1/user/**")
                .excludePathPatterns("/api/v1/guest/**")
                .excludePathPatterns("/api/v1/auth/**"); // Không chặn login/register
    }
}
