# Example Eureka Consumer Client

An example use case of the Eureka client to register microservice to Eureka server.
This client (`ORDER-SERVICE`) also request info from the other service (`RECIPE-SERVICE`).

## Configuration

Edit `application.properties` to configure your service. Default port is `8021`
```
# serivce name

spring.application.name=order-service

# port

server.port=8021

# eureka server url

eureka.client.service-url.default-zone=http://localhost:8761/eureka

spring.cloud.gateway.discovery.locator.enabled = true

```

## Running your service
1. Start a local Eureka server.
2. Run the example service.
3. Check your server log. Seeing 

`Registered instance ORDER-SERVICE/<ip-address>:order-service:8021 with status UP`
means that your service has been successfully registered

## Provided API
- `/order/test`: Call `RECIPE-SERVICE` for a test recipe, then construct and return a test order
