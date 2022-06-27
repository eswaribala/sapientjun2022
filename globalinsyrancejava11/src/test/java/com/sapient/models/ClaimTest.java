package com.sapient.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class ClaimTest {

    private static Claim claim;

    @BeforeAll
    public static void createClaimInstance(){
        claim=new Claim();
    }

    @Test
    @DisplayName("Claim Not Null Test")
    public void claimNotNullTest(){
        assertNotNull(claim);
    }

    @ParameterizedTest
    @ValueSource(ints = {428578,3597349,3570837,0})
    public void claimIdNotZeroTest(int data){

        claim.setClaimId(data);
        assertTrue(claim.getClaimId()>0);
    }
    @ParameterizedTest
    @ValueSource(strings = {"2022-01-02","2022-03-04","2021-09-19"})
    public void claimDateNotCurrentDateTest(String data){

         claim.setClaimDate(LocalDate.parse(data));
         assertTrue(LocalDate.now().isAfter(claim.getClaimDate()));
    }
    @ParameterizedTest
    @Timeout(unit = TimeUnit.NANOSECONDS,value = 5)
    @CsvFileSource(resources = "./claims.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(int claimId,int policyNo,long claimAmount,LocalDate claimDate) {

        claim.setClaimId(claimId);
        claim.setPolicyNo(policyNo);
        claim.setClaimAmount(claimAmount);
        claim.setClaimDate(claimDate);
        assertTrue(claim.getClaimAmount()>20000);
        
    }



}
