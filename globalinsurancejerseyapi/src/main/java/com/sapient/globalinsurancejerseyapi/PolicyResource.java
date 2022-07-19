package com.sapient.globalinsurancejerseyapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/policies")
public class PolicyResource {
    @GET
    @Produces("text/plain")
    public String getPolicies() {
        return "Accessing Policy Data";
    }
}