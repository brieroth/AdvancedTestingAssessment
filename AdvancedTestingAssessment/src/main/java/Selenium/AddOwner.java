package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddOwner {
@FindBy (xpath="//*[@id=\"firstName\"]")
    private WebElement first;

@FindBy (xpath = "//*[@id=\"lastName\"]")
    private WebElement last;

@FindBy (xpath= "//*[@id=\"address\"]")
    private WebElement address;

@FindBy (xpath= "//*[@id=\"city\"]")
    private WebElement city;

@FindBy (xpath="//*[@id=\"telephone\"]")
    private WebElement phone;

@FindBy (xpath="/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
    private WebElement addButton;


public void ownerAdd (String first1, String last1, String address1, String city1, String phone1 ){
    first.sendKeys(first1);
    last.sendKeys(last1);
    address.sendKeys(address1);
    city.sendKeys(city1);
    phone.sendKeys(phone1);
    addButton.click();
}

}


