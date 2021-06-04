public class ExecuteTestCase {
    public static void main(String[] args) {
        try {
            String[] os = System.getProperty("os.name").toLowerCase().split(" ");
            if (os[0].equals("windows")) {
                /*ChromeWebdriver*/
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            }

            //ScreenRecording.StartRecord();

            /*============TestCase============*/
            //AllTestCase.Test1();
            //AllTestCase.Test2();
            //AllTestCase.Test3();
            //AllTestCase.Test4();
            //AllTestCase.Test5();
            //AllTestCase.Test6();
            //AllTestCase.Test7();
            //AllTestCase.Test8();
            //AllTestCase.Test9();
            //AllTestCase.Test10();
            //AllTestCase.Test11();
            //AllTestCase.Test12();
            //AllTestCase.Test13();
            //AllTestCase.Test14();
            //AllTestCase.Test15();
            //AllTestCase.Test16();
            //AllTestCase.Test17();
            //AllTestCase.Test18();
            //AllTestCase.Test19();
            //AllTestCase.Test20();
            //AllTestCase.Test21();
            //AllTestCase.Test22();
            //AllTestCase.Test23();
            //AllTestCase.Test24();
            //AllTestCase.Test25();
            //AllTestCase.Test26();
            //AllTestCase.Test27();
            AllTestCase.Test28();

            /*==========End TestCase==========*/

            Shortcut.WindowsTerminateTask();

            //ScreenRecording.StopRecord();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}