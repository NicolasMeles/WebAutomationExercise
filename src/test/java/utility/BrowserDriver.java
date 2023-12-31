package utility;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;


public class BrowserDriver {
    public static WebDriver driver;
    public static java.lang.String backpackName;
    public static java.lang.String backpackValue;
    public static java.lang.String bikeLightName;
    public static java.lang.String bikeLightValue;
    public void assignVariables(){
        backpackName = driver.findElement(By.xpath("//a[@id='item_4_title_link']//div[@class='inventory_item_name ']")).getText();
        backpackValue = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']/ancestor::div[@class='pricebar']//div[@class='inventory_item_price']")).getText();
        bikeLightName = driver.findElement(By.xpath("//a[@id='item_0_title_link']//div[@class='inventory_item_name ']")).getText();
        bikeLightValue = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light']/ancestor::div[@class='pricebar']//div[@class='inventory_item_price']")).getText();
    }
    public BrowserDriver() {
        System.setProperty("webdriver.chrome.driver", "C://Users//T-GAMER//Documents//NTTDataProject//src//test//resources//drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }
    public void verifyValues(String firstItemStringValue, String secondItemStringValue, String totalStringValue){
        String firstItemValue = firstItemStringValue.replace("$", "");
        String secondItemValue = secondItemStringValue.replace("$", "");
        String[] totalIValue = StringUtils.split(totalStringValue, "$");
        if(Float.parseFloat(totalIValue[1]) != Float.parseFloat(secondItemValue) + Float.parseFloat(firstItemValue) ){
            System.out.println("Test Failed");
            driver.quit();
        }
    }

}