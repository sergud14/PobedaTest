import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import javax.swing.*;

public class StartPage {
    WebDriver driver;
    @FindBy(xpath="(//img[@alt='«Авиакомпания «Победа», Группа «Аэрофлот»'])[1]")
    private WebElement logo;
    @FindBy(xpath="//a[@href='/information']")
    private WebElement buttonInformation;
    public StartPage (WebDriver driver)
    {
       this.driver=driver;
       PageFactory.initElements(driver,this);
    }

    public boolean verifySiteIsOpen() {
        if(driver.getTitle().equals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками")&&logo.isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void moveToButtonInformation() throws InterruptedException {
        Actions actions=new Actions(driver);
        actions.moveToElement(buttonInformation).perform();
    }

}
