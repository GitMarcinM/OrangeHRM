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

    @When("User chooses Configuration option from the Admin menu")
    public void userChoosesConfigurationOption() {
        orangeHrm.adminModule.click();
    }

    @And("User chooses Location option from the Configuration menu")
    public void userChoosesLocationOption() {
        orangeHrm.menu.click();
        orangeHrm.localization.click();
    }

    @And("User click on the Edit button")
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
}