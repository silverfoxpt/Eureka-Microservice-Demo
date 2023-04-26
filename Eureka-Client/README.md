# Example Eureka Client

An example use case of the Eureka client to register microservice to Eureka server.

## Configuration

Edit `application.properties` to configure your service. Default port is `8091`
```
# service name

spring.application.name=recipe-service

# port

server.port=8091

# eureka server url

eureka.client.service-url.default-zone=http://localhost:8761/eureka

spring.cloud.gateway.discovery.locator.enabled = true
```

## Running your service
1. Start a local Eureka server.
2. Run the example service.
3. Check your server log. Seeing 

`Registered instance RECIPE-SERVICE/<ip-address>:recipe-service:8091 with status UP`
means that your service has been successfully registered

## Provided API
- `/recipe/test`: return an example `Recipe` object
- `/recipe/port`: return the service's current port

- `/registration/register`: Register the service 
- `/registration/register/{status}`: Register service with custom status
- `/registration/set-status/{status}`: Set status of service
- `/registration/deregister`: De-register the service
