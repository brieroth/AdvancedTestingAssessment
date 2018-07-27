package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Homepage {

    @FindBy (xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
    private WebElement ownerDrop;

    @FindBy (xpath= "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a/span[2]")
    private WebElement addNew;

    public void owner (){
        ownerDrop.click();
        addNew.click();
    }

}
