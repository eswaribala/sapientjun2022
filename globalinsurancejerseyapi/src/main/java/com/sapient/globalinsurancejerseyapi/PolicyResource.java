package com.sapient.globalinsurancejerseyapi;

import com.sapient.globalinsurancejerseyapi.dao.PolicyImpl;
import com.sapient.globalinsurancejerseyapi.facades.PolicyFacade;
import com.sapient.globalinsurancejerseyapi.models.Policy;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/policies")
public class PolicyResource {
    private PolicyFacade policyFacade;
    private GenericEntity<List<Policy>> genentity;
    @GET

    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})

    public Response getPolicies() {

        try {
            policyFacade=new PolicyImpl();
            genentity = new GenericEntity<List<Policy>>(policyFacade.getAllPolicies()) {};



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(genentity)
                .build();

    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

    public Response addPolicy(Policy policy){
        boolean status=false;

        try {
            PolicyFacade policyFacade=new PolicyImpl();
           status= policyFacade.addPolicy(policy);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(status)
                .build();


    }

}