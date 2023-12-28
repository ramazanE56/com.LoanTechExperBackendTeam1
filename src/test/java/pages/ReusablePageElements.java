package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class ReusablePageElements extends Driver {
    public ReusablePageElements() {
        PageFactory.initElements(driver,this);
    }

    public void navigateTo(String menuOption){
        driver.findElement(By.xpath("//span[.='"+menuOption+"']")).click();
    }

    public void clickOnButtonOf(String buttonText){
        if(driver.findElements(By.xpath("//span[.='"+buttonText+"']")).size()!=0){
            driver.findElement(By.xpath("//span[.='"+buttonText+"']")).click();
        }
        else if(driver.findElements(By.xpath("//a[.=' "+buttonText+" ']")).size()!=0){
            driver.findElement(By.xpath("//a[.=' "+buttonText+" ']")).click();
        }

    }
}

