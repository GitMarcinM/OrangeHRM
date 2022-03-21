import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    public OrangeHrm orangeHrm = new OrangeHrm();
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
        orangeHrm.fillLoginDetails(userLogin, userPassword);
    }

    //Change language into German

    @And("User chooses Configuration option from the Admin menu")
    public void userChoosesConfigurationOption() {
        orangeHrm.adminModule.click();
    }

    @And("User chooses Location option from the Configuration menu")
    public void userChoosesLocationOption() {
        orangeHrm.menu.click();
        orangeHrm.localization.click();
    }

    @When("User click on the Edit button")
    public void userClicksEditButton() {
        orangeHrm.buttonClick();
    }

    @And("User chooses German language from the dropdown list")
    public void userChoosesGermanLanguage() {
        orangeHrm.changeLanguage(language);
    }

    @And("User click on the Save button")
    public void userClickSaveButton() {
        orangeHrm.buttonClick();
    }

    @Then("Website language changes into German")
    public void languageChangesIntoGerman() {
        orangeHrm.equalsMainMenuList(MainMenuList.targetMenu);
    }

    @When("User use invalid login {string} or password {string}")
    public void userUseInvalidLoginAndOrPassword(String login, String password) {
        orangeHrm.fillLoginDetails(login, password);
    }

    @Then("Span message is displayed")
    public void spanMessageIsDisplayed() {
        orangeHrm.spanMessage();
    }

    //Create a new Employee

    String firstName = "New";
    String lastName = "User";

    @And("User click the PIM menu")
    public void userClickThePIMMenu() {
        orangeHrm.pimModule.click();
    }

    @And("User click on the Add button")
    public void userClickOnTheAddButton() {
        orangeHrm.addEmployee.click();
    }

    @When("User fill the required fields")
    public void userFillTheRequiredFields() {
        orangeHrm.fillNewEmployeeData(firstName, lastName);
    }

    @Then("New employee was created")
    public void newEmployeeWasCreated() {
        orangeHrm.employeeDetails();
    }

    @And("The data matches")
    public void theDataMatches() {
        orangeHrm.equalsCreatedEmployee(firstName, lastName);
    }

    // Remove an Employee

    @And("User fill the Employee Name field")
    public void userFillTheEmployeeNameField() {
        Utils.typeText(orangeHrm.searchEmployee, firstName +" " + lastName);
    }

    @And("User click on the Search button")
    public void userClickOnTheSearchButton() {
        orangeHrm.searchButton.click();
    }

    @When("User mark checkbox next to the employee data")
    public void userMarkCheckboxNextToTheEmployeeData() {
        orangeHrm.markCheckbox.click();
    }

    @And("User click on the Delete button")
    public void userClickOnTheDeleteButton() {
        orangeHrm.deleteButton.click();
    }

    @And("User confirm delete of employee")
    public void userConfirmDeleteOfEmployee() {
        orangeHrm.dialogButton.click();
    }

    @Then("User get message {string}")
    public void userGetMessage(String arg0) {
        orangeHrm.deleteMessage.isDisplayed();
    }
}