import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public class BookingManagementBlock {
    WebDriver driver;
    @FindBy(xpath="(//div[text()='Управление бронированием']//parent::button)[1]")
    private WebElement tabBookingManagement;
    @FindBy(xpath="(//input[@placeholder='Фамилия клиента'])[1]")
    private WebElement inputClientName;
    @FindBy(xpath="(//input[@placeholder='Номер бронирования или билета'])[1]")
    private WebElement inputBookingNumber;
    @FindBy(xpath="//button[text()='Поиск']//parent::div")
    private WebElement buttonSearch;
    @FindBy(xpath="//div[@ng-if='vm.errorMessage'][text()='Заказ с указанными параметрами не найден']")
    private WebElement bookingErrorMessage;

    public BookingManagementBlock (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyInputs() {
        if (inputClientName.isDisplayed()
                &&inputBookingNumber.isDisplayed()
                &&buttonSearch.isDisplayed()
        )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void scrollToBookingManagementBlock() throws InterruptedException {
        Actions actions=new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: \"center\",inline: \"center\",behavior: \"smooth\"});",tabBookingManagement);
        //actions.scrollToElement(tabBookingManagement).perform();
        actions.scrollToElement(tabBookingManagement).click().perform();
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(tabBookingManagement)).click();
    }
    public void fillInputClientName(String name) throws InterruptedException {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputClientName)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputClientName)).sendKeys(name);
    }

    public void fillInputBookingNumber(String number) throws InterruptedException {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputBookingNumber)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputBookingNumber)).sendKeys(number);
    }

    public void clickSearchButton() throws InterruptedException {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonSearch)).click();

    }

    public void switchToNewTab() throws InterruptedException {
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }


    public boolean verifyBookingErrorMessage() {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        if(webDriverWait.until(ExpectedConditions.visibilityOf(bookingErrorMessage)).isDisplayed())
        {
            return true;
        }
        else {
            return false;
        }
    }

}