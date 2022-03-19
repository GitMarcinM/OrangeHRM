import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChangeLangToGermanNonBddTest {

    public OrangeHrm orangeHrm = new OrangeHrm();

    @Before
    public void startUp() {
        Utils.getWebDriver().get(Utils.getDomain());
    }

    @Test
    public void test() {
        String userLogin = "Admin";
        String userPassword = "admin123";
        String language = "German - Deutsch";
        orangeHrm.fillLoginDetails(userLogin,userPassword);
        orangeHrm.configuration();
        orangeHrm.buttonClick();
        orangeHrm.changeLanguage(language);
        orangeHrm.buttonClick();
        orangeHrm.equalsMainMenuList(MainMenuList.targetMenu);
    }

    @After
    public void closeBrowser() {
        Utils.close();
    }
}
