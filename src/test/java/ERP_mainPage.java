import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;


import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.*;

public class ERPmainPage {
    private static final SelenideElement downloadCheck = $x("//*[@id=\"overlay-background\"]/div/div/div[3]/div[1]/img");
    private static final SelenideElement noCustomsPositionCheckbox = $x("/html/body/div[1]/div[1]/main/div[2]/div/div/div/div[2]/div[2]/div/section[1]/div/div/div/div/div/div[3]/div[2]/div");
    private static final SelenideElement nextStageButton = $x("//*[@id=\"overlay-background\"]/div/div/div/div[2]/div[1]/div/div[2]/img[1]");
    private static final SelenideElement invoiceButton = $x("//*[@id=\"overlay-background\"]/div[4]/div/button[2]");

    private static final SelenideElement columnAmount = $x("//*[@id=\"overlay-background\"]/div/div/div/div[2]/div[1]/div/div[1]/span");


    public ERPmainPage(String URL) {
        Selenide.open(URL);
    }

    public static void downloadCheck() {
        downloadCheck.shouldBe(interactable);
    }

    public static void setNoCustomsPositionCheckboxClick() {
        actions().click(noCustomsPositionCheckbox).build().perform();
    }

    public static void setNextStageButtonClick() {
        nextStageButton.click();
    }

    public static String getOrderAmount(){
        return columnAmount.getValue();
    }

    //public static Integer getOrderAmount(){
    //    int intColumnAmount = Integer.parseInt(columnAmount.getValue());
    //    System.out.println(intColumnAmount);
    //    return intColumnAmount;
    //}

    public static void invoiceCheck() {
        invoiceButton.shouldBe(visible, Duration.ofSeconds(5));
        Assert.assertTrue(invoiceButton.exists());
    }
}
