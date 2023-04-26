# Example Spring Cloud API Gateway

An example use case of the Spring Cloud API Gateway to monitor and filter connection to microservice(s) wiht Eureka Client.

## Configuration

Edit `application.properties` to configure your service. Default port is `8082`
```
server.port = 8082
spring.application.name = api-gateway
eureka.client.service-url.default-zone = https://localhost:8761/eureka

spring.cloud.gateway.discovery.locator.lower-case-service-id = true
```

## Running your service
1. Start a local Eureka server.
2. Run the example API Gateway.
3. Check your server log. Seeing 

`Registered instance API-GATEWAY/<ip-address>:api-gateway:8082 with status UP`
means that your service has been successfully registered

## Current features
- Registering routes to other microservice(s):
```java
@Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/recipe/**")
                        .uri("lb://recipe-service")
                )
                .route(p -> p
                        .path("/order/**")
                        .uri("lb://order-service")
                )
                .build();
    }
```

This can be modified in `SpringApiGatewayApplication.java`.
* Automatic load balancing.

## Potential features
* Filters integration to routes.
* Circuit Breaker integration.
* Request Rate Limiting
* Integration with Spring Security
