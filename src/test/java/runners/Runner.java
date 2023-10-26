package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/default-cucumber-reports.html",
        "json:target/json-reports/cucumber1.json",
        "junit:target/xml-report/cucumber.xml",
        "rerun:TestOutput/failed_scenario.txt",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},
        features = "src/test/resources/features",
        glue = {"stepDefinition"},

        tags ="@homepage_title",

        dryRun = false,
        monochrome = true

)


public class Runner {
}
