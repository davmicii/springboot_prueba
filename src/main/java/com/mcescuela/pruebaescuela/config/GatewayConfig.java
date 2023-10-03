/*package com.mcescuela.pruebaescuela.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Autowired
    private TokenValidationFilter tokenValidationFilter;
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("maestros", r -> r
                        .path("/maestros/**")
                        .uri("lb://servicio-maestros"))
                .route("materias", r -> r
                        .path("/materias/**")
                        .uri("lb://servicio-materias"))
                .route("alumnos", r -> r
                        .path("/alumnos/**")
                        .uri("lb://servicio-alumnos"))
                .build();
    }
    @Bean
    public TokenValidationFilter tokenValidationFilter() {
        return new TokenValidationFilter();
    }

    @Bean
    public GlobalFilter tokenGlobalFilter() {
        return tokenValidationFilter;
    }
}
*/