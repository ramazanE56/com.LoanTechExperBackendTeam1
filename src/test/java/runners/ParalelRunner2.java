package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-reports2.html",
                "json:target/json-reports/cucumber2.json",
                "junit:target/xml-report/cucumber2.xml"},
        monochrome = true,// raporların konsolda okunaklı çıkması için
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks/ui"},



        tags = "@e2e",

        dryRun = false
)
public class ParalelRunner2 {

}
