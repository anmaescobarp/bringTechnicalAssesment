package com.bring.flights.page_object;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

public class ReserveTripPage extends PageObject {

    private WebDriverWait wait;
    private WebDriver webDriver;

    // Constructor
    public ReserveTripPage(WebDriver driver) {
        super(driver);
        wait= new WebDriverWait(driver, 7);
        webDriver=driver;
    }

    //Static Locators
    // Login Later Button
    By loginLaterButton= By.cssSelector("div.login-touchpoint>button");
    // Title Dropdown button - Passengers
    By titleDropdownButton = By.cssSelector("pax-passenger pax-details-form button"); // lista de dropdowns
    // Title Dropdown Options - Passengers
    //By titleDropdownOptions = By.cssSelector("//ry-dropdown-item//div[@class=\"dropdown-item__content\"]/div[text()=\"Mr\"]"); //dinamico y le doy click aca
    // First Name Passengers TextBoxList
    By firstNamePassengersTextBox = By.cssSelector("ry-input-d[data-ref=\"pax-details__name\"] div>input"); // lista de inputs
    //Last Name Passengers TextBox
    By lastNamePassengersTextBox = By.cssSelector("ry-input-d[data-ref=\"pax-details__surname\"] div>input"); // lista
    // Continue Button
    By continueButton = By.cssSelector("button[class*=\"continue-flow__button\"]");




    //Methods
    public void clickOnLoginLater()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(loginLaterButton));
        webDriver.findElement(loginLaterButton).click();
    }

    public void FillOutPassengersInfo(List<List<String>> passengersInfo) throws InterruptedException {
        List<String> titles = passengersInfo.get(0);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(titleDropdownButton));
        List<WebElement> dropdownButtonList = webDriver.findElements(titleDropdownButton);
        List<WebElement> firstNameTextBoxList = webDriver.findElements(firstNamePassengersTextBox);
        List<WebElement> lastNameTextBoxList = webDriver.findElements(lastNamePassengersTextBox);
        JavascriptExecutor javaScriptObject = (JavascriptExecutor) webDriver;
        javaScriptObject.executeScript("arguments[0].scrollIntoView(true);", dropdownButtonList.get(0));
        for (int i=1; i<passengersInfo.size();i++)
        {
            for(int j = 0; j< passengersInfo.get(i).size(); j++)
            {
                if(passengersInfo.get(i).get(j).toLowerCase(Locale.ROOT).equals("yes"))
                {
                    Actions builder = new Actions(webDriver);
                    Action mouseOver = builder.moveToElement(dropdownButtonList.get(i-1)).click().build();
                    mouseOver.perform();
                    int IndexOfTitle = IndexOfTitlePassenger(passengersInfo.get(i).get(j+1));
                    // Title Dropdown Options - Passengers
                    By titleDropdownOptions = By.cssSelector("div.dropdown.b2.dropdown--opened > div > div > ry-dropdown-item:nth-child("+IndexOfTitle+") > button");
                    wait.until(ExpectedConditions.visibilityOfElementLocated(titleDropdownOptions));
                    webDriver.findElement(titleDropdownOptions).click();
                }
                if(titles.get(j).equals("FirstName"))
                {
                    firstNameTextBoxList.get(i-1).sendKeys(passengersInfo.get(i).get(j));
                }
                if(titles.get(j).equals("LastName"))
                {
                    lastNameTextBoxList.get(i-1).sendKeys(passengersInfo.get(i).get(j));
                }
            }
        }

    }

    public void ClickOnContinue(){
        webDriver.findElement(continueButton).click();
    }

    private int IndexOfTitlePassenger(String title){
        switch (title){
            case "Mr": return 1;
            case "Mrs": return 2;
            case "Ms": return 3;
            default:return 0;
        }
    }

}
