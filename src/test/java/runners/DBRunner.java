package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-reportsDb.html",
                "json:target/json-reports/cucumberDb.json",
                "junit:target/xml-report/cucumberDb.xml",
                "rerun:target/failedRerunDb.txt"},
        monochrome = true,// raporların konsolda okunaklı çıkması için
        features = "src/test/resources/features/db",
        glue = {"stepdefinitions", "hooks/db"},

        tags = "@DB",

        //tags = "@q05",

        dryRun = false

)
public class DBRunner {
}
