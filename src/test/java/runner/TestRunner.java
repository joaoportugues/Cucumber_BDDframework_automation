package runner;

import Hooks.MyHooks;
import io.cucumber.testng.*;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.reducers.ReducingMethod;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@CucumberOptions(
        features = "src/test/resources/featureFiles",            // path to feature files
        glue = {"stepDefinitions", "Hooks"},                        // package with step definitions and Hooks
        tags = "@all",// only run the tags @smoke and do not run dev, ignore , wip
        publish = false,                                        // the created reports under target folder will be published on cloud on https://reports.cucumber.io, and deleted within a day
        dryRun = false,                                            //by default it runs all the feature files which do not have step definitions files associated, for dryRun =true, we are checking if there is any feature files without associated stepdefinition files so  the tests will not executed
        plugin = {"pretty",
                //"html:target/cucumber-reports/cucumber-reports.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                //"junit:target/cucumber-reports/cucumber-reports.xml",
        },
        monochrome = false
)
public class TestRunner extends MyHooks {
    private TestNGCucumberRunner testNGCucumberRunner;
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddhhmmss");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddhhmmss");

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios", retryAnalyzer = Retry.class)
    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
        generateCucumberReport();
    }
    // This class remains empty - it's just a runner


    // mostly report configurations
    public void generateCucumberReport() {
        // where do the reports go and what name they have
        File reportOutputDirectory = new File("target\\cucumber-reports");

        // how many json files will be used for the report
        List<String> jsonFiles = new ArrayList<>();

        // currently only needs this specific file
        // can be changed to use wildcard and take all .json files
        jsonFiles.add("target/cucumber-reports/CucumberTestReport.json");

        // build number using a timestamp
        String buildNumber = sdf2.format(new Timestamp(System.currentTimeMillis()));

        // hardcoded iCargo version - env is received from CLI and defaults to TEST
        String projectName = "Mypost_Telecom_Mobile_Auto_WEB";

        // set report configuration
        // this will contain all information that will be displayed in the report - only visual aspects
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);

        // add the build number
        configuration.setBuildNumber(buildNumber);

        configuration.addReducingMethod(ReducingMethod.MERGE_FEATURES_WITH_RETEST);

        // add the browser
        //configuration.addClassifications("Browser", "Edge");

        // browser version
        //configuration.addClassifications("Version", "113");

        // sorting method
        configuration.setSortingMethod(SortingMethod.NATURAL);

        // expand all steps when opening the report
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);

        // handle parallel reporting
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);

        // hardcoded browser information
        //configuration.setQualifier("sample", "Edge 101, desktop");

        // points to the demo trends which is not used for other tests
        //configuration.setTrendsStatsFile(trendsFile);

        // some css for the looks
        configuration.addCustomCssFiles(Collections.singletonList("src/test/resources/css/stackoverflow-light.min.css"));

        // some js for the looks and feel
        configuration.addCustomJsFiles(Arrays.asList("src/test/resources/js/enable-highlighting.js", "src/test/resources/js/highlight.min.js"));

        // builder
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);

        // finally generate the report
        reportBuilder.generateReports();
    }

    public static class Retry implements IRetryAnalyzer {
        private static int retryCount = 0;

        public boolean retry(ITestResult result) {
            int maxRetryCount = 0;
            if (retryCount < maxRetryCount) {
                System.out.println("Retrying test " + result.getName() + " with status "
                        + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
                retryCount++;
                return true;
            }
            retryCount = 0;
            return false;
        }

        String getResultStatusName(int status) {
            String resultName = null;
            if (status == 1)
                resultName = "SUCCESS";
            if (status == 2)
                resultName = "FAILURE";
            if (status == 3)
                resultName = "SKIP";
            return resultName;
        }
    }
}