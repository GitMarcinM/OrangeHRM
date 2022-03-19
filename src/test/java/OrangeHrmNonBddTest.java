import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrangeHrmNonBddTest {

    public OrangeHrm orangeHrm = new OrangeHrm();

    @Before
    public void startUp() {
        Utils.getWebDriver().get(Utils.getDomain());
        String userLogin = "Admin";
        String userPassword = "admin123";
        orangeHrm.fillLoginDetails(userLogin,userPassword);
    }

    @Test
    public void changeLangToGermanNonBddTest() {
        String language = "German - Deutsch";
        orangeHrm.configuration();
        orangeHrm.buttonClick();
        orangeHrm.changeLanguage(language);
        orangeHrm.buttonClick();
        orangeHrm.equalsMainMenuList(MainMenuList.targetMenu);
    }

    @Test
    public void addNewEmployee() {
        String firstName = "New";
        String lastName = "User";
        orangeHrm.addEmployee();
        orangeHrm.buttonClick();
        orangeHrm.fillNewEmployeeData(firstName, lastName);
        orangeHrm.buttonClick();
        orangeHrm.equalsCreatedEmployee(firstName, lastName);
    }

    @After
    public void closeBrowser() {
        Utils.close();
    }
}
