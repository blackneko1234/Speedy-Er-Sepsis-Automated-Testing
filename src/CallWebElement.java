import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CallWebElement {
    /*MainPage*/
    private static WebElement SelectFirstCard;
    private static WebElement PatientStatusBar;
    private static WebElement MecritShow;
    /*End MainPage*/

    /*DataPage*/
    private static WebElement AssessIcon;
    private static WebElement DiagnoseIcon;
    private static WebElement TreatmentIcon;
    private static WebElement Time;
    private static WebElement FullName;
    private static WebElement HN;
    private static WebElement Gender;
    private static WebElement Age;
    private static WebElement AgeUnit;
    private static WebElement Temp;
    private static WebElement PR;
    private static WebElement RR;
    private static WebElement BP1;
    private static WebElement BP2;
    private static WebElement O2SAT;
    private static WebElement O2Th;
    private static WebElement Fever;
    private static WebElement Suspected;
    private static WebElement History;
    private static WebElement Alert;
    private static WebElement Submit;
    private static WebElement Voice;
    private static WebElement Pain;
    private static WebElement Unresponsive;

    private static WebElement PatientStatus;
    private static WebElement MPEWorNEWS;
    private static WebElement pMap;
    //Diagnose
    private static WebElement Infection;
    private static WebElement NotInfection;
    private static WebElement FastTrack;
    //Treatment
    private static WebElement MapAddButton;
    private static WebElement SofaAddButton;
    private static WebElement LactateAddButton;
    private static WebElement MapInputPopup1;
    private static WebElement MapInputPopup2;
    private static WebElement SofaAndLactateInputPopup;
    private static WebElement PopupSubmit;
    private static WebElement PopupCancel;
    private static WebElement MapData;
    private static WebElement MapDelete;
    private static WebElement SofaData;
    private static WebElement SofaDelete;
    private static WebElement LactateData;
    private static WebElement LactateDelete;
    private static WebElement TreatTime;
    private static WebElement Sepsis;
    private static WebElement SepsisShock;
    private static WebElement SepsisInduced;
    private static WebElement CriticalCareNotification;
    private static WebElement Antibiotic;
    private static WebElement IVFluid;
    private static WebElement LoadAdequateFluid;
    private static WebElement Vasopressor;
    private static WebElement Hydrocortisone;
    private static WebElement Epinephrine;
    private static WebElement Note;

    private static WebElement AdmitTimeDisposition;
    private static WebElement ReferDisposition;
    private static WebElement DischargeDisposition;
    private static WebElement AgainstDisposition;
    private static WebElement DeathDisposition;

    /*Selected box*/
    private static WebElement MaleOrYear;
    private static WebElement FemaleOrMonth;
    /*End Selected box*/

    /*End DataPage*/

    public void CallWebElementDispositionPage(WebDriver driver) {
        AdmitTimeDisposition = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div[2]/div/div/div/div[1]/div/div[1]/span/span[1]/input"));
        ReferDisposition = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div[2]/div/div/div/div[3]/div/div[1]/span/span[1]/input"));
        DischargeDisposition = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div[2]/div/div/div/div[5]/div/div[1]/span/span[1]/input"));
        AgainstDisposition = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div[2]/div/div/div/div[7]/div/div[1]/span/span[1]/input"));
        DeathDisposition = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div[2]/div/div/div/div[9]/div/div[1]/span/span[1]/input"));
    }

    public void CallWebElementMainPageAfterCreatedPatient(WebDriver driver) {
        SelectFirstCard = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div/div[2]/div[2]/div/div/div/div[1]/div"));
        PatientStatus = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[7]/p"));
        PatientStatusBar = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[7]/div/div[1]"));
        MecritShow = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[6]/div"));
    }

    public void CallWebElementAddPage(WebDriver driver) {
        //Time
        Time = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[1]/div/div[2]/p/p/p"));

        //TextBox
        FullName = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[1]/div/div[3]/div/div[1]/div/div/input"));
        HN = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[1]/div/div[3]/div/div[2]/div/div/input"));
        Gender = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[1]/div/div[3]/div/div[3]/div/div/div"));
        Age = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[1]/div/div[3]/div/div[4]/div/div/input"));
        AgeUnit = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[1]/div/div[3]/div/div[5]/div/div/div"));
        Temp = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div/input"));
        PR = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div/div/input"));
        RR = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[1]/div[3]/div/div[2]/div/div/input"));
        BP1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[1]/div[4]/div/div[2]/div/div[1]/div/div/input"));
        BP2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[1]/div[4]/div/div[2]/div/div[3]/div/div/input"));
        O2SAT = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[1]/div[5]/div/div[2]/div/div/input"));
        O2Th = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[1]/div[6]/div/div[2]/div/div/input"));

        //Checkbox
        Fever = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/span/span[1]/input"));
        Suspected = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/span/span[1]/input"));
        History = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/span/span[1]/input"));

        //Radio
        Alert = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[2]/div[2]/fieldset/div/div/div[1]/label/span[1]/span[1]/input"));
        Voice = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[2]/div[2]/fieldset/div/div/div[2]/label/span[1]/span[1]/input"));
        Pain = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[2]/div[2]/fieldset/div/div/div[3]/label/span[1]/span[1]/input"));
        Unresponsive = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[2]/div[2]/div/div/div[2]/div[2]/fieldset/div/div/div[4]/label/span[1]/span[1]/input"));

        //Submit
        Submit = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[3]/button"));
    }

    public void CallWebElementSelectGenderOrYear(WebDriver driver) {
        MaleOrYear = driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[1]"));
        FemaleOrMonth = driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[2]"));
    }

    public void CallWebElementEditPage(WebDriver driver) {
        Time = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[1]/div[1]/div[2]/p/p/p"));
        FullName = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div/div/input"));
        HN = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[1]/div[2]/div/div[2]/div/div/input"));
        Gender = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[1]/div[2]/div/div[3]/div/div/div"));
        Age = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[1]/div[2]/div/div[4]/div/div/input"));
        AgeUnit = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/div/div"));
        AssessIcon = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[1]/div[1]/span/span[1]"));
        DiagnoseIcon = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[1]/div[2]/span/span[1]"));
        TreatmentIcon = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[1]/div[3]/span/span[1]"));
    }

    public void CallWebElementAssessPage(WebDriver driver) {
        //TextBox
        MPEWorNEWS = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[3]/p"));
        Temp = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div/input"));
        PR = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div/div/input"));
        RR = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div[3]/div/div[2]/div/div/input"));
        BP1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div[4]/div/div[2]/div/div[1]/div/div/input"));
        BP2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div[4]/div/div[2]/div/div[3]/div/div/input"));
        O2SAT = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div[5]/div/div[2]/div/div/input"));
        O2Th = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div[6]/div/div[2]/div/div/input"));

        //CheckBox
        Fever = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/span/span[1]/input"));
        Suspected = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/span/span[1]/input"));
        History = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div[2]/span/span[1]/input"));

        //Radio
        Alert = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/fieldset/div/div/div[1]/label/span[1]/span[1]/input"));
        Voice = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/fieldset/div/div/div[2]/label/span[1]/span[1]/input"));
        Pain = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/fieldset/div/div/div[3]/label/span[1]/span[1]/input"));
        Unresponsive = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/fieldset/div/div/div[4]/label/span[1]/span[1]/input"));

        //Submit
        Submit = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[2]/button"));
    }

    public void CallWebElementDiagnosisPage(WebDriver driver) {
        BP1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/input"));
        BP2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/div[3]/div/div/input"));
        MPEWorNEWS = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[1]/div[1]/div[2]/div/div/input"));
        pMap = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div/div/div[1]/div[3]/div[1]/div[2]/div/div/input"));
        Infection = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/button"));
        NotInfection = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/button"));
        FastTrack = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/span"));
        Submit = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[2]/button"));
    }

    public void CallWebElementTreatmentPage(WebDriver driver) {
        MapAddButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div/div/div/p[2]/button"));
        SofaAddButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div[3]/div/div/div/p[2]/button"));
        LactateAddButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div[4]/div/div/div/p[2]/button"));
        Submit = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[2]/button"));
        TreatTime = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[1]/div[2]/p/p/p"));
        Infection = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[1]/button"));
        NotInfection = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[2]/button"));
        Sepsis = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[3]/button"));
        SepsisShock = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[4]/button"));
        SepsisInduced = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[5]/button"));
        CriticalCareNotification = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[6]/button"));
        Antibiotic = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/p[2]/span/span[1]/input"));
        IVFluid = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/p[2]/span/span[1]/input"));
        LoadAdequateFluid = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[3]/p[2]/span/span[1]/input"));
        Vasopressor = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[4]/p[2]/span/span[1]/input"));
        Hydrocortisone = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[5]/p[2]/span/span[1]/input"));
        Epinephrine = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[6]/p[2]/span/span[1]/input"));
        Note = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[7]/div/div/div/textarea[1]"));
    }

    public void CallWebElementMapPopup(WebDriver driver) {
        MapInputPopup1 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/div/div[1]/div/input"));
        MapInputPopup2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/div/div[2]/div/input"));
        PopupSubmitAndCancel(driver);
    }

    public void CallWebElementSofaAndLactatePopup(WebDriver driver) {
        SofaAndLactateInputPopup = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/div/div/input"));
        PopupSubmitAndCancel(driver);
    }

    public void CallWebElementTreatmentPageAfterAddData(WebDriver driver) {
        MapData = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/p"));
        SofaData = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div[3]/div/div[2]/p"));
        LactateData = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div[4]/div/div[2]/p"));

        MapDelete = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/*[name()=\"svg\"]"));
        SofaDelete = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div[3]/div/div[2]/*[name()=\"svg\"]"));
        LactateDelete = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div[4]/div/div[2]/*[name()=\"svg\"]"));
    }


    public void PopupSubmitAndCancel(WebDriver driver) {
        PopupSubmit = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/div/button[2]"));
        PopupCancel = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/div/button[1]"));
    }

    public WebElement getMapAddButton() {
        return MapAddButton;
    }

    public WebElement getSofaAddButton() {
        return SofaAddButton;
    }

    public WebElement getLactateAddButton() {
        return LactateAddButton;
    }

    public WebElement getpMap() {
        return pMap;
    }

    public WebElement getSelectFirstCard() {
        return SelectFirstCard;
    }

    public WebElement getMaleOrYear() {
        return MaleOrYear;
    }

    public WebElement getFemaleOrMonth() {
        return FemaleOrMonth;
    }

    public WebElement getAddButton(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/button"));
    }

    public WebElement getTime() {
        return Time;
    }

    public WebElement getFullName() {
        return FullName;
    }

    public WebElement getHN() {
        return HN;
    }

    public WebElement getGender() {
        return Gender;
    }

    public WebElement getAge() {
        return Age;
    }

    public WebElement getAgeUnit() {
        return AgeUnit;
    }

    public WebElement getTemp() {
        return Temp;
    }

    public WebElement getPR() {
        return PR;
    }

    public WebElement getRR() {
        return RR;
    }

    public WebElement getBP1() {
        return BP1;
    }

    public WebElement getBP2() {
        return BP2;
    }

    public WebElement getO2SAT() {
        return O2SAT;
    }

    public WebElement getO2Th() {
        return O2Th;
    }

    public WebElement getFever() {
        return Fever;
    }

    public WebElement getSuspected() {
        return Suspected;
    }

    public WebElement getHistory() {
        return History;
    }

    public WebElement getAlert() {
        return Alert;
    }

    public WebElement getVoice() {
        return Voice;
    }

    public WebElement getPain() {
        return Pain;
    }

    public WebElement getUnresponsive() {
        return Unresponsive;
    }

    public WebElement getSubmit() {
        return Submit;
    }

    public WebElement getPatientStatus() {
        return PatientStatus;
    }

    public WebElement getMPEWorNEWS() {
        return MPEWorNEWS;
    }

    public WebElement getAssessIcon() {
        return AssessIcon;
    }

    public WebElement getDiagnoseIcon() {
        return DiagnoseIcon;
    }

    public WebElement getTreatmentIcon() {
        return TreatmentIcon;
    }

    public WebElement getInfection() {
        return Infection;
    }

    public WebElement getNotInfection() {
        return NotInfection;
    }

    public WebElement getFastTrack() {
        return FastTrack;
    }

    public WebElement getPatientStatusBar() {
        return PatientStatusBar;
    }

    public WebElement getMapInputPopup1() {
        return MapInputPopup1;
    }

    public WebElement getMapInputPopup2() {
        return MapInputPopup2;
    }

    public WebElement getSofaAndLactateInputPopup() {
        return SofaAndLactateInputPopup;
    }

    public WebElement getPopupSubmit() {
        return PopupSubmit;
    }

    public WebElement getPopupCancel() {
        return PopupCancel;
    }

    public WebElement getMapData() {
        return MapData;
    }

    public WebElement getMapDelete() {
        return MapDelete;
    }

    public WebElement getSofaData() {
        return SofaData;
    }

    public WebElement getSofaDelete() {
        return SofaDelete;
    }

    public WebElement getLactateData() {
        return LactateData;
    }

    public WebElement getLactateDelete() {
        return LactateDelete;
    }

    public WebElement getTreatTime() {
        return TreatTime;
    }

    public WebElement getNote() {
        return Note;
    }

    public WebElement getSepsis() {
        return Sepsis;
    }

    public WebElement getSepsisShock() {
        return SepsisShock;
    }

    public WebElement getSepsisInduced() {
        return SepsisInduced;
    }

    public WebElement getCriticalCareNotification() {
        return CriticalCareNotification;
    }

    public WebElement getAntibiotic() {
        return Antibiotic;
    }

    public WebElement getIVFluid() {
        return IVFluid;
    }

    public WebElement getLoadAdequateFluid() {
        return LoadAdequateFluid;
    }

    public WebElement getVasopressor() {
        return Vasopressor;
    }

    public WebElement getHydrocortisone() {
        return Hydrocortisone;
    }

    public WebElement getEpinephrine() {
        return Epinephrine;
    }

    public WebElement getMecritShow() {
        return MecritShow;
    }

    public WebElement getAdmitTimeDisposition() {
        return AdmitTimeDisposition;
    }

    public WebElement getAdmitTimeChangeDisposition(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div[2]/div/div/div/div[2]/div/div/div/div/input"));
    }

    public WebElement getReferDisposition() {
        return ReferDisposition;
    }

    public WebElement getReferChangeDisposition(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div[2]/div/div/div/div[4]/div/div/div/div/input"));
    }

    public WebElement getDischargeDisposition() {
        return DischargeDisposition;
    }

    public WebElement getAgainstDisposition() {
        return AgainstDisposition;
    }

    public WebElement getDeathDisposition() {
        return DeathDisposition;
    }
}