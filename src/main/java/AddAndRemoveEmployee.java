import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddAndRemoveEmployee {

    public AddAndRemoveEmployee() {
        PageFactory.initElements(Utils.getWebDriver(), this);
    }

    @FindBy(id = "menu_pim_viewPimModule")
    WebElement pimModule;
    @FindBy(id = "firstName")
    WebElement inputFirstName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "btnAdd")
    WebElement addEmployeeButton;
    @FindBy(id = "employee-details")
    WebElement employeeDetails;
    @FindBy(id = "personal_txtEmpFirstName")
    WebElement txtEmpFirstName;
    @FindBy(id = "personal_txtEmpLastName")
    WebElement txtEmpLastName;
    @FindBy(id = "empsearch_employee_name_empName")
    WebElement searchEmployee;
    @FindBy(id = "searchBtn")
    WebElement searchButton;
    @FindBy(id = "btnDelete")
    WebElement deleteButton;
    @FindBy(id = "dialogDeleteBtn")
    WebElement dialogButton;
    @FindBy(xpath = "//td/input")
    WebElement markCheckbox;
    @FindBy(xpath = "//div[@class='message success fadable']")
    WebElement deleteMessage;

    public void employeeMenu() {
        pimModule.click();
    }
    public void addEmployee() {
        addEmployeeButton.click();
    }

    public void fillNewEmployeeData(String firstName, String lastName) {
        Utils.typeText(inputFirstName, firstName);
        Utils.typeText(inputLastName, lastName);
    }

    public void employeeDetails() {
        Assert.assertTrue(employeeDetails.isDisplayed());
    }

    public void equalsCreatedEmployee(String firstName, String lastName) {
        assertThat(txtEmpFirstName.getAttribute("value"), is(firstName));
        assertThat(txtEmpLastName.getAttribute("value"), is(lastName));
    }
    public  void searchEmployee(String firstName, String lastName) {
        Utils.typeText(searchEmployee, firstName +" " + lastName);
        searchButton.click();
    }
    public void deleteEmployee() {
        markCheckbox.click();
        deleteButton.click();
        dialogButton.click();
    }
    public void assertRemovedEmployee() {
        Utils.waitForElement(deleteMessage);
        Assert.assertTrue(deleteMessage.isDisplayed());
    }

}
