package stepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserDriver;
import java.time.Duration;



public class Purchase extends BrowserDriver {


    @Given("user is logged on Swag Labs")
    public void userIsLoggedOnSwagLabs() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        validatingUsers("standard_user");
    }

    @And("adding products to the cart")
    public void addingProductsToTheCart() {
        assignVariables();
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        boolean validateFirstProductName = backpackName.equals(driver.findElement(By.xpath("//a[@id='item_4_title_link']//div[@class='inventory_item_name']")).getText());
        boolean validateFirstProductValue = backpackValue.equals(driver.findElement(By.xpath("//button[@name='remove-sauce-labs-backpack']/ancestor::div[@class='item_pricebar']//div[@class='inventory_item_price']")).getText());
        boolean validateSecondProductName = bikeLightName.equals(driver.findElement(By.xpath("//a[@id='item_0_title_link']//div[@class='inventory_item_name']")).getText());
        boolean validateSecondProductValue = bikeLightValue.equals(driver.findElement(By.xpath("//button[@name='remove-sauce-labs-bike-light']/ancestor::div[@class='item_pricebar']//div[@class='inventory_item_price']")).getText());

        if (!validateFirstProductName || !validateFirstProductValue || !validateSecondProductName || !validateSecondProductValue) {
            System.out.println("Test Failed");
            driver.quit();
        }
    }

    @When("buying products of the cart")
    public void buyingProductsOfTheCart() {
        driver.findElement(By.name("checkout")).click();
        driver.findElement(By.name("firstName")).sendKeys("Test");
        driver.findElement(By.name("lastName")).sendKeys("Test");
        driver.findElement(By.name("postalCode")).sendKeys("0000000");
        driver.findElement(By.name("continue")).click();
        java.lang.String totalValueString = driver.findElement(By.className("summary_subtotal_label")).getText();
        verifyValues(backpackValue, bikeLightValue, totalValueString);
        driver.findElement(By.name("finish")).click();

    }
    
    @Then("products will be bought successfully")
    public void productsWillBeBoughtSuccessfully() {

        driver.findElement(By.xpath("//img[@class='pony_express']")).isDisplayed();
        driver.findElement(By.xpath("//h2[@class='complete-header']")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='complete-text']")).isDisplayed();
        driver.findElement(By.xpath("//button[@name='back-to-products']")).isDisplayed();
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }
    
    @And("user will logout of the website")
    public void userWillLogoutOfTheWebsite() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='logout_sidebar_link']")));
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
    }
    
    @Then("products will be successfully added to the cart")
    public void productsWillBeSuccessfullyAddedToTheCart(){
        boolean validateFirstProductName1 = backpackName.equals(driver.findElement(By.xpath("//a[@id='item_4_title_link']//div[@class='inventory_item_name']")).getText());
        boolean validateFirstProductValue1 = backpackValue.equals(driver.findElement(By.xpath("//a[@id='item_4_title_link']/following-sibling::div[@class='item_pricebar']//div[@class='inventory_item_price']")).getText());
        boolean validateSecondProductName1 = bikeLightName.equals(driver.findElement(By.xpath("//a[@id='item_0_title_link']//div[@class='inventory_item_name']")).getText());
        boolean validateSecondProductValue1 = bikeLightValue.equals(driver.findElement(By.xpath("//a[@id='item_0_title_link']/following-sibling::div[@class='item_pricebar']//div[@class='inventory_item_price']")).getText());

        if (!validateFirstProductName1 || !validateFirstProductValue1 || !validateSecondProductName1 || !validateSecondProductValue1) {
            System.out.println("Test Failed");
            driver.quit();
        }


    }
}

