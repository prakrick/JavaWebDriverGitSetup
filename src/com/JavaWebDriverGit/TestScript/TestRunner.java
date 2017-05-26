package com.JavaWebDriverGit.TestScript;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
	,glue={"com.JavaWebDriverGit.TestScript"}
		,monochrome=true
		,dryRun=true //:: checks and imforms if there is any unimplemented mehtod
		)
public class TestRunner {


}

