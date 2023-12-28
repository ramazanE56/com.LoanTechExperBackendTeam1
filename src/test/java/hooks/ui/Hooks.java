package hooks.ui;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.ByteArrayInputStream;

public class Hooks {

    @After
    public void tearDown(Scenario scenario){


        if (scenario.isFailed()) {
            // Alert çıktığında ekran görüntüsü almak için bekleme süresi ekleyin
            ReusableMethods.wait(1);

            // Alert'in çıktığını kontrol edin ve ekran görüntüsü almak için koşul ekleyin
            try {
                Alert alert = Driver.getDriver().switchTo().alert();
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }

            // Ekran görüntüsünü alın ve senaryoya ekleyin
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","screenshots");
            Allure.attachment("Failed Sceenshot", new ByteArrayInputStream(screenshot));

        }
        Driver.closeDriver();

    }


}

/*
    Hooks class'i tum scenario'lar icin calisacak
    @Before.... veya @After... notasyonlarina sahip method'lari icerir
    TestNg'deki TestBase class'lari gibidir

    Ancak TestNG'de TestBase class'ini ISTERSEK extends diyerek kullanabiliyorduk
    istemezsek kullanmiyorduk
    Cucumber yapisi geregi stepdefinitions package'i altinda
    @Before... veya @After... olursa
    her Scenario icin calisacaktir

    Bundan dolayi ozel bir durum yoksa
    Hooks class'ini sadece screenshot icin kullanacagiz
 */
