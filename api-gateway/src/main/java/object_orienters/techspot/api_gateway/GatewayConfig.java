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
        return builder.routes()
                .route("profilePost", p -> p
                        .path("/profiles")
                        .and().method(HttpMethod.POST)
                        // .filters(f -> f.rewritePath("/profiles/(?<username>.*)", "/profiles/${username}"))
                        .uri("http://localhost:8080"))

                // GET request for single profile
                .route("profileGet", p -> p
                        .path("/profiles/{username}")
                        .and().method(HttpMethod.GET)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)", "/profiles/${username}"))
                        .uri("http://localhost:8080"))

                // GET request for followers with pagination
                .route("followersGet", p -> p
                        .path("/profiles/{username}/followers")
                        .and().method(HttpMethod.GET)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)/followers", "/${username}/followers"))
                        .uri("http://localhost:8080"))

                // GET request for specific follower
                .route("specificFollowerGet", p -> p
                        .path("/profiles/{username}/follower")
                        .and().method(HttpMethod.GET)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)/follower", "/${username}/follower"))
                        .uri("http://localhost:8080"))

                // GET request for following list with pagination
                .route("followingGet", p -> p
                        .path("/profiles/{username}/following")
                        .and().method(HttpMethod.GET)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)/following", "/${username}/following"))
                        .uri("http://localhost:8080"))

                // GET request for specific following profile
                .route("specificFollowingGet", p -> p
                        .path("/profiles/{username}/following/{followingUsername}")
                        .and().method(HttpMethod.GET)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)/following/(?<followingUsername>.*)",
                                "/${username}/following/${followingUsername}"))
                        .uri("http://localhost:8080"))

                // PUT request for updating profile
                .route("profileUpdatePut", p -> p
                        .path("/profiles/{username}")
                        .and().method(HttpMethod.PUT)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)", "/profiles/${username}"))
                        .uri("http://localhost:8080"))

                // POST request for new follower
                .route("newFollowerPost", p -> p
                        .path("/profiles/{username}/followers")
                        .and().method(HttpMethod.POST)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)/followers", "/${username}/followers"))
                        .uri("http://localhost:8080"))

                // DELETE request for deleting follower
                .route("followerDelete", p -> p
                        .path("/profiles/{username}/followers")
                        .and().method(HttpMethod.DELETE)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)/followers", "/${username}/followers"))
                        .uri("http://localhost:8080"))

                // DELETE request for deleting following
                .route("followingDelete", p -> p
                        .path("/profiles/{username}/following")
                        .and().method(HttpMethod.DELETE)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)/following", "/${username}/following"))
                        .uri("http://localhost:8080"))

                // POST request for adding profile picture
                .route("profilePicPost", p -> p
                        .path("/profiles/{username}/profilePic")
                        .and().method(HttpMethod.POST)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)/profilePic", "/${username}/profilePic"))
                        .uri("http://localhost:8080"))

                // POST request for adding background image
                .route("backgroundImgPost", p -> p
                        .path("/profiles/{username}/backgroundImg")
                        .and().method(HttpMethod.POST)
                        .filters(f -> f.rewritePath("/profiles/(?<username>.*)/backgroundImg",
                                "/${username}/backgroundImg"))
                        .uri("http://localhost:8080"))

                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

}

// @ConfigurationProperties
// class UriConfiguration {

// private String httpbin = "http://httpbin.org:80";

// public String getHttpbin() {
// return httpbin;
// }

// public void setHttpbin(String httpbin) {
// this.httpbin = httpbin;
// }
// }
