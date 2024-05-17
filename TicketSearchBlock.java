import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TicketSearchBlock {
    WebDriver driver;
    @FindBy(xpath="(//div[text()='Поиск билета']//parent::button)[1]")
    private WebElement tabSearchTicket;
    @FindBy(xpath="(//input[@placeholder='Откуда'])[1]")
    private WebElement inputFrom;
    @FindBy(xpath="(//input[@placeholder='Куда'])[1]")
    private WebElement inputTo;
    @FindBy(xpath="(//input[@placeholder='Туда'])[1]")
    private WebElement inputDateFrom;
    @FindBy(xpath="(//input[@placeholder='Обратно'])[1]")
    private WebElement inputDateTo;
    @FindBy(xpath="//button[text()='Поиск']//parent::div")
    private WebElement buttonSearch;
    @FindBy(xpath="(//*[@placeholder='Туда']//parent::div[@class='dp-1bgth1z-root'][@data-empty='true'][@data-errored='true'])[2]")
    private WebElement inputDateFromError;

    public TicketSearchBlock (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyInputs() {
        if (inputFrom.isDisplayed()
                &&inputTo.isDisplayed()
                &&inputDateFrom.isDisplayed()
                &&inputDateTo.isDisplayed()
        )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void scrollToSearchTicketBlock() throws InterruptedException {
        Actions actions=new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: \"center\",inline: \"center\",behavior: \"smooth\"});",inputFrom);
        actions.scrollToElement(inputFrom).perform();
    }
    public void fillInputFrom(String nameFrom) throws InterruptedException {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputFrom)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputFrom)).clear();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputFrom)).sendKeys(nameFrom);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='"+nameFrom+"']"))).click();
    }

    public void fillInputTo(String nameTo) throws InterruptedException {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputTo)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputTo)).clear();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputTo)).sendKeys(nameTo);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='"+nameTo+"']"))).click();
    }

    public void clickSearchButton() throws InterruptedException {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonSearch)).click();
    }

    public boolean verifyInputDateFromErrorBorderColor() {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        if(inputDateFromError.getCssValue("border-bottom-color").equals("rgba(213, 0, 98, 1)"))
            {
            return true;
            }
            else {
            return false;
            }
        }
}
