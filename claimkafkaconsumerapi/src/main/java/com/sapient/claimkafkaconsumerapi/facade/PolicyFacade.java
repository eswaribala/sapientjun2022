package com.sapient.claimkafkaconsumerapi.facade;

import com.sapient.claimkafkaconsumerapi.models.PSPolicy;

import java.util.List;

public interface PolicyFacade {

    public PSPolicy createPolicy(PSPolicy policy);
    public PSPolicy getPolicy(long policyNo);
    public PSPolicy updatePolicy(PSPolicy policy);
    public boolean deletePolicy(long policyNo);
    public List<PSPolicy> getAllPolicies();
}
