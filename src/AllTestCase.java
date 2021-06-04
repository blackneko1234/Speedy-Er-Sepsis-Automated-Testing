import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;

public class AllTestCase {
    protected static Logger logger = Logger.getLogger("Test");
    private static final CallWebElement call = new CallWebElement();
    private static final String url = "https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/signin";
    private static final String Selected = "MuiButtonBase-root MuiButton-root jss1045 MuiButton-outlined jss1022 jss1023";
    private static final String NotSelected = "MuiButtonBase-root MuiButton-root jss1045 MuiButton-outlined jss1022";

    public static void Test1() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 1, "Login system");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {
            WebElement ClickLogin = driver.findElement(By.className("MuiButton-label"));
            //Test login but not enter the username and password
            logger.debug("========= Test login but not enter the username and password =========");
            ClickLogin.click();
            if (driver.findElement(By.id("username-helper-text")).isDisplayed()
                    && driver.findElement(By.id("password-helper-text")).isDisplayed()) {
                logger.info("Pass: When click login without enter the username and password it will show the red message");
            } else {
                logger.error("Fail");
            }
            Thread.sleep(2000);

            //Test login but not enter password
            logger.debug("========= Test login but not enter password =========");
            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("Test");
            ClickLogin.click();
            if (driver.findElement(By.id("password-helper-text")).isDisplayed()) {
                logger.info("Pass: When click login without enter the password it will show the red message");
            } else {
                logger.error("Fail");
            }
            Shortcut.DeleteTextInTextBox(username);
            Thread.sleep(2000);

            //Test login but not enter username
            logger.debug("========= Test login but not enter username =========");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("Test");
            driver.findElement(By.className("MuiButton-label")).click();
            if (driver.findElement(By.id("username-helper-text")).isDisplayed()) {
                logger.info("Pass: When click login without enter the username it will show the red message");
            } else {
                logger.error("Fail");
            }
            Shortcut.DeleteTextInTextBox(password);
            Thread.sleep(2000);

            //Test login
            logger.debug("========= Test login =========");
            Shortcut.login(driver);
            String getUrl = driver.getCurrentUrl();
            if (getUrl.equals("https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/dashboard")) {
                logger.info("Pass: User can login to the website");
            } else {
                logger.error("Fail: The Url is" + getUrl);
            }
            Shortcut.DriverClose(logger, driver, 1);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 1);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test2() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 2, "Show username");

        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {
            //Show username at the top right of website
            logger.debug("========= Show username at the top right of website =========");
            Shortcut.login(driver);

            String AfterLoginUsername = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/header/div/div[2]/p")).getText();
            AfterLoginUsername = AfterLoginUsername.substring(1, AfterLoginUsername.length() - 1);
            if (AfterLoginUsername.equals("Test")) {
                logger.info("Pass: Username before login equal to username after login");
            } else {
                logger.error("Fail: Username before login not equal to username after login");
            }
            Shortcut.DriverClose(logger, driver, 2);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 2);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test3() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 3, "Add patient");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.AddCardPage(driver, call);

            //Add patient
            call.CallWebElementAddPage(driver);
            call.getFullName().sendKeys("Automated Test By DJ");
            call.getHN().sendKeys("1234");
            call.getGender().click();

            call.getMaleOrYear(driver).click();

            call.getAge().sendKeys("999");
            call.getAgeUnit().click();

            call.getMaleOrYear(driver).click();

            call.getTemp().sendKeys("999");
            call.getPR().sendKeys("300");
            call.getRR().sendKeys("100");
            call.getBP1().sendKeys("1");
            call.getBP2().sendKeys("2");
            call.getO2SAT().sendKeys("100");
            call.getO2Th().sendKeys("1");
            call.getFever().click();
            call.getSuspected().click();
            call.getHistory().click();
            call.getVoice().click();
            call.getSubmit().click();
            logger.info("Pass: Add patient successfully");

            Shortcut.DriverClose(logger, driver, 3);

        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 3);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test4() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 4, "Current time when add patient");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.AddCardPage(driver, call);

            call.CallWebElementAddPage(driver);
            String CurrentTime = java.time.LocalTime.now().toString().substring(0, 5);
            if (call.getTime().getText().equals(CurrentTime)) {
                logger.info("Pass: Current time in the website is match to the real current time");
            } else {
                logger.error("Fail: Current time in the website is not match to the real current time");
            }
            Shortcut.DriverClose(logger, driver, 4);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 4);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test5() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 5, "Can save the data when add all patient detail");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.AddCardPage(driver, call);

            String getUrl = driver.getCurrentUrl();
            if (getUrl.equals("https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/case/add")) {
                //Add patient detail not all
                call.CallWebElementAddPage(driver);
                //Not enter FullName
                call.getHN().sendKeys("1234");
                call.getGender().click();

                call.getFemaleOrMonth(driver).click();

                call.getAge().sendKeys("999");
                call.getAgeUnit().click();

                call.getMaleOrYear(driver).click();

                call.getTemp().sendKeys("999");
                call.getPR().sendKeys("300");
                call.getRR().sendKeys("100");
                call.getBP1().sendKeys("1");
                call.getBP2().sendKeys("2");
                call.getO2SAT().sendKeys("100");
                call.getO2Th().sendKeys("1");
                call.getFever().click();
                call.getVoice().click();
                call.getSubmit().click();

                WebElement NameNotify = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[1]/div/div[3]/div/div[1]/div/p"));
                if (NameNotify.getText().equals("Please enter correct name.")) {
                    logger.info("Pass: If not enter all detail the website will not save the data");
                } else {
                    logger.error("Fail: Not enter all detail but the data was saved");
                }
            } else {
                logger.error("Fail: Cannot access to the add page");
            }
            Shortcut.DriverClose(logger, driver, 5);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 5);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test6() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 6, "Can selected only one consciousness");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.AddCardPage(driver, call);

            call.CallWebElementAddPage(driver);
            call.getAlert().click();
            if (call.getAlert().isSelected() && !call.getVoice().isSelected() && !call.getPain().isSelected() && !call.getUnresponsive().isSelected()) {
                logger.info("Pass: Alert is selected only");
            } else {
                logger.error("Fail: Radio is selected more than one");
            }
            Thread.sleep(1000);

            call.getVoice().click();
            if (!call.getAlert().isSelected() && call.getVoice().isSelected() && !call.getPain().isSelected() && !call.getUnresponsive().isSelected()) {
                logger.info("Pass: Voice is selected only");
            } else {
                logger.error("Fail: Radio is selected more than one");
            }
            Thread.sleep(1000);

            call.getPain().click();
            if (!call.getAlert().isSelected() && !call.getVoice().isSelected() && call.getPain().isSelected() && !call.getUnresponsive().isSelected()) {
                logger.info("Pass: Pain is selected only");
            } else {
                logger.error("Fail: Radio is selected more than one");
            }
            Thread.sleep(1000);

            call.getUnresponsive().click();
            if (!call.getAlert().isSelected() && !call.getVoice().isSelected() && !call.getPain().isSelected() && call.getUnresponsive().isSelected()) {
                logger.info("Pass: Unresponse is selected only");
            } else {
                logger.error("Fail: Radio is selected more than one");
            }
            Shortcut.DriverClose(logger, driver, 6);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 6);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test7() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 7, "Value cannot breakout the limit");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.AddCardPage(driver, call);

            String getUrl = driver.getCurrentUrl();
            if (getUrl.equals("https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/case/add")) {
                call.CallWebElementAddPage(driver);
                call.getAgeUnit().click();

                call.getMaleOrYear(driver).click();

                call.getAge().sendKeys("99999");
                if (call.getAge().getAttribute("value").equals("999")) {
                    logger.info("Pass: Age (Year) is not breakout the limit");
                } else {
                    logger.error("Fail: Age (Year) is breakout the limit");
                }
                call.getAge().clear();

                call.getAgeUnit().click();

                call.getFemaleOrMonth(driver).click();

                call.getAge().sendKeys("99999");
                if (call.getAge().getAttribute("value").equals("12")) {
                    logger.info("Pass: Age (Month) is not breakout the limit");
                } else {
                    logger.error("Fail: Age (Month) is breakout the limit");
                }

                call.getTemp().sendKeys("9999");
                if (call.getTemp().getAttribute("value").equals("100")) {
                    logger.info("Pass: Temp is not breakout the limit");
                } else {
                    logger.error("Fail: Temp is breakout the limit");
                }
                call.getPR().sendKeys("30099");
                if (call.getPR().getAttribute("value").equals("300")) {
                    logger.info("Pass: PR is not breakout the limit");
                } else {
                    logger.error("Fail: PR is breakout the limit");
                }
                call.getRR().sendKeys("10099");
                if (call.getRR().getAttribute("value").equals("100")) {
                    logger.info("Pass: RR is not breakout the limit");
                } else {
                    logger.error("Fail: RR is breakout the limit");
                }
                call.getBP1().sendKeys("1999");
                if (call.getBP1().getAttribute("value").equals("999")) {
                    logger.info("Pass: BP1 is not breakout the limit");
                } else {
                    logger.error("Fail: BP1 is breakout the limit");
                }
                call.getBP2().sendKeys("29999");
                if (call.getBP2().getAttribute("value").equals("999")) {
                    logger.info("Pass: BP2 is not breakout the limit");
                } else {
                    logger.error("Fail: BP2 is breakout the limit");
                }
                call.getO2SAT().sendKeys("1099");
                if (call.getO2SAT().getAttribute("value").equals("100")) {
                    logger.info("Pass: O2SAT is not breakout the limit");
                } else {
                    logger.error("Fail: O2SAT is breakout the limit");
                }
                call.getO2Th().sendKeys("1999");
                if (call.getO2Th().getAttribute("value").equals("15")) {
                    logger.info("Pass: O2Th is not breakout the limit");
                } else {
                    logger.error("Fail: O2Th is breakout the limit");
                }
            } else {
                logger.error("Fail: Cannot access to the add page");
            }
            Shortcut.DriverClose(logger, driver, 7);

        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 7);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test8() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 8, "Value cannot negative");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {
            Shortcut.AddCardPage(driver, call);

            String getUrl = driver.getCurrentUrl();
            if (getUrl.equals("https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/case/add")) {
                call.CallWebElementAddPage(driver);
                call.getAge().sendKeys("-1000");
                if (Integer.parseInt(call.getAge().getAttribute("value")) > 0) {
                    logger.info("Pass: Age (Year) is positive");
                } else {
                    logger.error("Fail: Age (Year) is negative");
                }
                call.getAge().clear();

                call.getAgeUnit().click();

                call.getFemaleOrMonth(driver).click();

                call.getAge().sendKeys("-1000");
                if (Integer.parseInt(call.getAge().getAttribute("value")) > 0) {
                    logger.info("Pass: Age (Month) is positive");
                } else {
                    logger.error("Fail: Age (Month) is negative or not more than 0");
                }
                call.getTemp().sendKeys("-10000");
                if (Integer.parseInt(call.getTemp().getAttribute("value")) > 0) {
                    logger.info("Pass: Temp is positive");
                } else {
                    logger.error("Fail: Temp is negative or not more than 0");
                }
                call.getPR().sendKeys("-900");
                if (Integer.parseInt(call.getPR().getAttribute("value")) > 0) {
                    logger.info("Pass: PR is positive");
                } else {
                    logger.error("Fail: PR is negative");
                }
                call.getRR().sendKeys("-900");
                if (Integer.parseInt(call.getRR().getAttribute("value")) > 0) {
                    logger.info("Pass: RR is positive");
                } else {
                    logger.error("Fail: RR is negative");
                }
                call.getBP1().sendKeys("-900");
                if (Integer.parseInt(call.getBP1().getAttribute("value")) > 0) {
                    logger.info("Pass: BP1 is positive");
                } else {
                    logger.error("Fail: BP1 is negative");
                }
                call.getBP2().sendKeys("-900");
                if (Integer.parseInt(call.getBP2().getAttribute("value")) > 0) {
                    logger.info("Pass: BP2 is positive");
                } else {
                    logger.error("Fail: BP2 is negative");
                }
                call.getO2SAT().sendKeys("-900");
                if (Integer.parseInt(call.getO2SAT().getAttribute("value")) > 0) {
                    logger.info("Pass: O2SAT is positive");
                } else {
                    logger.error("Fail: O2SAT is negative");
                }
                call.getO2Th().sendKeys("-910");
                if (Integer.parseInt(call.getO2Th().getAttribute("value")) > 0) {
                    logger.info("Pass: O2Th is positive");
                } else {
                    logger.error("Fail: O2Th is negative");
                }
            } else {
                logger.error("Fail: Cannot access to the add page");
            }
            Shortcut.DriverClose(logger, driver, 8);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 8);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test9() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 9, "When edit data the value cannot be negative");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            call.CallWebElementEditPage(driver);

            Shortcut.DeleteTextInTextBox(call.getHN());

            call.getHN().sendKeys("-1234");
            if (Integer.parseInt(call.getHN().getAttribute("value")) > 0) {
                logger.info("Pass: HN is positive");
            } else {
                logger.error("Fail: HN is negative");
            }

            Shortcut.DeleteTextInTextBox(call.getAge());

            call.getAge().sendKeys("-100");
            if (Integer.parseInt(call.getAge().getAttribute("value")) > 0) {
                logger.info("Pass: Age (Year) is positive");
            } else {
                logger.error("Fail: Age (Year) is negative or not more than 0");
            }

            call.getAgeUnit().click();

            call.getFemaleOrMonth(driver).click();

            Shortcut.DeleteTextInTextBox(call.getAge());
            call.getAge().sendKeys("-100");
            if (Integer.parseInt(call.getAge().getAttribute("value")) > 0) {
                logger.info("Pass: Age (Month) is positive");
            } else {
                logger.error("Fail: Age (Month) is negative or not more than 0");
            }

            call.CallWebElementAssessPage(driver);

            Shortcut.DeleteTextInTextBox(call.getTemp());
            call.getTemp().sendKeys("-10");
            if (Integer.parseInt(call.getTemp().getAttribute("value")) > 0) {
                logger.info("Pass: Temp is positive");
            } else {
                logger.error("Fail: Temp is negative");
            }

            Shortcut.DeleteTextInTextBox(call.getPR());
            call.getPR().sendKeys("-1");
            if (Integer.parseInt(call.getPR().getAttribute("value")) > 0) {
                logger.info("Pass: PR is positive");
            } else {
                logger.error("Fail: PR is negative");
            }

            Shortcut.DeleteTextInTextBox(call.getRR());
            call.getRR().sendKeys("-9");
            if (Integer.parseInt(call.getRR().getAttribute("value")) > 0) {
                logger.info("Pass: RR is positive");
            } else {
                logger.error("Fail: RR is negative");
            }

            Shortcut.DeleteTextInTextBox(call.getBP1());
            call.getBP1().sendKeys("-9");
            if (Integer.parseInt(call.getBP1().getAttribute("value")) > 0) {
                logger.info("Pass: BP1 is positive");
            } else {
                logger.error("Fail: BP1 is negative");
            }

            Shortcut.DeleteTextInTextBox(call.getBP2());
            call.getBP2().sendKeys("-9");
            if (Integer.parseInt(call.getBP2().getAttribute("value")) > 0) {
                logger.info("Pass: BP2 is positive");
            } else {
                logger.error("Fail: BP2 is negative");
            }

            Shortcut.DeleteTextInTextBox(call.getO2SAT());
            call.getO2SAT().sendKeys("-9");
            if (Integer.parseInt(call.getO2SAT().getAttribute("value")) > 0) {
                logger.info("Pass: O2SAT is positive");
            } else {
                logger.error("Fail: O2SAT is negative");
            }

            Shortcut.DeleteTextInTextBox(call.getO2Th());
            call.getO2Th().sendKeys("-9");
            if (Integer.parseInt(call.getO2Th().getAttribute("value")) > 0) {
                logger.info("Pass: O2Th is positive");
            } else {
                logger.error("Fail: O2Th is negative");
            }
            Shortcut.DriverClose(logger, driver, 9);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 9);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test10() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 10, "Show the created time of case");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            String getUrl = driver.getCurrentUrl();
            if (getUrl.equals("https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/case/management")) {
                call.CallWebElementEditPage(driver);
                if (call.getTime().isDisplayed()) {
                    logger.info("Pass: Time is valid time of this card is: " + call.getTime().getText());
                } else {
                    logger.error("Fail: This is not valid");
                }
            } else {
                logger.error("Fail: Cannot access to the add page");
            }
            Shortcut.DriverClose(logger, driver, 10);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 10);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test11() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 11, "Show MPEW/NEWS");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            String getUrl = driver.getCurrentUrl();
            if (getUrl.equals("https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/case/management")) {
                call.CallWebElementAssessPage(driver);
                if (call.getMPEWorNEWS().isDisplayed()) {
                    if (call.getMPEWorNEWS().getText().equals("NEWS = 0") || call.getMPEWorNEWS().getText().equals("MPEW = 0")) {
                        logger.error("Fail: MPEW/NEWS is not updated");
                    } else {
                        logger.info("Pass: MPEW/NEWS is valid and the value is: " + call.getMPEWorNEWS().getText());
                    }
                } else {
                    logger.error("Fail: MPEW/NEWS is not valid");
                }
            } else {
                logger.error("Fail: Cannot access to the assess page");
            }
            Shortcut.DriverClose(logger, driver, 11);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 11);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test12() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 12, "Cannot edit data with alphabet");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            String getUrl = driver.getCurrentUrl();
            if (getUrl.equals("https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/case/management")) {
                call.CallWebElementEditPage(driver);
                Shortcut.DeleteTextInTextBox(call.getHN());

                call.getHN().sendKeys("Test");
                if (call.getHN().getAttribute("value").isEmpty()) {
                    logger.info("Pass: HN cannot input alphabet");
                } else {
                    logger.error("Fail: HN can input alphabet");
                }

                Shortcut.DeleteTextInTextBox(call.getAge());

                call.getAge().sendKeys("Test");
                if (call.getAge().getAttribute("value").isEmpty()) {
                    logger.info("Pass: Age (Year) cannot input alphabet");
                } else {
                    logger.error("Fail: Age (Year) can input alphabet");
                }

                call.getAgeUnit().click();

                call.getFemaleOrMonth(driver).click();

                Shortcut.DeleteTextInTextBox(call.getAge());
                call.getAge().sendKeys("Test");
                if (call.getAge().getAttribute("value").isEmpty()) {
                    logger.info("Pass: Age (Month) cannot input alphabet");
                } else {
                    logger.error("Fail: Age (Month) can input alphabet");
                }

                call.CallWebElementAssessPage(driver);

                Shortcut.DeleteTextInTextBox(call.getTemp());
                call.getTemp().sendKeys("Test");
                if (call.getTemp().getAttribute("value").isEmpty()) {
                    logger.info("Pass: Temp cannot input alphabet");
                } else {
                    logger.error("Fail: Temp can input alphabet");
                }

                Shortcut.DeleteTextInTextBox(call.getPR());
                call.getPR().sendKeys("Test");
                if (call.getPR().getAttribute("value").isEmpty()) {
                    logger.info("Pass: PR cannot input alphabet");
                } else {
                    logger.error("Fail: PR can input alphabet");
                }

                Shortcut.DeleteTextInTextBox(call.getRR());
                call.getRR().sendKeys("Test");
                if (call.getRR().getAttribute("value").isEmpty()) {
                    logger.info("Pass: RR cannot input alphabet");
                } else {
                    logger.error("Fail: RR can input alphabet");
                }

                Shortcut.DeleteTextInTextBox(call.getBP1());
                call.getBP1().sendKeys("Test");
                if (call.getBP1().getAttribute("value").isEmpty()) {
                    logger.info("Pass: BP1 cannot input alphabet");
                } else {
                    logger.error("Fail: BP1 can input alphabet");
                }

                Shortcut.DeleteTextInTextBox(call.getBP2());
                call.getBP2().sendKeys("Test");
                if (call.getBP2().getAttribute("value").isEmpty()) {
                    logger.info("Pass: BP2 cannot input alphabet");
                } else {
                    logger.error("Fail: BP2 can input alphabet");
                }

                Shortcut.DeleteTextInTextBox(call.getO2SAT());
                call.getO2SAT().sendKeys("Test");
                if (call.getO2SAT().getAttribute("value").isEmpty()) {
                    logger.info("Pass: O2SAT cannot input alphabet");
                } else {
                    logger.error("Fail: O2SAT can input alphabet");
                }

                Shortcut.DeleteTextInTextBox(call.getO2Th());
                call.getO2Th().sendKeys("Test");
                if (call.getO2Th().getAttribute("value").isEmpty()) {
                    logger.info("Pass: O2Th cannot input alphabet");
                } else {
                    logger.error("Fail: O2Th can input alphabet");
                }
            } else {
                logger.error("Fail: Cannot access to the add page");
            }
            Shortcut.DriverClose(logger, driver, 12);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 12);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test13() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 13, "Change status waiting for assess to waiting for diagnosis");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            String getUrl = driver.getCurrentUrl();
            if (getUrl.equals("https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/case/management")) {
                call.CallWebElementAssessPage(driver);
                call.getSubmit().click();

                Thread.sleep(1000);
                driver.navigate().back();

                call.CallWebElementMainPageAfterCreatedPatient(driver);
                if (call.getPatientStatus().getText().equals("Waiting for diagnose")) {
                    logger.info("Pass: Status changed to Waiting for diagnose");
                } else {
                    logger.error("Fail: Status not changed");
                }
            } else {
                logger.error("Fail: Cannot access to the add page");
            }
            Shortcut.DriverClose(logger, driver, 13);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 13);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test14() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 14, "Data in diagnosis cannot negative");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            String getUrl = driver.getCurrentUrl();
            if (getUrl.equals("https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/case/management")) {
                call.CallWebElementDiagnosisPage(driver);
                Shortcut.DeleteTextInTextBox(call.getBP1());
                call.getBP1().sendKeys("-10");
                if (Integer.parseInt(call.getBP1().getAttribute("value")) > 0) {
                    logger.info("Pass: BP1 is positive");
                } else {
                    logger.error("Fail: BP1 is negative");
                }

                call.CallWebElementDiagnosisPage(driver);
                Shortcut.DeleteTextInTextBox(call.getBP2());
                call.getBP2().sendKeys("-10");
                if (Integer.parseInt(call.getBP2().getAttribute("value")) > 0) {
                    logger.info("Pass: BP2 is positive");
                } else {
                    logger.error("Fail: BP2 is negative");
                }
            } else {
                logger.error("Fail: Cannot access to the add page");
            }
            Shortcut.DriverClose(logger, driver, 14);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 14);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test15() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 15, "pMap, NEWS, or MPEW cannot edit");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            String getUrl = driver.getCurrentUrl();
            if (getUrl.equals("https://speedy-er-sepsis-webapp-dev-es7lmrr4aq-as.a.run.app/case/management")) {
                try {
                    call.CallWebElementDiagnosisPage(driver);
                    Shortcut.DeleteTextInTextBox(call.getMPEWorNEWS());
                    if (call.getMPEWorNEWS().getAttribute("value").isEmpty()) {
                        logger.error("Fail: MPEW or NEWS can edit");
                    }
                } catch (Exception e) {
                    logger.info("Pass: MPEW or NEWS cannot edit");
                }

                try {
                    call.CallWebElementDiagnosisPage(driver);
                    Shortcut.DeleteTextInTextBox(call.getpMap());
                    if (call.getpMap().getAttribute("value").isEmpty()) {
                        logger.error("Fail: pMap can edit");
                    }
                } catch (Exception e) {
                    logger.info("Pass: pMap cannot edit");
                }
            } else {
                logger.error("Fail: Cannot access to the add page");
            }
            Shortcut.DriverClose(logger, driver, 15);
        } catch (Exception e) {
            Shortcut.DriverClose(logger, driver, 15);
            logger.error("Case Fail!!!");
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test16() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 16, "Diagnose page cannot type alphabet");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            call.CallWebElementEditPage(driver);
            Shortcut.DeleteTextInTextBox(call.getAge());
            call.getAgeUnit().click();

            call.getMaleOrYear(driver).click();
            call.getAge().sendKeys("Test");
            if (call.getAge().getAttribute("value").isEmpty()) {
                logger.info("Pass: Age (Year) cannot enter alphabet");
            } else {
                logger.error("Fail: Age (Year) can enter alphabet");
            }
            Shortcut.DeleteTextInTextBox(call.getAge());

            call.getAgeUnit().click();

            call.getFemaleOrMonth(driver).click();
            call.getAge().sendKeys("Test");
            if (call.getAge().getAttribute("value").isEmpty()) {
                logger.info("Pass: Age (Month) cannot enter alphabet");
            } else {
                logger.error("Fail: Age (Month) can enter alphabet");
            }

            call.CallWebElementDiagnosisPage(driver);
            Shortcut.DeleteTextInTextBox(call.getBP1());
            call.getBP1().sendKeys("Test");
            if (call.getBP1().getAttribute("value").isEmpty()) {
                logger.info("Pass: BP1 cannot enter alphabet");
            } else {
                logger.error("Fail: BP1 can enter alphabet");
            }

            call.CallWebElementDiagnosisPage(driver);
            Shortcut.DeleteTextInTextBox(call.getBP2());
            call.getBP2().sendKeys("Test");
            if (call.getBP2().getAttribute("value").isEmpty()) {
                logger.info("Pass: BP2 cannot enter alphabet");
            } else {
                logger.error("Fail: BP2 can enter alphabet");
            }

            Shortcut.DriverClose(logger, driver, 16);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 16);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test17() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 17, "Click assess icon it will bring you back to assess page");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            call.CallWebElementEditPage(driver);
            call.getAssessIcon(driver).click();
            call.CallWebElementAssessPage(driver);
            if (!call.getTemp().getAttribute("Value").isEmpty()
                    && !call.getPR().getAttribute("Value").isEmpty()
                    && !call.getRR().getAttribute("Value").isEmpty()
                    && !call.getBP1().getAttribute("Value").isEmpty()
                    && !call.getBP2().getAttribute("Value").isEmpty()
                    && !call.getO2SAT().getAttribute("Value").isEmpty()
                    && !call.getO2Th().getAttribute("Value").isEmpty()
            ) {
                logger.info("Pass: When click assess icon it will bring you back to assess page");
            } else {
                logger.error("Fail: When click assess icon it not bring you back to assess page");
            }
            Shortcut.DriverClose(logger, driver, 17);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 17);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test18() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 18, "Can choose one choice of infection and not infection");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);
            call.CallWebElementDiagnosisPage(driver);
            call.getInfection().click();

            if (call.getInfection().getAttribute("class").equals(Selected)
                    && call.getNotInfection().getAttribute("class").equals(NotSelected)) {
                logger.info("Pass: When click button choice can choose only one");
            } else {
                logger.error("Fail: When click button choice can choose more than one");
            }

            Thread.sleep(2000);

            call.getNotInfection().click();
            if (call.getInfection().getAttribute("class").equals(NotSelected)
                    && call.getNotInfection().getAttribute("class").equals(Selected)) {
                logger.info("Pass: When click button choice can choose only one");
            } else {
                logger.error("Fail: When click button choice can choose more than one");
            }

            Shortcut.DriverClose(logger, driver, 18);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 18);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test19() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 19, "Edit data, Check status when activate fast protocol, and Check status waiting for treatment");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);
            logger.debug("========= Test edit data in diagnosis page =========");

            call.CallWebElementEditPage(driver);
            Shortcut.DeleteTextInTextBox(call.getFullName());
            call.getFullName().sendKeys("TestForTestCase19");

            Shortcut.DeleteTextInTextBox(call.getHN());
            call.getHN().sendKeys("TestForTestCase19");

            call.getGender().click();

            call.getFemaleOrMonth(driver).click();

            call.CallWebElementEditPage(driver);
            Shortcut.DeleteTextInTextBox(call.getAge());
            call.getAge().sendKeys("10");

            call.getAgeUnit().click();

            call.getFemaleOrMonth(driver).click();

            call.CallWebElementDiagnosisPage(driver);
            Shortcut.DeleteTextInTextBox(call.getBP1());
            call.getBP1().sendKeys("3");

            Shortcut.DeleteTextInTextBox(call.getBP2());
            call.getBP2().sendKeys("3");
            call.getInfection().click();
            call.getFastTrack().click();
            call.getSubmit().click();
            logger.info("Pass: Edit patient in diagnosis page successfully");

            Thread.sleep(1000);
            logger.debug("========= Status color changed to red when activated fast protocol =========");
            driver.navigate().back();
            call.CallWebElementMainPageAfterCreatedPatient(driver);
            if (call.getPatientStatusBar().getCssValue("background-color").equals("rgba(255, 94, 94, 1)")) {
                logger.info("Pass: The status bar color changed to red");
            } else {
                logger.error("Fail: The status bar color not changed to red");
            }

            Thread.sleep(1000);
            logger.debug("========= Status changed to 'Waiting for treatment' =========");
            if (call.getPatientStatus().getText().equals("Waiting for treatment")) {
                logger.info("Pass: Status changed to Waiting for diagnose");
            } else {
                logger.info("Fail: Status not changed");
            }
            Shortcut.DriverClose(logger, driver, 19);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 19);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test20() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 20, "Show time when save in patient treatment that save from diagnose page");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);
            call.CallWebElementDiagnosisPage(driver);
            call.getSubmit().click();

            call.CallWebElementTreatmentPage(driver);
            String CurrentTime = java.time.LocalTime.now().toString().substring(0, 5);
            if (call.getTreatTime().getText().equals(CurrentTime)) {
                logger.info("Pass: Current time in the website is match to the real current time");
            } else {
                logger.error("Fail: Current time in the website is not match to the real current time");
            }
            call.CallWebElementTreatmentPage(driver);

            Shortcut.DriverClose(logger, driver, 20);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 20);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test21() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 21, "Data in patient treatment cannot be negative");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            logger.debug("========= Add SOFA, Lactate,and MAP, Check the data is negative or not, and Check the data cannot be alphabet =========");
            call.CallWebElementTreatmentPage(driver);
            call.getMapAddButton().click();

            call.CallWebElementMapPopup(driver);

            logger.debug("========= MAP =========");

            call.getMapInputPopup1().sendKeys("Test");
            call.getMapInputPopup2().sendKeys("Test");
            if (Integer.parseInt(call.getMapInputPopup1().getAttribute("Value")) == 0 && Integer.parseInt(call.getMapInputPopup2().getAttribute("Value")) == 0) {
                logger.info("Pass: Map input can be number only");
            } else {
                logger.error("Fail: Map input can be alphabet");
            }

            call.getMapInputPopup1().sendKeys("-9");
            call.getMapInputPopup2().sendKeys("-9");
            if (Integer.parseInt(call.getMapInputPopup1().getAttribute("Value")) > 0 && Integer.parseInt(call.getMapInputPopup2().getAttribute("Value")) > 0) {
                logger.info("Pass: Map input is positive");
            } else {
                logger.error("Fail: Map input is negative");
            }
            call.getPopupSubmit().click();
            logger.info("Pass: Add Map successfully");

            call.CallWebElementTreatmentPage(driver);
            call.getSofaAddButton().click();

            logger.debug("========= Sofa =========");
            Shortcut.DeleteTextInTextBox(call.getSofaAndLactateInputPopup(driver));

            call.getSofaAndLactateInputPopup(driver).sendKeys("Test");
            if (Integer.parseInt(call.getSofaAndLactateInputPopup(driver).getAttribute("Value")) == 0) {
                logger.info("Pass: Sofa input can be number only");
            } else {
                logger.error("Fail: Sofa input can be alphabet");
            }

            call.getSofaAndLactateInputPopup(driver).sendKeys("-20");
            if (Integer.parseInt(call.getSofaAndLactateInputPopup(driver).getAttribute("Value")) > 0) {
                logger.info("Pass: Sofa input is positive");
            } else {
                logger.error("Fail: Sofa input is negative");
            }
            call.getPopupSubmit().click();
            logger.info("Pass: Add Sofa successfully");

            logger.debug("========= Lactate =========");
            call.CallWebElementTreatmentPage(driver);
            call.getLactateAddButton().click();

            Shortcut.DeleteTextInTextBox(call.getSofaAndLactateInputPopup(driver));

            call.getSofaAndLactateInputPopup(driver).sendKeys("Test");
            if (Integer.parseInt(call.getSofaAndLactateInputPopup(driver).getAttribute("Value")) == 0) {
                logger.info("Pass: Lactate input can be number only");
            } else {
                logger.error("Fail: Lactate input can be alphabet");
            }

            call.getSofaAndLactateInputPopup(driver).sendKeys("-20");
            if (Integer.parseInt(call.getSofaAndLactateInputPopup(driver).getAttribute("Value")) > 0) {
                logger.info("Pass: Lactate input is positive");
            } else {
                logger.error("Fail: Lactate input is negative");
            }
            call.getPopupSubmit().click();
            logger.info("Pass: Add Lactate successfully");

            Thread.sleep(1000);
            logger.debug("========= Show MAP, Lactate, and Sofa value =========");
            call.CallWebElementTreatmentPageAfterAddData(driver);
            try {
                logger.info("Pass: Map data is - " + call.getMapData().getText());
            } catch (Exception e) {
                logger.error("Fail: Map data not found");
            }
            try {
                logger.info("Pass: Sofa data is - " + call.getSofaData().getText());
            } catch (Exception e) {
                logger.error("Fail: Sofa data not found");
            }
            try {
                logger.info("Pass: Lactate data is - " + call.getLactateData().getText());
            } catch (Exception e) {
                logger.error("Fail: Lactate data not found");
            }

            Thread.sleep(1000);
            logger.debug("========= Delete MAP, Lactate, and Sofa =========");
            Actions a = new Actions(driver);
            try {
                a.moveToElement(call.getMapDelete()).click().build().perform();
                logger.info("Pass: Map data deleted");
            } catch (Exception e) {
                logger.error("Fail: Map data not found or cannot delete");
            }

            try {
                a.moveToElement(call.getSofaDelete()).click().build().perform();
                logger.info("Pass: Sofa data deleted");
            } catch (Exception e) {
                logger.error("Fail: Lactate data not found or cannot delete");
            }

            try {
                a.moveToElement(call.getLactateDelete()).click().build().perform();
                logger.info("Pass: Lactate data deleted");
            } catch (Exception e) {
                logger.error("Fail: Lactate data not found or cannot delete");
            }

            Shortcut.DriverClose(logger, driver, 21);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 21);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test22() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 22, "Show current time when save in patient treatment");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            call.CallWebElementTreatmentPage(driver);
            call.getSubmit().click();

            Thread.sleep(1000);
            call.CallWebElementMainPageAfterCreatedPatient(driver);
            if (call.getPatientStatus().getText().equals("Waiting for archive")) {
                logger.info("Pass: Status changed to Waiting for archive");
            } else {
                logger.info("Fail: Status not changed");
            }
            Shortcut.DriverClose(logger, driver, 22);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 22);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test23() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 23, "Can choose only one infection or not infection in treatment page");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            call.CallWebElementTreatmentPage(driver);
            call.getInfection().click();
            System.out.println(call.getInfection().getAttribute("class"));
            System.out.println(call.getNotInfection().getAttribute("class"));
            if (call.getInfection().getAttribute("class").equals(Selected)
                    && call.getNotInfection().getAttribute("class").equals(NotSelected)) {
                logger.info("Pass: When click button choice can choose only one");
            } else {
                logger.error("Fail: When click button choice can choose more than one");
            }

            Thread.sleep(2000);

            call.getNotInfection().click();
            if (call.getInfection().getAttribute("class").equals(NotSelected)
                    && call.getNotInfection().getAttribute("class").equals(Selected)) {
                logger.info("Pass: When click button choice can choose only one");
            } else {
                logger.error("Fail: When click button choice can choose more than one");
            }

            Shortcut.DriverClose(logger, driver, 23);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 23);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test24() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 24, "Can choose only one infection or not infection in treatment page");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            call.CallWebElementTreatmentPage(driver);
            call.getNote().sendKeys("TestTestTestTestTest123456789");
            if (call.getNote().getText().isEmpty()) {
                logger.error("Fail: Cannot type note");
            } else {
                logger.info("Pass: Can type note");
            }
            Shortcut.DriverClose(logger, driver, 24);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 24);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test25() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 25, "Click assess icon it will bring you back to assess page and click treat icon it will bring you back to treat page");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);
            logger.debug("========= Click assess icon it will bring you back to assess page =========");

            call.CallWebElementEditPage(driver);
            call.getAssessIcon(driver).click();
            call.CallWebElementAssessPage(driver);
            if (!call.getTemp().getAttribute("Value").isEmpty()
                    && !call.getPR().getAttribute("Value").isEmpty()
                    && !call.getRR().getAttribute("Value").isEmpty()
                    && !call.getBP1().getAttribute("Value").isEmpty()
                    && !call.getBP2().getAttribute("Value").isEmpty()
                    && !call.getO2SAT().getAttribute("Value").isEmpty()
                    && !call.getO2Th().getAttribute("Value").isEmpty()
            ) {
                logger.info("Pass: When click assess icon it will bring you back to assess page");
            } else {
                logger.error("Fail: When click assess icon it not bring you back to assess page");
            }
            logger.debug("========= Click treat icon it will bring you back to treat page =========");

            call.CallWebElementEditPage(driver);
            call.getTreatmentIcon(driver).click();
            call.CallWebElementTreatmentPage(driver);
            if (call.getMapAddButton().isDisplayed()
                    && call.getSofaAddButton().isDisplayed()
                    && call.getLactateAddButton().isDisplayed()
                    && call.getInfection().isDisplayed()
                    && call.getNotInfection().isDisplayed()) {
                logger.info("Pass: When click treat icon it will bring you back to treat page");
            } else {
                logger.error("Fail: When click treat icon it not bring you back to treat page");
            }

            Shortcut.DriverClose(logger, driver, 25);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 25);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test26() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 26, "Edit patient information in treatment page");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {
            Shortcut.getFirstCard(driver, call);

            call.CallWebElementEditPage(driver);
            Shortcut.DeleteTextInTextBox(call.getFullName());
            call.getFullName().sendKeys("AutomatedTest Edited by DJ");

            Shortcut.DeleteTextInTextBox(call.getHN());
            call.getHN().sendKeys("1234");

            Shortcut.DeleteTextInTextBox(call.getAge());
            call.getAge().sendKeys("1234");

            call.getGender().click();
            call.getFemaleOrMonth(driver).click();

            call.CallWebElementEditPage(driver);
            call.getAgeUnit().click();
            call.getFemaleOrMonth(driver).click();

            call.CallWebElementEditPage(driver);
            Shortcut.DeleteTextInTextBox(call.getAge());
            call.getAge().sendKeys("12");

            logger.info("Pass: Patient information can edit");

            Shortcut.DriverClose(logger, driver, 26);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 26);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test27() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 27, "Can choose only one sepsis, septic shock, or sepsis induced in treatment page");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            call.CallWebElementTreatmentPage(driver);
            call.getSepsis().click();
            System.out.println(call.getSepsis().getAttribute("class"));
            System.out.println(call.getSepsisShock().getAttribute("class"));

            if (call.getSepsis().getAttribute("class").equals(Selected)
                    && call.getSepsisShock().getAttribute("class").equals(NotSelected)
                    && call.getSepsisInduced().getAttribute("class").equals(NotSelected)) {
                logger.info("Pass: When click button choice can choose only one");
            } else {
                logger.error("Fail: When click button choice can choose more than one");
            }

            Thread.sleep(2000);

            call.getSepsisShock().click();
            if (call.getSepsis().getAttribute("class").equals(NotSelected)
                    && call.getSepsisShock().getAttribute("class").equals(Selected)
                    && call.getSepsisInduced().getAttribute("class").equals(NotSelected)) {
                logger.info("Pass: When click button choice can choose only one");
            } else {
                logger.error("Fail: When click button choice can choose more than one");
            }

            Thread.sleep(2000);

            call.getSepsisInduced().click();
            if (call.getSepsis().getAttribute("class").equals(NotSelected)
                    && call.getSepsisShock().getAttribute("class").equals(NotSelected)
                    && call.getSepsisInduced().getAttribute("class").equals(Selected)) {
                logger.info("Pass: When click button choice can choose only one");
            } else {
                logger.error("Fail: When click button choice can choose more than one");
            }

            Shortcut.DriverClose(logger, driver, 27);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 27);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test28() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 28, "Mecrit Notified when save");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

            Shortcut.getFirstCard(driver, call);

            call.CallWebElementTreatmentPage(driver);
            call.getCriticalCareNotification().click();
            call.getSubmit().click();

            call.CallWebElementMainPageAfterCreatedPatient(driver);
            if (call.getMecritShow().getText().equals("Mecrit Notified")) {
                logger.info("Pass: Mecrit Notified is show now");
            } else {
                logger.error("Fail: Mecrit Notified is not show");
            }
            Shortcut.DriverClose(logger, driver, 28);
        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 28);
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void Test29() {
        Shortcut.LoggerTestCaseNumberAndName(logger, 29, "Change time in Admit and Refer");
        WebDriver driver = new ChromeDriver(Shortcut.options());
        Shortcut.CallChromeDriver(driver, url);
        try {

        } catch (Exception e) {
            logger.error("Case Fail!!!");
            Shortcut.DriverClose(logger, driver, 29);
            e.printStackTrace();
        }
    }
}