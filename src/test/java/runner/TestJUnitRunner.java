package runner;

import io.cucumber.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features", monochrome = true,
        glue = "stepDefinition", tags = "@CheckOut",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-rep.html",
                "json:target/cucumber-reports/cucumber-rep.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        }
)
public class TestJUnitRunner {

}