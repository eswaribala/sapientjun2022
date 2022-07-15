package com.sapient.globalinsurancejee.facade;


import com.sapient.globalinsurancejee.models.Policy;

import java.sql.SQLException;

public interface PolicyFacade {

    boolean addPolicy(Policy policy) ;
}
