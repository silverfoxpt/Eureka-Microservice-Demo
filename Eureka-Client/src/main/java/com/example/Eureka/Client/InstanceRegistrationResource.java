
package com.example.Eureka.Client;

import com.example.Eureka.Client.InstanceRegistrationService;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration")
public class InstanceRegistrationResource {
    private final InstanceRegistrationService instanceRegistrationService;

    public InstanceRegistrationResource(InstanceRegistrationService instanceRegistrationService) {
        this.instanceRegistrationService = instanceRegistrationService;
    }

    @PostMapping("register")
    public void registerInstance() {
        instanceRegistrationService.registerInstance("UP");
    }

    @PostMapping("register/{status}")
    public InstanceInfo registerInstanceWithCustomStatus(@PathVariable("status") InstanceInfo.InstanceStatus status) {
        return instanceRegistrationService.registerInstance(status.toString());
    }

    @PostMapping("set-status/{status}")
    public InstanceInfo setInstanceStatus(@PathVariable("status") InstanceInfo.InstanceStatus status) {
        return instanceRegistrationService.setStatus(status.toString());
    }

    @PostMapping("deregister")
    public InstanceInfo deregisterInstance() throws InterruptedException {
        return instanceRegistrationService.deregisterInstance();
    }
}