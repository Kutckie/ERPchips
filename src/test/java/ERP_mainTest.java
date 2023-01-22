import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class ERP_mainTest extends Base {

    private final static String ERP_URL = "http://localhost:8080/dashboard";

    @Test
    public void loginERP() {
        Login login = new Login();
        Login.loginERP();
    }

    @Test(dependsOnMethods = "loginERP", priority = 2, description = "Invoice modal window check for non-foreign company")
    public void invoiceTest() {
        ERP_mainPage.downloadCheck();
        Selenide.sleep(2000);
        ERP_mainPage.setNoCustomsPositionCheckboxClick();
        ERP_mainPage.setNextStageButtonClick();
        ERP_mainPage.invoiceCheck();
    }

    @Test(priority = 3)
    public void orderAmountTest() {
        open("http://localhost:8080/dashboard");
        switchTo().window("ERP");

        ERP_mainPage.downloadCheck();
        Selenide.sleep(2000);
        ERP_mainPage.getOrderAmount();
        int columnAmount1 = ERP_mainPage.getOrderAmount();

        ERP_mainPage.columnExpandClick();
        Selenide.sleep(3000);
        ERP_mainPage.getOrderAmount();
        int columnAmount2 = ERP_mainPage.getOrderAmount();
        Assert.assertTrue(columnAmount1 == columnAmount2);
    }

}
