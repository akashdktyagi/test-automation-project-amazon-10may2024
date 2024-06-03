package devopsclub;


import org.bson.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class MyFirstSimpleSeleniumTestCase {


/*
    Concepts for today: Selenium Basics of Xpaths, Sync, Wait, Assertions, Validations, Debugging, Try Catch
    * Intro to a New IDE, Jetbrains AQUA
    * Automating the Amazon website add to cart functionality
    * Iterating through Elements, list of WebElements
    * Implicit wait
    * Explicit wait - Web Driver Wait and Fluent wait. Expected conditions. Function and Predicate. Check the as well: https://stackoverflow.com/questions/40753321/fluent-wait-vs-webdriver-wait
    * Xpaths capturing
    * Validations and Assertions where some text capturing and calculations are involved.
    * Debugging a problem and visualise the variables and their values
    * Try catch to handle stale element exceptions
 */
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://amazon.in");

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))  ;
        searchBox.sendKeys("Samsung");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
        searchButton.click();
        
        WebElement firstProductAddToCartButton = driver.findElement(By.xpath("//button[@id='a-autoid-1-announce']"));
        firstProductAddToCartButton.click();

        driver.findElement(By.xpath("//button[@id='a-autoid-2-announce']")).click();

//        WebElement secondProductAddToCartButton = driver.findElement(By.xpath("//button[@id='a-autoid-2-announce']"));
//        secondProductAddToCartButton.click();

        WebElement cartIcon = driver.findElement(By.xpath("//a[@id='nav-cart']"));
//        cartIcon.click();

        WebElement productCount = driver.findElement(By.xpath("//div[@id='nav-cart-count-container']"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        webDriverWait.until(x -> productCount.getText().equals("1"));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(productCount, "2"));

        System.out.print(productCount.getText());


        //fetch the amounts
        List<WebElement> listOfProductPrices = driver.findElements(By.xpath("//span[@class='a-price']//span[@class='a-price-whole']"));
        listOfProductPrices.forEach(x -> System.out.println(x.getText()));

        String amountFirstProduct = listOfProductPrices.get(0).getText().replace(",","");
        String amountSecondProduct = listOfProductPrices.get(1).getText().replace(",","");

        int a = Integer.parseInt(amountFirstProduct);
        int b = Integer.parseInt(amountSecondProduct);

        int totalAmountExpected = a + b;
        System.out.println(totalAmountExpected);

        String actualAmountString = driver.findElement(By.xpath("//span[@class='ewc-subtotal-amount']/span")).getText().replace(",","");

        double actualAmountDouble = Double.parseDouble(actualAmountString.trim());
        int actualAmount = (int) actualAmountDouble;

        System.out.println(actualAmount);




//        public void exampleOfFluentWait() {
//            WebElement foo = driver.findElement(By.id("foo"));
//            new FluentWait<WebElement>(foo)
//                    .withTimeout(10, TimeUnit.SECONDS)
//                    .pollingEvery(2, TimeUnit.SECONDS)
//                    .until(new Function<WebElement, Boolean>() {
//                        @Override
//                        public Boolean apply(WebElement element) {
//                            return element.getText().contains("foo");
//                        }
//                    });
//        }


//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(30, SECONDS)
//                .pollingEvery(5, SECONDS)
//                .ignoring(NoSuchElementException.class);
//
//        WebElement foo = wait.until(new Function<WebDriver, WebElement>()
//        {
//            public WebElement apply(WebDriver driver) {
//                driver.findElement(By.id("foo"));
//            }
//        });











    }
}
