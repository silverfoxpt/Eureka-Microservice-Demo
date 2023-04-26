# Example Eureka server

An example use case of the Eureka server for registering, deregistering and monitoring microservice(s) implementing Eureka client.

## Configuration

Edit `application.properties` to configure your server. Default port is `8761`
```
# Give a name to the eureka server

spring.application.name=eureka-server

# default port for eureka server

server.port=8761

# eureka by default will register itself as a client. So, we need to set it to false.

eureka.client.register-with-eureka=false

eureka.client.fetch-registry=false
```

## Running your service
1. Start the Eureka server
2. Check your log. Seeing 

`Registering application EUREKA-SERVER with eureka with status UP`
means that your server has been successfully set up.

3. Check `http://localhost:8761` to access the default Eureka user interface.
