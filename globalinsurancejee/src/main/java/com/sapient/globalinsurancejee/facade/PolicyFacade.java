package com.sapient.globalinsurancejee.facade;


import com.sapient.globalinsurancejee.models.Policy;

import java.sql.SQLException;
import java.util.List;

public interface PolicyFacade {

    boolean addPolicy(Policy policy) throws SQLException;
    List<Policy> getAllPolicies() throws SQLException;


}
