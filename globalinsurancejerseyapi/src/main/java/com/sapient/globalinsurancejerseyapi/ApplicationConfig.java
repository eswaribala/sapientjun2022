package com.sapient.globalinsurancejerseyapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Swagger;
import io.swagger.util.Yaml;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Special-Projects-001 on 20/03/2019.
 */
@ApplicationPath("/api/v1")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet resources = new HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.sapient.globalinsurancejerseyapi.PolicyResource.class);
    }


}