package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-reportsBackend.html",
                "json:target/json-reports/cucumberBackend.json",
                "junit:target/xml-report/cucumberBackend.xml",
                "rerun:target/failedRerunBackend.txt"},
        monochrome = true,// raporların konsolda okunaklı çıkması için
        features = {"src/test/resources/features/api","src/test/resources/features/db"},
        glue = {"stepdefinitions", "hooks/api","hooks/db"},
        tags = "@api or @db",
        dryRun = false



)
public class BackendRunner {

}
