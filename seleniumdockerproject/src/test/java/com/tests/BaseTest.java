package com.tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupTest() throws MalformedURLException {
        String host;
        String port;
        MutableCapabilities webDriverOptions;

        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            webDriverOptions = new FirefoxOptions();
        }else{
            webDriverOptions = new ChromeOptions();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
            if(System.getProperty("PORT") != null){
                port = System.getProperty("PORT");
            }else{
                port = "4444";
            }
        }else{
            host = "localhost";
            port = "8484";
        }


        String webDriverUrl = "http://" + host + ":" + port +"/wd/hub";
        this.driver = new RemoteWebDriver(new URL(webDriverUrl), webDriverOptions);


        //set driver path
//        System.setProperty("webdriver.chrome.driver","D:\\learning\\test-automation\\java-test-automation\\resources\\driver_v1\\chromedriver.exe");
//        this.driver = new ChromeDriver();
//        System.out.println("Setuptest in base class");
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }


}
