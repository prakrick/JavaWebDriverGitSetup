package com.JavaWebDriverGit.TestScript;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
	,glue={"com.JavaWebDriverGit.InitialSetup"}
		,monochrome=true // more readable console output
				,tags={"@12","@13"}
		//,dryRun=true //:: checks and informs if there is any unimplemented mehtod
		)
public class TestRunner {


}

