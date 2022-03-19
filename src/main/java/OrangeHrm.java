import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class OrangeHrm {

    public OrangeHrm() {
        PageFactory.initElements(Utils.getWebDriver(), this);
    }

    private
    @FindBy(css = "input[id='txtUsername']")
    WebElement inputUserName;
    @FindBy(css = "input[id='txtPassword']")
    WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]/b")
    WebElement adminModule;
    @FindBy(xpath = "//*[@id=\"menu_admin_Configuration\"]")
    WebElement menu;
    @FindBy(id = "menu_admin_localization")
    WebElement localization;
    @FindBy(id = "btnSave")
    WebElement button;
    @FindBy(id = "localization_dafault_language")
    WebElement languageBar;
    @FindBy(className = "firstLevelMenu")
    List <WebElement> mainMenu;
    @FindBy(id = "spanMessage")
    WebElement spanMessage;

    public void fillLoginDetails(String login, String password) {
        Utils.typeText(inputUserName, login);
        inputUserName.sendKeys(Keys.TAB);
        Utils.typeText(inputPassword, password);
        inputPassword.sendKeys((Keys.ENTER));
    }
    public void configuration() {
        adminModule.click();
        menu.click();
        localization.click();
    }
    public void buttonClick() {
        button.click();
    }
    public void changeLanguage(String lang) {
        languageBar.click();
        Select select = new Select(languageBar);
        select.selectByVisibleText(lang);
    }
    public void equalsMainMenuList(List list) {
        List<String> pagesTitle1 = new ArrayList<String>(list);
        List<String> pagesTitle2 = new ArrayList<String>();
        List<WebElement> firstLevelMenuOptions = mainMenu;
        for (WebElement webElement : firstLevelMenuOptions) {
            pagesTitle2.add(webElement.getText());
        }
        Assert.assertEquals(pagesTitle1, pagesTitle2);
    }

    public void equalsLoginPage() {
        spanMessage.isDisplayed();
    }
}
