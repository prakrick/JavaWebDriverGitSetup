package com.JavaWebDriverGit.TestScript;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
	,glue={"com.JavaWebDriverGit.TestScript"}
		)
public class TestRunner {


}

