package com.sapient.dao;

import com.google.gson.Gson;
import com.sapient.facades.ClaimFacade;
import com.sapient.models.Claim;
import com.sapient.models.Vehicle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClaimMongoImplTest {

    private ClaimFacade claimFacade;
    private Claim claim;


    @BeforeEach
    public void createClaimDaoInstance(){
        claimFacade=new ClaimMongoImpl();

        claim=new Claim(485685,34598459,
                450000,
                LocalDate.of(2022,2,12));

    }

    @Test
    @Tag("dev")
    public void addClaimTest(){


          assertTrue(claimFacade.addClaim(claim));

    }

    @AfterEach
    public void unLinkClaimInstances(){
        claim=null;
        claimFacade=null;
    }
}
