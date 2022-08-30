package com.amex.cucumberdemo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber-reports","json:target/cucumber.json"},features = {
		"classpath:com/amex/cucumberdemo/login.feature"
		},glue="com.amex.cucumberdemo")
public class RunCucumberTest {

}
