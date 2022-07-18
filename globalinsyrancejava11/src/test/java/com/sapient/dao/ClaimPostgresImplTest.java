package com.sapient.dao;

import com.sapient.facades.ClaimFacade;
import com.sapient.models.Claim;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClaimPostgresImplTest {
    private static final Logger logger = LoggerFactory.getLogger(ClaimPostgresImplTest.class);
    private ClaimFacade claimFacade;
    private Claim claim;


    @BeforeEach
    public void createClaimDaoInstance(){
        claim=new Claim(485687,34598461,
                60000,
                LocalDate.of(2022,6,16));
        try {
            claimFacade=new ClaimPostgresImpl();

        } catch (SQLException e) {
               logger.info(e.getMessage());
        }



    }

    @Test
    @Tag("dev")
    public void addClaimTest(){

        try {
            assertTrue(claimFacade.addPostgresClaim(claim));
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }
    @Test
    @Tag("dev")
    public void updateClaimTest(){

        try {
            assertTrue(claimFacade.updatePostgresClaim(485686,90000));
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }
    @Test
    @Tag("dev")
    public void searchClaimsTest(){

        try {
            assertThat(claimFacade.getAllPostgresClaims(),not(empty()));
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }
    @Test
    @Tag("dev")
    public void limitClaimsTest(){

        assertThat(claimFacade.getAllClaims(),hasSize(1));
    }
    @Test
    @Tag("dev")
    public void deleteClaimByIdTest(){

        try {
            assertTrue(claimFacade.deletePostgresClaimById(485685));
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }
    @Test
    @Tag("dev")
    public void findClaimByIdTest(){

        try {
            assertNotNull(claimFacade.getPostgresClaimById(485685));
        } catch (SQLException e) {
           logger.info(e.getMessage());
        }
    }

    @AfterEach
    public void unLinkClaimInstances(){
        claim=null;
        claimFacade=null;
    }
}
