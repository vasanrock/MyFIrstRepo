package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = {"src/test/resources/SauseDemoFeatures"},
		glue = {"stepDefinitions", "hooks"},
		plugin = {"pretty", "html:report/cucumber-reports/report.html"},
		monochrome = true,
		dryRun = false
		) 	

public class TestRunner extends AbstractTestNGCucumberTests
{



}
