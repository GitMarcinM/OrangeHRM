import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
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

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Utils.equalsCurrentPage();
    }

    @When("User logs in as Admin")
    public void user_logs_in_as_admin() {
        orangeHrm.fillLoginDetails(userLogin, userPassword);
    }

    @And("User chooses Configuration option from the Admin menu")
    public void user_chooses_configuration_option_from_the_admin_menu() {
        orangeHrm.adminModule.click();
    }

    @And("User chooses Location option from the Configuration menu")
    public void user_chooses_location_option_from_the_configuration_menu() {
        orangeHrm.menu.click();
        orangeHrm.localization.click();
    }

    @And("User clicks on the Edit button")
    public void user_clicks_on_the_edit_button() {
        orangeHrm.buttonClick();
    }

    @And("User chooses German language from the dropdown list")
    public void user_chooses_german_language_from_the_dropdown_list() {
        orangeHrm.changeLanguage(language);
    }

    @And("User click on the Save button")
    public void user_click_on_the_save_button() {
        orangeHrm.buttonClick();
    }

    @Then("Website language changes into German")
    public void website_language_changes_into_german() {
        orangeHrm.equalsMainMenuList(MainMenuList.targetMenu);
    }

    @When("User logs in ")
    public void user_logs_in() {
    }

    @When("User use invalid login {string} or password {string}")
    public void userUseInvalidLoginAndOrPassword(String login, String password) {
        orangeHrm.fillLoginDetails(login, password);
        orangeHrm.spanMessage();
    }
}