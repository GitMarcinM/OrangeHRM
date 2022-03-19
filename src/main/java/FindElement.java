import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindElement {

    @FindBy(id = "txtUsername")
    WebElement inputLogin;
    @FindBy(css = "input[id='txtPassword']")
    WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]/b")
    WebElement adminModule;
    @FindBy(id = "menu_pim_viewPimModule")
    WebElement pimModule;
    @FindBy(id = "btnAdd")
    WebElement addEmployee;
    @FindBy(id = "firstName")
    WebElement inputFirstName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "personal_txtEmpFirstName")
    WebElement txtEmpFirstName;
    @FindBy(id = "personal_txtEmpLastName")
    WebElement txtEmpLastName;
    @FindBy(xpath = "//*[@id=\"menu_admin_Configuration\"]")
    WebElement menu;
    @FindBy(id = "menu_admin_localization")
    WebElement localization;
    @FindBy(id = "btnSave")
    WebElement button;
    @FindBy(id = "localization_dafault_language")
    WebElement languageBar;
    @FindBy(className = "firstLevelMenu")
    List<WebElement> mainMenu;
    @FindBy(id = "spanMessage")
    WebElement spanMessage;
}
