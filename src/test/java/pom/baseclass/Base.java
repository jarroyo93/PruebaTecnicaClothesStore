package pom.baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {

    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriveConecction() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }


    public void visit(String URL){
        driver.get(URL);
    }

    public void scroll(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void forceClick(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].click();", element);

    }

    public void theWait(By locator){
        WebDriverWait ewait = new WebDriverWait(driver, 5);
        ewait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void setText(String text, By locator){
        driver.findElement(locator).sendKeys(text);
    }
}
