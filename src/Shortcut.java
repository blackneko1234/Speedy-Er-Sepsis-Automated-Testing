import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Shortcut {
    public static void login(WebDriver driver) {
        try {
            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement ClickLogin = driver.findElement(By.className("MuiButton-label"));
            username.sendKeys("Test");
            password.sendKeys("Test");
            ClickLogin.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void WindowsTerminateTask() {
        try {
            String[] os = System.getProperty("os.name").toLowerCase().split(" ");
            if (os[0].equals("windows")) {
                Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe /T");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ChromeOptions options() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    public static void DriverClose(Logger logger, WebDriver driver, int TestcaseNumber) {
        logger.debug(">>>>>>>>>>>>>>> End TestCase_" + TestcaseNumber + " <<<<<<<<<<<<<<< \n");
        MakeScreenshot.Screenshot(driver, ".\\ScreenShot\\Test" + TestcaseNumber + ".png");
        try {
            Thread.sleep(2000);
            driver.close();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void CallChromeDriver(WebDriver driver, String url) {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void DeleteTextInTextBox(WebElement element) {
        element.sendKeys(Keys.CONTROL, Keys.chord("a"));
        element.sendKeys(Keys.BACK_SPACE);
    }

    public static void getFirstCard(WebDriver driver, CallWebElement call) {
        try {
            Shortcut.login(driver);
            call.CallWebElementMainPageAfterCreatedPatient(driver);
            call.getSelectFirstCard().click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void AddCardPage(WebDriver driver, CallWebElement call) {
        try {
            Shortcut.login(driver);
            call.getAddButton(driver).click();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void LoggerTestCaseNumberAndName(Logger logger, int TestCaseNumber, String TestCaseName) {
        logger.debug(">>>>>>>>>>>>>>> TestCase_" + TestCaseNumber + ": " + TestCaseName + " <<<<<<<<<<<<<<< \n");
    }
}
