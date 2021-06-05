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

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SelectTrip  extends PageObject {

    private WebDriverWait wait;
    private WebDriver webDriver;

    // Constructor
    public SelectTrip (WebDriver driver) {
        super(driver);
        wait= new WebDriverWait(driver, 7);
        webDriver=driver;
    }

    //Static Locators
    // List of lateral scrolls
    By carousel = By.cssSelector("journey carousel");
    // Value Fares button
    By valueFaresButton = By.cssSelector("div[class*=\"fare-card-item\"]:nth-child(2) fare-card div.fare-card__footer>button");


    // Methods

    private void carousel(int positionCarousel, String expectedDate) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(carousel));
        List<WebElement> r = webDriver.findElements(carousel);
        String classname = r.get(positionCarousel).getAttribute("class");
        Boolean flag = true;
        while(flag){
            By uk = By.cssSelector("journey carousel ul[class*=\""+classname+"\"] button");
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(uk));
            List<WebElement> listFlight = webDriver.findElements(uk);
            for (int i=0; i<listFlight.size();i++){
                String u = listFlight.get(i).getAttribute("data-ref").trim();
                LocalDate dateOnWebElement = LocalDate.parse(u);
                LocalDate expectedDateToSelect = LocalDate.parse(expectedDate);
                if(dateOnWebElement.equals(expectedDateToSelect))
                {
                    WebElement dateToSelect =  listFlight.get(i).findElement(By.xpath("./div[1]"));
                    wait.until(ExpectedConditions.elementToBeClickable(dateToSelect));
                    Actions builder = new Actions(webDriver);
                    Action mouseOver = builder.moveToElement(dateToSelect).click().build();
                    mouseOver.perform();
                    int positionScheduleFlight = positionCarousel+1;
                    By scheduleFlight = By.cssSelector("flights-summary-container div > div:nth-child("+positionScheduleFlight+") flight-list flight-card div[class*=\"card-header\"]");
                    WebElement scheduleFlightElement = webDriver.findElement(scheduleFlight);
                    JavascriptExecutor javaScriptObject = (JavascriptExecutor) webDriver;
                    javaScriptObject.executeScript("arguments[0].scrollIntoView(true);", scheduleFlightElement);
                    wait.until(ExpectedConditions.presenceOfElementLocated(scheduleFlight));
                    scheduleFlightElement.click();
                    flag = false;
                    break;
                }
                if(i==listFlight.size()-1)
                {
                    By lateralScroll = By.cssSelector(" button[aria-label='Search next dates']");
                    wait.until(ExpectedConditions.elementToBeClickable(uk));
                    r.get(positionCarousel).findElement(lateralScroll).click();
                }
            }
        }
    }

    public void chooseDepartureFlight(String date){
        carousel(0, date);
    }

    public void chooseReturnFlight(String date){
        carousel(1, date);
    }

    public void clickOnValueFaresButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(valueFaresButton));
        webDriver.findElement(valueFaresButton).click();
    }

}
