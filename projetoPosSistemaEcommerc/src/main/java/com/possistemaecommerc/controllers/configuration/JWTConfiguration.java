package com.possistemaecommerc.api.controllers.configuration;

import com.possistemaecommerc.filters.JWTAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfiguration {
        @Bean
        public FilterRegistrationBean<JWTAuthenticationFilter> jwtAuthenticationFilterFilterRegistrationBean(){
        FilterRegistrationBean<JWTAuthenticationFilter> filter=new FilterRegistrationBean<JWTAuthenticationFilter>();
        filter.setFilter(new JWTAuthenticationFilter());
        //maper os endpoints da Api que precisam de autenticação
          filter.addUrlPatterns("/api/usuarios/atualizar-dados");
          filter.addUrlPatterns(SWAGGER);
        return filter;
    }
    private static final String[] SWAGGER = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints
//of your API may be appended to this array
    };

}
