import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Base {

    @FindBy(id = "txtUsername")
    WebElement inputLogin;
    @FindBy(css = "input[id='txtPassword']")
    WebElement inputPassword;
    @FindBy(id = "btnSave")
    WebElement editSaveButton;
    @FindBy(id = "spanMessage")
    WebElement spanMessage;

    public Base() {
        PageFactory.initElements(Utils.getWebDriver(), this);
    }

    public void fillLoginDetails(String login, String password) {
        Utils.typeText(inputLogin, login);
        Utils.typeText(inputPassword, password);
        inputPassword.sendKeys((Keys.ENTER));
    }
    public void editSaveButtonClick() {
        editSaveButton.click();
    }

    public void spanMessage() {
        Assert.assertTrue(spanMessage.isDisplayed());
    }
}
