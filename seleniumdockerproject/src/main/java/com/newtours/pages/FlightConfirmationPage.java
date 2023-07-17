package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class FlightConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#confirm-table tr:nth-child(1) font")
    private WebElement flightConfirmationHeader;
    List<WebElement> prices;


    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;


    public FlightConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public String getPrice(){
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader));
        List<WebElement> allFonts = driver.findElements(By.tagName("font"));
        prices = allFonts.stream()
                .filter(font -> font.getText().contains("USD"))
                .collect(Collectors.toList());
        System.out.println(this.flightConfirmationHeader.getText());
        System.out.println(this.prices.get(1).getText());

        String price = this.prices.get(1).getText();

        this.signOffLink.click();

        return price;
    }
}
