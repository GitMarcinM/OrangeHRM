import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrangeHrmNonBddTest {

    public OrangeHrm orangeHrm = new OrangeHrm();
    String firstName = "New";
    String lastName = "User";

    @Before
    public void startUp() {
        Utils.getWebDriver().get(Utils.getDomain());
        String userLogin = "Admin";
        String userPassword = "admin123";
        orangeHrm.fillLoginDetails(userLogin, userPassword);
    }

    @After
    public void closeBrowser() {
        Utils.close();
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
        orangeHrm.employeeMenu();
        orangeHrm.addEmployee();
        orangeHrm.buttonClick();
        orangeHrm.fillNewEmployeeData(firstName, lastName);
        orangeHrm.buttonClick();
        orangeHrm.employeeDetails();
        orangeHrm.equalsCreatedEmployee(firstName, lastName);
    }

    @Test
    public void deleteEmployee() {
        orangeHrm.employeeMenu();
        Utils.waitForElement(orangeHrm.searchEmployee);
        orangeHrm.searchEmployee(firstName, lastName);
        orangeHrm.deleteEmployee();

    }
}
