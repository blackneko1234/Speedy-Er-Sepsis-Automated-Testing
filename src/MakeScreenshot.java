import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class MakeScreenshot {
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
}
