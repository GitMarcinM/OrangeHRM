import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ChangeLangToGerman {

    public ChangeLangToGerman() {
        PageFactory.initElements(Utils.getWebDriver(), this);
    }

    @FindBy(id = "menu_admin_viewAdminModule")
    WebElement adminModule;
    @FindBy(xpath = "//*[@id=\"menu_admin_Configuration\"]")
    WebElement menuConfiguration;
    @FindBy(id = "menu_admin_localization")
    WebElement localization;
    @FindBy(id = "localization_dafault_language")
    WebElement languageBar;
    @FindBy(className = "firstLevelMenu")
    List<WebElement> mainMenu;

    public void configurationMenu() {
        adminModule.click();
        menuConfiguration.click();
        localization.click();
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
}
