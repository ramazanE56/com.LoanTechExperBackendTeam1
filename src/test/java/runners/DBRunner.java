package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/default-cucumber-reportsDb.html",
                "json:target/json-reports/cucumberDb.json",
                "junit:target/xml-report/cucumberDb.xml",
                "rerun:target/failedRerunDb.txt"
        },
        features = "src/test/resources/features/db",
        glue = {"stepdefinitions", "hooks/db"},
        tags = "@MKR",
        dryRun = false

)
public class DBRunner {
}
