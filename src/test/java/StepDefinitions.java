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
    String userLogin = "Admin";
    String userPassword = "admin123";
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
        base.fillLoginDetails(userLogin, userPassword);
    }

    //Change language into German

    @And("User chooses Configuration option from the Admin menu")
    public void userChoosesConfigurationOption() {
        lang.adminModule.click();
        lang.menuConfiguration.click();
    }

    @And("User chooses Location option from the Configuration menu")
    public void userChoosesLocationOption() {
        lang.localization.click();
    }

    @When("User click on the Edit button")
    public void userClicksEditButton() {
        base.editSaveButtonClick();
    }

    @And("User chooses German language from the dropdown list")
    public void userChoosesGermanLanguage() {
        lang.changeLanguage(language);
    }

    @And("User click on the Save button")
    public void userClickSaveButton() {
        base.editSaveButtonClick();
    }

    @Then("Website language changes into German")
    public void languageChangesIntoGerman() {
        lang.equalsMainMenuList(MainMenuList.targetMenu);
    }

    @When("User use login {string} and password {string} from the table")
    public void userUseInvalidLoginAndOrPassword(String login, String password) {
        base.fillLoginDetails(login, password);
    }

    @Then("Span message is displayed")
    public void spanMessageIsDisplayed() {
        base.spanMessage();
    }

    //Create a new Employee

    String firstName = "New";
    String lastName = "User";

    @And("User click the PIM menu")
    public void userClickThePIMMenu() {
        employee.pimModule.click();
    }

    @And("User click on the Add button")
    public void userClickOnTheAddButton() {
        employee.addEmployeeButton.click();
    }

    @When("User fill the required fields")
    public void userFillTheRequiredFields() {
        employee.fillNewEmployeeData(firstName, lastName);
    }

    @Then("New employee was created")
    public void newEmployeeWasCreated() {
        employee.employeeDetails();
    }

    @And("The data matches")
    public void theDataMatches() {
        employee.equalsCreatedEmployee(firstName, lastName);
    }

    // Remove an Employee

    @And("User fill the Employee Name field")
    public void userFillTheEmployeeNameField() {
        Utils.typeText(employee.searchEmployee, firstName +" " + lastName);
    }

    @And("User click on the Search button")
    public void userClickOnTheSearchButton() {
        employee.searchButton.click();
    }

    @When("User mark checkbox next to the employee data")
    public void userMarkCheckboxNextToTheEmployeeData() {
        Utils.waitForElement(employee.markCheckbox);
        employee.markCheckbox.click();
    }

    @And("User click on the Delete button")
    public void userClickOnTheDeleteButton() {
        employee.deleteButton.click();
    }

    @And("User confirm delete of employee")
    public void userConfirmDeleteOfEmployee() {
        employee.dialogButton.click();
    }

    @Then("User get message {string}")
    public void userGetMessage(String arg0) {
        employee.assertRemovedEmployee();
    }
}