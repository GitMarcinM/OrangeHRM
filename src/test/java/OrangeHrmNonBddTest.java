import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrangeHrmNonBddTest {

    private Base base = new Base();
    private AddAndRemoveEmployee employee = new AddAndRemoveEmployee();
    private ChangeLangToGerman lang = new ChangeLangToGerman();

    @Before
    public void startUp() {
        Utils.getWebDriver().get(Utils.getDomain());
        base.fillLoginDetails(base.userLogin, base.userPassword);
    }

    @After
    public void closeBrowser() {
        Utils.close();
    }

    @Test
    public void changeLangToGermanNonBddTest() {
        String language = "German - Deutsch";
        lang.configurationMenu();
        base.editSaveButton();
        lang.changeLanguage(language);
        base.editSaveButton();
        lang.equalsMainMenuList(Enum.targetMenu);
    }

    @Test
    public void addNewEmployee() {
        employee.employeeMenu();
        employee.addEmployee();
        base.editSaveButton();
        employee.fillNewEmployeeData(base.firstName, base.lastName);
        base.editSaveButton();
        employee.employeeDetails();
        employee.equalsCreatedEmployee(base.firstName, base.lastName);
    }

    @Test
    public void deleteEmployee() {
        employee.employeeMenu();
        employee.searchEmployee(base.firstName, base.lastName);
        employee.searchButton();
        employee.markCheckbox(base.firstName);
        employee.deleteEmployee();
        employee.confirmRemove();
        employee.assertRemovedEmployee();
    }
}
