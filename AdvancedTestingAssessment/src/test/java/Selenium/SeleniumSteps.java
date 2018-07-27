package Selenium;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SeleniumSteps {
    WebElement element;
    WebDriver driver;
    String url;
    ExtentTest test;
    ExtentReports report;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\Pet_Tool.html", true);
        test = report.startTest("Pet_Tool");
    }

    @Given("^the home page$")
    public void the_home_page() {
        driver.get(Constant.homeURL);
        test.log(LogStatus.INFO, "Website SuccessfullyAccessed!");
    }

    @When("^i click on the owner tab$")
    public void i_click_on_the_owner_tab() throws Throwable {
        Homepage page = PageFactory.initElements(driver, Homepage.class);
        page.owner();

    }

    @And("^i click on the add button$")
    public void i_click_on_the_add_button() throws Throwable {
        driver.get(Constant.addURL);
        test.log(LogStatus.INFO, "Add Successfully Accessed!");
    }

    @When("^i fill out the details and save$")
    public void i_fill_out_the_details_and_save() throws Throwable {
        AddOwner page2 = PageFactory.initElements(driver, AddOwner.class);
        page2.ownerAdd("lana", "rey", "4 oak lane", "boston", "09473875");
        test.log(LogStatus.INFO, "Owner added");
    }


    @Then("^i click the all button again$")
    public void i_click_the_all_button_again() throws Throwable {
        ViewOwners page3 = PageFactory.initElements(driver, ViewOwners.class);
        page3.viewAll();

    }

    @Then("^i want to view all the pet owners$")
    public void i_want_to_view_all_the_pet_owners() throws Throwable {
        driver.get(Constant.allURL);
        test.log(LogStatus.INFO, "All Owners Accessed!");

        String url = driver.getCurrentUrl();
        System.out.println(url);
        String expected = Constant.allURL;
        if (url.equals(expected)) {
            test.log(LogStatus.PASS, "Success!");
        } else {
            test.log(LogStatus.FAIL, "Failed!");
        }
        assertEquals("Owners", driver.findElement(By.xpath("/html/body/app-root/app-owner-list/div/div/h2")).getText());


    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        report.endTest(test);
        report.flush();
        driver.close();
        driver.quit();
    }


}
