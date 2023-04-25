/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Eureka.Client;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.cloud.netflix.eureka.EurekaHealthCheckHandler;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACCOUNT_NOSYSADMIN
 */
@Service
public class InstanceRegistrationService implements ApplicationContextAware {
    private EurekaRegistration registration;
    private final ServiceRegistry<EurekaRegistration> serviceRegistry;
    private final EurekaInstanceConfigBean eurekaInstanceConfigBean;
    private final ApplicationInfoManager applicationInfoManager;
    private final EurekaClient eurekaClient;
    private final ObjectProvider<HealthCheckHandler> healthCheckHandler;
    private final DiscoveryClient discoveryClient;

    @Autowired
    public InstanceRegistrationService(ServiceRegistry<EurekaRegistration> serviceRegistry, @Autowired(required = false) EurekaRegistration registration, EurekaInstanceConfigBean eurekaInstanceConfigBean, ApplicationInfoManager applicationInfoManager, EurekaClient eurekaClient, ObjectProvider<HealthCheckHandler> healthCheckHandler, DiscoveryClient discoveryClient) {
        this.serviceRegistry = serviceRegistry;
        this.registration = registration;
        this.eurekaInstanceConfigBean = eurekaInstanceConfigBean;
        this.applicationInfoManager = applicationInfoManager;
        this.eurekaClient = eurekaClient;
        this.healthCheckHandler = healthCheckHandler;
        this.discoveryClient = discoveryClient;
    }

    InstanceInfo registerInstance(String status) {
        EurekaRegistration newRegistration = EurekaRegistration.builder(eurekaInstanceConfigBean)
                .with(applicationInfoManager)
                .with(eurekaClient)
                .with(healthCheckHandler)
                .build();

        serviceRegistry.register(newRegistration);
        serviceRegistry.setStatus(newRegistration, status);
        this.registration = newRegistration;
        return newRegistration.getApplicationInfoManager().getInfo();
    }

    InstanceInfo deregisterInstance() throws InterruptedException {
        serviceRegistry.setStatus(registration, "OUT_OF_SERVICE");
        // Give time for the OUT_OF_SERVICE status to propagate to all instances before shutdown
        Thread.sleep(60000L);
        serviceRegistry.deregister(registration);
        return registration.getApplicationInfoManager().getInfo();
    }

    InstanceInfo setStatus(String status) {
        if (registration != null) {
            serviceRegistry.setStatus(registration, status);
            return registration.getApplicationInfoManager().getInfo();
        } else {
            return null;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
