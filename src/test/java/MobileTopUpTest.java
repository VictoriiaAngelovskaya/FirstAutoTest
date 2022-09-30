import Screens.MobileTopUpScreen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static Screens.MobileTopUpScreen.driver;

public class MobileTopUpTest {
    String ukrPhoneNumber = "637929825";
    String minAmount = "1";
    String testDebitCard = "5168742720441819";
    String monthYear = "1224";
    String cvvNumber = "123";
    String fromCardValue = "5168 **** **** 1819";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS );
        driver.get("https://next.privat24.ua/mobile");

    }

    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void checkTopUpMinSum() throws InterruptedException {
    MobileTopUpScreen mobileTopUpScreen = new MobileTopUpScreen(driver);
    mobileTopUpScreen.navigate();
    mobileTopUpScreen.fillPhoneNumber(ukrPhoneNumber);
    mobileTopUpScreen.fillAmount(minAmount);
    mobileTopUpScreen.setPaymentCard(testDebitCard);
    mobileTopUpScreen.fillExpireDate(monthYear);
    mobileTopUpScreen.fillCvv(cvvNumber);
    mobileTopUpScreen.submitButtonClick();
    Thread.sleep(3000);
       CartModal cartModal = new CartModal(driver);
        Assert.assertEquals(fromCardValue, cartModal.getTestCardValue());
    }
}

