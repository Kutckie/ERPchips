import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class ERPmainTest extends Base {

    private final static String ERP_URL = "http://localhost:8080/dashboard";

    @Test
    public void loginERP() {
        Login login = new Login();
        Login.loginERP();
    }

    //@Test(dependsOnMethods = "loginERP", priority = 2, description = "Invoice modal window check for non-foreign company")
    //public void mainPageTest() {
    //    ERPmainPage.downloadCheck();
    //    Selenide.sleep(2000);
    //    ERPmainPage.setNoCustomsPositionCheckboxClick();
    //    ERPmainPage.setNextStageButtonClick();
    //    ERPmainPage.invoiceCheck();
    //}

    @Test(priority = 3)
    public void orderAmountTest() {
        ERPmainPage.downloadCheck();
        Selenide.sleep(2000);
        ERPmainPage.getOrderAmount();
    }

}
