import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Base {

    final String userLogin = "Admin";
    final String userPassword = "admin123";
    final String firstName = "New";
    final String lastName = "User";

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

    public void editSaveButton() {
        editSaveButton.click();
    }

    public void login() {
        String pageAfterLogin = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        String currentPage = Utils.getWebDriver().getCurrentUrl();
        if (pageAfterLogin.equals(currentPage)) {
            Assert.assertEquals(pageAfterLogin, currentPage);
            System.out.println("User is logged in");
        } else {
            Assert.assertTrue(spanMessage.isDisplayed());
            System.out.println("Invalid credentials - span message is displayed");
        }
    }
}
