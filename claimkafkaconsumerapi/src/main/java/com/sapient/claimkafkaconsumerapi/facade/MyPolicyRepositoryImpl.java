package com.sapient.claimkafkaconsumerapi.facade;

import com.sapient.claimkafkaconsumerapi.models.PSPolicy;

import com.sapient.claimkafkaconsumerapi.repositories.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
@Component
public class MyPolicyRepositoryImpl {

    @Autowired
    private PolicyRepository policyRepository;


    public void createPolicy(PSPolicy policy) {
       try {
           System.out.println("Entering...");
           System.out.println(policy);
           policyRepository.insert(policy);
       }
       catch(Exception ex){
           System.out.println("Exception"+ex.getMessage());
       }
    }


   public PSPolicy getPolicy(long policyNo) {
        return policyRepository.findById(policyNo).orElse(null);
    }


    public PSPolicy updatePolicy(PSPolicy policy) {
        Optional<PSPolicy> policyData = policyRepository.findById(policy.getPolicyNo());
        if (policyData.isPresent()) {
            PSPolicy _policy = policyData.get();
            _policy.setPolicyNo(policy.getPolicyNo());
            _policy.setPolicyName(policy.getPolicyName());
            _policy.setFromDate(policy.getFromDate());
            _policy.setToDate(policy.getToDate());
            _policy.setSumInsured(policy.getSumInsured());
            return _policy;
        } else {
            return null;
        }
    }


    public boolean deletePolicy(long policyNo) {
         policyRepository.deleteById(policyNo);
         if(getPolicy(policyNo)==null){
             return true;
         }
         return false;
    }


    public List<PSPolicy> getAllPolicies() {
        return policyRepository.findAll();
    }
}
