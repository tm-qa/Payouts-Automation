package com.qa.turtlemint.pages.payouts;

import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.commands.WebCommands;
import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayoutsRulePage extends TestBase {

    @FindBy(xpath = "//span[text()='Create an account/ Sign in']")
    WebElement CreateAccount;

    @FindBy(xpath = "//span[text()='Configure Rules']")
    WebElement configureRulesModule;

    @FindBy(xpath = "//span[text()='Payouts Rules']")
    WebElement payoutsRule;

    @FindBy(xpath = "//div[text()='Test and Upload']")
    WebElement testAndUploadBtn;

    @FindBy(xpath = "//div[text()='Production History']")
    WebElement ruleHistoryBtn;

    @FindBy(xpath = "//h3[text()='Test and Upload']")
    WebElement uploadRulePageTitle;

    @FindBy(xpath = "//span[text()='Current Rule File']")
    WebElement crntRuleFileBtn;

    @FindBy(xpath = "//span[text()='Current Master Test Data']")
    WebElement masterDataBtn;

    @FindBy(xpath = "(//span[text()='Upload'])[1]")
    WebElement ruleUploadBtn;

    @FindBy(xpath = "(//span[text()='Upload'])[2]")
    WebElement masterDataUploadBtn;

    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement commentTxtBox;

    @FindBy(xpath = "//button//span[text()='Upload']")
    WebElement mainUploadBtn;

    @FindBy(xpath = "(//button//span[text()='Upload'])[2]")
    WebElement pushToProductionUploadBtn;

    @FindBy(xpath = "//label[text()='Comments*']//parent::div//textarea")
    WebElement pushToProductionComment;

    @FindBy(xpath = "//span[text()='Start Simulation']")
    WebElement startSimulationBtn;

    @FindBy(xpath = "//h3[text()='Last Test Report']")
    WebElement reportTitle;

    @FindBy(xpath = "//span[text()='Rule File']")
    WebElement ruleFileButton;

    @FindBy(xpath = "//span[contains(text(),'Comparison')]//parent::div//following-sibling::div//a//span")
    WebElement comparisonReportButtn;

    @FindBy(xpath = "//span[contains(text(),'Data Impact')]//parent::div//following-sibling::div//a//span")
    WebElement masterDataButtn;

    @FindBy(xpath = "//span[contains(text(),'reviewed')]//parent::div//label//span")
    WebElement reviewReportCheckBox;

    @FindBy(xpath = "//span[text()='Push to Production']")
    WebElement pushToProdButton;

    @FindBy(xpath = "//span[text()='Process without Re-processing']//parent::label//child::span//input")
    WebElement without_ReProcessingCTA;

    @FindBy(xpath = "//h3[text()='Rule File Production History']")
    WebElement ruleFileHistryTitle;

    @FindBy(xpath = "(//span[text()='Open'])[1]")
    WebElement openbtn;


    public PayoutsRulePage() {
        PageFactory.initElements(driver, this);
    }

    public void toUploadLatestRuleFile(String fileName){
        String strUrl = driver.getCurrentUrl();
        LogUtils.info("Opened Website: " + strUrl);
        //       TestUtil.click(CreateAccount, "Create an account/Sign in Button Clicked");
        TestUtil.click(configureRulesModule, "Clicked On Configure Rules Module");
        TestUtil.click(payoutsRule, "Clicked On Payout Rule Tab");
        TestUtil.click(testAndUploadBtn, "Clicked On Test And Upload Tab");
        WebCommands.staticSleep(2000);
        driver.findElement(By.xpath("(//span[text()='Upload'])[1]//preceding-sibling::input")).sendKeys("//Users/rahulpatil/Documents/Payouts Files/RuleFileMain/" + fileName + "");
        WebCommands.staticSleep(2000);
        TestUtil.click(commentTxtBox, "Clicked on comment Text Box");
        TestUtil.sendKeys(commentTxtBox,"Automation Test", "Comment Entered");
        TestUtil.click(mainUploadBtn, "Clicked on upload button");
        WebCommands.staticSleep(20000);
        //TestUtil.click(masterDataUploadBtn, "Clicked on Master Data Upload Button");
//        driver.findElement(By.xpath("(//span[text()='Upload'])[2]")).sendKeys("/Users/rahulpatil/Documents/Payouts Files/materTestDataFile.csv");
//        WebCommands.staticSleep(20000);
        TestUtil.click(startSimulationBtn, "Clicked on Start Test Button");
        WebCommands.staticSleep(20000);
//        Assert.assertEquals(reportTitle.getText(),"Last Test Report");
//        TestUtil.click(ruleFileButton, "Rule File downloaded from report");
//        TestUtil.click(comparisonReportButtn, "Comparison report downloaded");
//        TestUtil.click(masterDataButtn, "Master Data report downloaded");
        driver.findElement(By.xpath("//html")).sendKeys(Keys.PAGE_DOWN);
        TestUtil.click(reviewReportCheckBox, "Review Report Checkbox clicked");
        TestUtil.click(pushToProdButton, "Push To Production button clicked");
//        if(without_ReProcessingCTA.isDisplayed()) {
//            TestUtil.click(without_ReProcessingCTA, "Process without Re-processing Radio Button clicked");
//        }
        TestUtil.click(pushToProductionComment, "Clicked on comment Text Box");
        TestUtil.sendKeys(pushToProductionComment,"Automation Test", "Comment Entered");
        TestUtil.click(pushToProductionUploadBtn, "Clicked on Upload button");
    }

//    public void uploadUniqRuleFile(String fileName){
//        String strUrl = driver.getCurrentUrl();
//        LogUtils.info("Opened Website: " + strUrl);
//        //       TestUtil.click(CreateAccount, "Create an account/Sign in Button Clicked");
//        TestUtil.click(configureRulesModule, "Clicked On Configure Rules Module");
//        TestUtil.click(payoutsRule, "Clicked On Payout Rule Tab");
//        TestUtil.click(testAndUploadBtn, "Clicked On Test And Upload Tab");
//        Assert.assertEquals(uploadRulePageTitle.getText(),"Test and Upload");
//        WebCommands.staticSleep(2000);
//        TestUtil.click(crntRuleFileBtn, "Current Rule File Downloaded");
//        WebCommands.staticSleep(2000);
//        TestUtil.click(masterDataBtn, "Current Master Data File Downloaded");
//        WebCommands.staticSleep(2000);
//        //TestUtil.click(ruleUploadBtn, "Clicked on Rule File Upload Button");
//        driver.findElement(By.xpath("(//span[text()='Upload'])[1]")).sendKeys("/Users/rahulpatil/Documents/Payouts Files//Users/rahulpatil/Documents/Payouts Files/RuleFileMain/" + fileName + "");
//        WebCommands.staticSleep(20000);
//        TestUtil.click(commentTxtBox, "Clicked on comment Text Box");
//        TestUtil.sendKeys(commentTxtBox,"Automation Test", "Mobile Number Entered");
//        TestUtil.click(mainUploadBtn, "Clicked on upload button");
//        WebCommands.staticSleep(20000);
//        //TestUtil.click(masterDataUploadBtn, "Clicked on Master Data Upload Button");
//        driver.findElement(By.xpath("(//span[text()='Upload'])[2]")).sendKeys("/Users/rahulpatil/Documents/Payouts Files/materTestDataFile.csv");
//        WebCommands.staticSleep(20000);
//        TestUtil.click(startSimulationBtn, "Clicked on Start Test Button");
//        WebCommands.staticSleep(20000);
//        Assert.assertEquals(reportTitle.getText(),"Last Test Report");
//        TestUtil.click(ruleFileButton, "Rule File downloaded from report");
//        TestUtil.click(comparisonReportButtn, "Comparison report downloaded");
//        TestUtil.click(masterDataButtn, "Master Data report downloaded");
//        TestUtil.click(reviewReportCheckBox, "Review Report Checkbox clicked");
//        TestUtil.click(pushToProdButton, "Push To Production button clicked");
//    }

//    public void uploadDuplicateRuleFile(String fileName) {
//        String strUrl = driver.getCurrentUrl();
//        LogUtils.info("Opened Website: " + strUrl);
//        //       TestUtil.click(CreateAccount, "Create an account/Sign in Button Clicked");
//        TestUtil.click(payoutsRule, "Clicked On Payout Rule Tab");
//        TestUtil.click(testAndUploadBtn, "Clicked On Test And Upload Tab");
//        driver.findElement(By.xpath("(//span[text()='Upload'])[1]")).sendKeys("/Users/rahulpatil/Documents/Payouts Files/" + fileName + "");
//        WebCommands.staticSleep(20000);
//        TestUtil.click(commentTxtBox, "Clicked on comment Text Box");
//        TestUtil.sendKeys(commentTxtBox,"Automation Test", "Mobile Number Entered");
//        TestUtil.click(mainUploadBtn, "Clicked on upload button");
//
//    }

//    public void downloadReportFrmHistory() {
//        TestUtil.click(payoutsRule, "Clicked On Payout Rule Tab");
//        TestUtil.click(ruleHistoryBtn, "Rule button Clicked");
//        Assert.assertEquals(ruleFileHistryTitle.getText(),"Rule File Production History");
//        TestUtil.click(openbtn, "Open File button Clicked");
//        TestUtil.click(ruleFileButton, "Rule File downloaded from report");
//        TestUtil.click(comparisonReportButtn, "Comparison report downloaded");
//        TestUtil.click(masterDataButtn, "Master Data report downloaded");
//    }

}
