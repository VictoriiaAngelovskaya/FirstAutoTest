package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartModal {
    By fromCard = By.xpath("//td[@data-qa-node='card']")
    private static WebDriver driver;
    public public class cartModal {
        this.driver = driver;
    }

    public String getTestCardValue(){
        return driver.findElement(fromCard).getText();
    }
}
