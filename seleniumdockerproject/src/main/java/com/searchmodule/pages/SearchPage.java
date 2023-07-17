package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchTextbox;
    private WebElement searchBtn;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        this.driver.get("https://duckduckgo.com/");
    }
    public void doSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTextbox));
        this.searchBtn = this.driver.findElement(By.cssSelector("[aria-label = Search]"));
        searchTextbox.sendKeys(keyword);
        this.searchBtn.click();
    }

    public void goToVideo(){
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
    }

    public int getResult(){
        By by = By.className("tile__media");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
//        System.out.println(this.allVideos.size());
        return this.allVideos.size();
    }

}
