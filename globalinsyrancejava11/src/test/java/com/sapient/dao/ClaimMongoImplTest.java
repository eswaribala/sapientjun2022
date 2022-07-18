package com.sapient.dao;

import com.sapient.facades.ClaimFacade;
import com.sapient.models.Claim;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClaimMongoImplTest {

    private ClaimFacade claimFacade;
    private Claim claim;


    @BeforeEach
    public void createClaimDaoInstance(){
        claimFacade=new ClaimMongoImpl();

        claim=new Claim(485685,34598459,
                40000,
                LocalDate.of(2022,4,12));

    }

    @Test
    @Tag("dev")
    public void addClaimTest(){

        assertTrue(claimFacade.addClaim(claim));
    }
    @Test
    @Tag("dev")
    public void updateClaimTest(){

        assertTrue(claimFacade.updateClaim( 485686,60000));
    }
    @Test
    @Tag("dev")
    public void searchClaimsTest(){

         assertThat(claimFacade.getAllClaims(),not(empty()));
    }
    @Test
    @Tag("dev")
    public void limitClaimsTest(){

        assertThat(claimFacade.getAllClaims(),hasSize(1));
    }
    @Test
    @Tag("dev")
    public void deleteClaimByIdTest(){

       assertTrue(claimFacade.deleteClaimById(485685));
    }
    @Test
    @Tag("dev")
    public void findClaimByIdTest(){

        assertNotNull(claimFacade.getClaimById(485685));
    }

    @AfterEach
    public void unLinkClaimInstances(){
        claim=null;
        claimFacade=null;
    }
}
