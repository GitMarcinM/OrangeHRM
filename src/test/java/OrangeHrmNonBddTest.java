import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrangeHrmNonBddTest {

    public Base base = new Base();
    private AddAndRemoveEmployee employee = new AddAndRemoveEmployee();
    private ChangeLangToGerman lang = new ChangeLangToGerman();
    String firstName = "New";
    String lastName = "User";

    @Before
    public void startUp() {
        Utils.getWebDriver().get(Utils.getDomain());
        String userLogin = "Admin";
        String userPassword = "admin123";
        base.fillLoginDetails(userLogin, userPassword);
    }

    @After
    public void closeBrowser() {
        Utils.close();
    }

    @Test
    public void changeLangToGermanNonBddTest() {
        String language = "German - Deutsch";
        lang.configurationMenu();
        base.editSaveButtonClick();
        lang.changeLanguage(language);
        base.editSaveButtonClick();
        lang.equalsMainMenuList(MainMenuList.targetMenu);
    }

    @Test
    public void addNewEmployee() {
        employee.employeeMenu();
        employee.addEmployee();
        base.editSaveButtonClick();
        employee.fillNewEmployeeData(firstName, lastName);
        base.editSaveButtonClick();
        employee.employeeDetails();
        employee.equalsCreatedEmployee(firstName, lastName);
    }

    @Test
    public void deleteEmployee() {
        employee.employeeMenu();
        Utils.waitForElement(employee.searchEmployee);
        employee.searchEmployee(firstName, lastName);
        employee.deleteEmployee();

    }
}
