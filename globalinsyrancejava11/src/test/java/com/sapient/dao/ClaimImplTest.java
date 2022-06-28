package com.sapient.dao;

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

public class ClaimImplTest {

    private ClaimFacade claimFacade;
    private Claim claim;
    private Vehicle vehicle;
    @BeforeEach
    public void createClaimDaoInstance(){
        claimFacade=new ClaimImpl("claims2022.csv");
        claim=new Claim(485685,34598459,
                450000,
                LocalDate.of(2022,2,12));
        vehicle=new Vehicle();
    }

    @Test
   @Tag("dev")
    public void addClaimTest(){
        try {
          assertTrue(claimFacade.addClaim(claim,vehicle));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void unLinkClaimInstances(){
        claim=null;
        vehicle=null;
        claimFacade=null;
    }
}
