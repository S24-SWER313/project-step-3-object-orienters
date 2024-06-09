package object_orienters.techspot.api_gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@Configuration
// @EnableConfigurationProperties(UriConfiguration.class)
@RestController
public class GatewayConfig {

        @Bean
        public RouteLocator myRoutes(RouteLocatorBuilder builder) {

                return builder
                                .routes().route(p -> p
                                                .path("/profiles/**")
                                                .filters(f -> f.rewritePath("/profiles/(?<segment>.*)",
                                                                "/profiles/${segment}"))
                                                .uri("http://localhost:8080"))
                                .route(p -> p
                                                .path("/content/**")
                                                .filters(f -> f.rewritePath("/content/(?<segment>.*)",
                                                                "/content/${segment}"))
                                                .uri("http://localhost:8080"))
                                .route(p -> p
                                                .path("/tags/**")
                                                .filters(f -> f.rewritePath("/tags/(?<segment>.*)",
                                                                "/tags/${segment}"))
                                                .uri("http://localhost:8080"))
                                .route(p -> p
                                                .path("/feed/**")
                                                .filters(f -> f.rewritePath("/feed/(?<segment>.*)",
                                                                "/feed/${segment}"))
                                                .uri("http://localhost:8080"))
                                .route(p -> p
                                                .path("auth/**")
                                                .filters(f -> f.rewritePath("/auth/(?<segment>.*)",
                                                                "/auth/${segment}"))
                                                .uri("http://localhost:8082"))
                                .route(p -> p     //FIXME
                                                .path("/**")
                                                .filters(f -> f.rewritePath("/(?<segment>.*)",
                                                                "/${segment}"))
                                                .uri("http://localhost:8081"))

                                .build();

        }

        @RequestMapping("/fallback")
        public Mono<String> fallback() {
                return Mono.just("fallback");
        }

}


