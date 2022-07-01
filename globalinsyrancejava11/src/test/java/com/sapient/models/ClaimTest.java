package com.sapient.models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ClaimTest {

    private Claim claim;
    private static  BufferedReader bufferedReader;
    private static ResourceBundle resourceBundle;
    private static String path;
    private static File file;
    private Vehicle vehicle;
    @BeforeAll
    public static void createClaimInstance(){
      resourceBundle=ResourceBundle.getBundle("db");
      path=resourceBundle.getString("path");
      file=new File(path,"country_wise_latest.csv");
        try {
            bufferedReader=new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    public void beforeEachTest(){
        claim=new Claim();
    }

    //@Test

    @Order(1)
    @RepeatedTest(5)
      // @DisabledOnOs(OS.WINDOWS)

    @DisplayName("Claim Not Null Test")
    @Tag("dev")
    public void claimNotNullTest(){
        assertNotNull(claim);
    }
    @Order(3)
    @ParameterizedTest
    @ValueSource(ints = {428578,3597349,3570837,10})
    @Tag("dev")
    public void claimIdNotZeroTest(int data){

        claim.setClaimId(data);
        assertTrue(claim.getClaimId()>0);
    }
    @Order(2)
    @ParameterizedTest

    @ValueSource(strings = {"2022-01-02","2022-03-04","2021-09-19"})
    @Tag("prod")
    public void claimDateNotCurrentDateTest(String data){

         claim.setClaimDate(LocalDate.parse(data));
         assertTrue(LocalDate.now().isAfter(claim.getClaimDate()));
    }
    @Order(4)
    @ParameterizedTest

    @Timeout(unit = TimeUnit.SECONDS,value = 500)
    @CsvFileSource(resources = "claims.csv", numLinesToSkip = 1)
    @Tag("prod")
    void testWithCsvFileSource(int claimId,int policyNo,long claimAmount,LocalDate claimDate) {

        claim.setClaimId(claimId);
        claim.setPolicyNo(policyNo);
        claim.setClaimAmount(claimAmount);
        claim.setClaimDate(claimDate);
        assertTrue(claim.getClaimAmount()>20000);

    }
    @Test
    public void vehicleNullPointerExceptionNegativeTest(){
        assertThrows(NullPointerException.class,()->vehicle.getModel());

    }

    @AfterEach
    public void afterEachTest(){
      claim=null;
    }


    @AfterAll
    public static void afterAllTests(){
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/*
    @Test
    @EnabledOnOs(OS.MAC)
    void testOnMacOs() {
        assertTrue(true);
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void doNotTestOnWindows() {
        assertTrue(true);
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void onlyOnJava8() {
        assertTrue(true);
    }

    @Test
    @EnabledOnJre({ JRE.JAVA_17, JRE.JAVA_18 })
    void onJava17Or18() {
        assertTrue(true);
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    void notFromJava8to11() {
        assertTrue(true);
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_12, max = JRE.JAVA_18)
    void fromJava12to18() {
        assertTrue(true);
    }

    @Test
    @EnabledIfSystemProperty(named = "any.system.property", matches = "value-regex*")
    public void onlyIfPropertyValueIsFound() {
        assertTrue(true);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    public void executeOnlyInDevEnvironment() {
        assertTrue(true);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*prod.*")
    public void disabledOnProdEnvironment() {
        assertTrue(true);
    }

    @Test
    @EnabledIf("customConditionalFunction")
    void enabled() {
        assertTrue(true);
    }

    @Test
    @DisabledIf("customConditionalFunction")
    void disabled() {
        assertTrue(true);
    }

    boolean customConditionalFunction() {
        return true;
    }
*/

}
