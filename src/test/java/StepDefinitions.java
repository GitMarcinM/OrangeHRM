import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    private Base base = new Base();
    private AddAndRemoveEmployee employee = new AddAndRemoveEmployee();
    private ChangeLangToGerman lang = new ChangeLangToGerman();

    String language = "German - Deutsch";

    @Before
    public void starUp() {
        Utils.getWebDriver().get(Utils.getDomain());
    }

    @After
    public void closeBrowser() {
        Utils.close();
    }

    @Given("User logs in as Admin")
    public void userLogsInAsAdmin() {
        base.fillLoginDetails(base.userLogin, base.userPassword);
    }

    @And("User chooses Location option from the Admin > Configuration menu")
    public void userChoosesConfigurationOption() {
        lang.configurationMenu();
    }

    @When("User click on the Edit button")
    public void userClicksEditButton() {
        base.editSaveButton();
    }

    @And("User chooses German language from the dropdown list")
    public void userChoosesGermanLanguage() {
        lang.changeLanguage(language);
    }

    @And("User click on the Save button")
    public void userClickSaveButton() {
        base.editSaveButton();
    }

    @Then("Website language changes into German")
    public void languageChangesIntoGerman() {
        lang.equalsMainMenuList(Enum.targetMenu);
    }

    @When("User use login {string} and password {string} from the table")
    public void userUseInvalidLoginAndOrPassword(String login, String password) {
        base.fillLoginDetails(login, password);
    }

    @Then("User is logged or span message is displayed")
    public void login() {
        base.login();
    }

    @And("User click the PIM menu")
    public void userClickThePIMMenu() {
        employee.employeeMenu();
    }

    @And("User click on the Add button")
    public void userClickOnTheAddButton() {
        employee.addEmployee();
    }

    @When("User fill the required fields")
    public void userFillTheRequiredFields() {
        employee.fillNewEmployeeData(base.firstName, base.lastName);
    }

    @Then("New employee was created")
    public void newEmployeeWasCreated() {
        employee.employeeDetails();
    }

    @And("The data matches")
    public void theDataMatches() {
        employee.equalsCreatedEmployee(base.firstName, base.lastName);
    }

    // Remove an Employee

    @And("User fill the Employee Name field")
    public void userFillTheEmployeeNameField() {
        Utils.typeText(employee.searchEmployee, base.firstName + " " + base.lastName);
    }

    @And("User click on the Search button")
    public void userClickOnTheSearchButton() {
        employee.searchButton();
    }

    @When("User mark checkbox next to the employee data")
    public void userMarkCheckboxNextToTheEmployeeData() {
        employee.markCheckbox(base.firstName);
    }

    @And("User click on the Delete button")
    public void userClickOnTheDeleteButton() {
        employee.deleteEmployee();
    }

    @And("User confirm delete of employee")
    public void userConfirmDeleteOfEmployee() {
        employee.confirmRemove();
    }

    @Then("User get message about successfully deleted an employee")
    public void userGetMessage() {
        employee.assertRemovedEmployee();
    }
}