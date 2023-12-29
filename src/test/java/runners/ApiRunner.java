package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-reportsApi.html",
                "json:target/json-reports/cucumberApi.json",
                "junit:target/xml-report/cucumberApi.xml",
                "rerun:target/failedRerunApi.txt"
        },
        features = "src/test/resources/features/api",
        glue = {"stepdefinitions", "hooks/api"},
        tags = "@ism15",
        dryRun = false
)
public class ApiRunner {

    /*
        Runner class'i bos bir class'dir

        bu class'da asil isi

        Class'da kullandigimiz 2 notasyon yapar

        dryRun = true secildiginde
        Runner istenen featur/scenario'yu calistirmaya degil
        eksik adimlarini bulmaya odaklanir

        eger eksik adim yoksa
        test PASSED der.
        ama bu testin calisip, tum adimlarin gectigini gostermez
        SADECE eksik adim olmadigini gosterir

        EGER eksik adim bulma amacimiz yoksa
        testlerimizi normal olarak CALISTIRMAK istiyorsak
        dryRun = false secilmelidir
     */

}
