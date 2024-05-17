import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;

    @BeforeEach
    public void  setUp()
    {
        driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\chdriver\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.pobeda.aero/");
    }

    @Test
    public void Test1() throws InterruptedException {
        StartPage startPage=new StartPage(driver);
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        startPage.moveToButtonInformation();
        InformationHoverMenu informationHoverMenu=new InformationHoverMenu(driver);
        Assertions.assertTrue(informationHoverMenu.verifyHeaders());
    }

    @Test
    public void Test2() throws InterruptedException {
        StartPage startPage=new StartPage(driver);
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        TicketSearchBlock ticketSearchBlock=new TicketSearchBlock(driver);
        ticketSearchBlock.scrollToSearchTicketBlock();
        Assertions.assertTrue(ticketSearchBlock.verifyInputs());
        ticketSearchBlock.fillInputFrom("Москва");
        ticketSearchBlock.fillInputTo("Санкт-Петербург");
        ticketSearchBlock.clickSearchButton();
        Assertions.assertTrue(ticketSearchBlock.verifyInputDateFromErrorBorderColor());
    }

    @Test
    public void Test3() throws InterruptedException {
        StartPage startPage=new StartPage(driver);
        Assertions.assertTrue(startPage.verifySiteIsOpen());
        BookingManagementBlock bookingManagementBlock=new BookingManagementBlock(driver);
        bookingManagementBlock.scrollToBookingManagementBlock();
        Assertions.assertTrue(bookingManagementBlock.verifyInputs());
        bookingManagementBlock.fillInputClientName("Qwerty");
        bookingManagementBlock.fillInputBookingNumber("XXXXXX");
        bookingManagementBlock.clickSearchButton();
        bookingManagementBlock.switchToNewTab();
        Assertions.assertTrue(bookingManagementBlock.verifyBookingErrorMessage());
    }

    @AfterEach
    public void tearDown()
    {
        driver.quit();
    }
}