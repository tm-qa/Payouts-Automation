package Payouts;

import DB_Assertions.ValidatePayoutRules;
import com.qa.turtlemint.base.TestBase;
import com.qa.turtlemint.pages.Ninja.ninja;
import com.qa.turtlemint.pages.payouts.PayoutsRulePage;
import com.qa.turtlemint.util.RetryAnalyser;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PayoutsRuleTest extends TestBase {

    ninja ninj;

    PayoutsRulePage rulePage;

    public PayoutsRuleTest() {
        super();
    }

    @BeforeMethod()
    public void start() throws Exception {
        initialization();
        rulePage = new PayoutsRulePage();
        ninj = new ninja();
        ninj.NinjaLogin(prop.getProperty("NinjaEmail"), prop.getProperty("NinjaPassword"));
        driver.findElement(By.xpath("//a[@data-auto='payouts-module']")).click();
    }

//    @Test(priority = 0, enabled = true, retryAnalyzer = RetryAnalyser.class)
//    public void verifyUploadRule() {
//        rulePage.uploadUniqRuleFile("SanityRuleFileMain.csv");
//    }
//
//    @Test(priority = 1, enabled = true, retryAnalyzer = RetryAnalyser.class)
//    public void verifyUploadRuleWithDuplicateID() {
//        rulePage.uploadDuplicateRuleFile("DuplicateRuleId.csv");
//    }
//
//    @Test(priority = 2, enabled = true, retryAnalyzer = RetryAnalyser.class)
//    public void verifyUploadRuleWithChangeInRule() {
//        rulePage.uploadDuplicateRuleFile("DuplicateRuleId.csv");
//    }
//
//    @Test(priority = 3, enabled = true, retryAnalyzer = RetryAnalyser.class)
//    public void verifyUploadRuleWithNewRule() {
//        rulePage.uploadDuplicateRuleFile("DuplicateRuleId.csv");
//    }
//
//    @Test(priority = 4, enabled = true, retryAnalyzer = RetryAnalyser.class)
//    public void verifyUploadRuleWithDeleteRule() {
//        rulePage.uploadDuplicateRuleFile("DuplicateRuleId.csv");
//        rulePage.downloadReportFrmHistory();
//    }

    @Test(priority = 5)//, enabled = true, retryAnalyzer = RetryAnalyser.class)
    public void UploadeLatestRuleFile() throws InterruptedException {
        rulePage.toUploadLatestRuleFile("SanityRuleFileMain.csv");
        ValidatePayoutRules db = new ValidatePayoutRules();
        db.ValidatePayoutRules();
    }

//    @AfterTest()
//    public void close() throws Exception {
//        driver.close();
//    }

}
