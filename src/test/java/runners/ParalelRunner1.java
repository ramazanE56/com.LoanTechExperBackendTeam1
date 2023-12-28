package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-reports1.html",
                "json:target/json-reports/cucumber1.json",
                "junit:target/xml-report/cucumber1.xml"},
        monochrome = true,// raporların konsolda okunaklı çıkması için
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks/ui"},
        tags = "@smoke",
        dryRun = false
)
public class ParalelRunner1 {
}
