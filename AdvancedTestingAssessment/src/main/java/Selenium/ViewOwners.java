package Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewOwners {
    @FindBy(xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
    private WebElement ownerDrop;

    @FindBy (xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a/span[2]")
    private WebElement allView;


    @FindBy (xpath ="/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[1]/td[1]/a")
        private WebElement details;

    public void viewAll (){
        ownerDrop.click();
        allView.click();
    }


}
