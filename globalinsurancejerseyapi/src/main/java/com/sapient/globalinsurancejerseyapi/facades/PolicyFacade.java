package com.sapient.globalinsurancejerseyapi.facades;




import com.sapient.globalinsurancejerseyapi.models.Policy;

import java.sql.SQLException;
import java.util.List;

public interface PolicyFacade {

    boolean addPolicy(Policy policy) throws SQLException;
    List<Policy> getAllPolicies() throws SQLException;

    Policy getPolicyById(long policyNo) throws SQLException;


}
