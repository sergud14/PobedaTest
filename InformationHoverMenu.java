import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InformationHoverMenu {
    WebDriver driver;
    @FindBy(xpath="//a[@href='/information#flight']")
    private WebElement headerFlight;
    @FindBy(xpath="//a[@href='/information#useful']")
    private WebElement headerUseful;
    @FindBy(xpath="//a[@href='/information#company']")
    private WebElement headerCompany;
    public InformationHoverMenu (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyHeaders() {
        if (headerFlight.getText().equals("Подготовка к полёту") &&
                headerUseful.getText().equals("Полезная информация") &&
                headerCompany.getText().equals("О компании"))
            {
                    return true;
            }
                else
            {
                return false;
            }
    }

}

