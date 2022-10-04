package pom.baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriveConecction() { //llamamos el chromedriver
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void visit(String URL){
        driver.get(URL);
    }

    public void scroll(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollByElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
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

    public void theWaitClickable(By locator){
        WebDriverWait ewait = new WebDriverWait(driver, 5);
        ewait.until(ExpectedConditions.elementToBeClickable(locator));
    }

   public static boolean OnlyNumbers(String chain) {
        for (int x = 0; x < chain.length(); x++) {
            int c = chain.charAt(x);
            if ((c >= 0 && c <= 44) || (c == 47) ||(c>= 58 && c <= 127)) {
                return false;
            }
        }
        return true;
    }

    public void setText(String text, By locator){
        driver.findElement(locator).sendKeys(text);
    }
}
