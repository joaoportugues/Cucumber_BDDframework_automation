package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/featureFiles",  			// path to feature files
    glue = {"stepDefinitions","Hooks"},            			// package with step definitions and Hooks
    tags = "@all and not @dev and not @ignore and not @wip",// only run the tags @smoke and do not run dev, ignore , wip
    //publish = true,										// the created reports under target folder will be published on cloud on https://reports.cucumber.io, and deleted within a day
    dryRun = false,											//by default it runs all the feature files which do not have step definitions files associated, for dryRun =true, we are checking if there is any feature files without associated stepdefinition files so  the tests will not executed 
    plugin = {"pretty", 
    		   "html:target/CucumberReports/cucumber-reports.html",
    		   "json:target/CucumberReports/cucumber-reports.json",
    		   "junit:target/CucumberReports/cucumber-reports.xml",
    		 },		
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // This class remains empty - it's just a runner
}
