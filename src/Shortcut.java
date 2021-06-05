import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Shortcut {
    private static ScreenRecorder screenRecorder;

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
        Screenshot(driver, ".\\ScreenShot\\Test" + TestcaseNumber + ".png");
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
            call.getSelectFirstCard(driver).click();
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

    public static void Screenshot(WebDriver driver, String path) {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(path);
            FileUtils.copyFile(SrcFile, DestFile);
            System.out.println("Make screenshot successfully!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void StartScreenRecord() {
        try {
            System.out.println("Screen record started");
            GraphicsConfiguration config = GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration();

            screenRecorder = new ScreenRecorder(config,
                    config.getBounds(),
                    new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
                            ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                            QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO,
                            EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                    null,
                    new File(".\\ScreenRecorder"));

            screenRecorder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void StopScreenRecord() throws IOException {
        screenRecorder.stop();
        System.out.println("Screen record ended");
    }
}
