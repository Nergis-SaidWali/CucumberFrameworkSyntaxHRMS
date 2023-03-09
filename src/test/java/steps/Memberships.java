package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class Memberships extends CommonMethods {
    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        sendText(login.usernameTextField, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordTextField, ConfigReader.getPropertyValue("password"));
    }


    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        click(login.loginButton);
    }


    @When("user clicks on Admin from the Dashboard directory menu")
    public void user_clicks_on_admin_from_the_dashboard_directory_menu() {
        click(adminPage.AdminOption);
    }

    @Then("user clicks on Qualifications from the Dashboard Admin menu")
    public void user_clicks_on_from_the_dashboard_admin_menu() {
        click(adminPage.QualificationsDropdown);
    }

    @Then("user clicks on Memberships from the dropdown menu")
    public void user_clicks_on_from_the_dropdown_menu() {
        click(adminPage.MembershipOption);
    }

    @Then("user should be able to verify they are on the {string} List Page")
    public void user_should_be_able_to_verify_they_are_on_the_list_page(String header) {
        String expectedHeader=membershipsPage.MembershipsPageHeader.getText();
        Assert.assertEquals(expectedHeader, header);
    }

    @When("user clicks on the add button")
    public void user_clicks_on_the_add_button() {

        click(membershipsPage.addButton);
    }

    @When("user enters the membership name {string} into the name field")
    public void user_enters_the_membership_name_into_the_name_field(String membershipName) {
        sendText(membershipsPage.membershipNameField, membershipName);
    }

    @When("user clicks on the save button")
    public void user_clicks_on_the_save_button() {

        click(membershipsPage.saveButton);
    }

    @Then("user should be able to verify the membership is added successfully")
    public void user_should_be_able_to_verify_the_membership_is_added_successfully() {
        List<WebElement> nameColumn = (List<WebElement>) membershipsPage.membershipTblNameColumn;
        for (int i = 0; i < nameColumn.size(); i++) {
            String membershipName = nameColumn.get(i).getText();
            String expectedName = "JavaClubGroup8";
            Assert.assertEquals(expectedName, membershipName);
        }
    }

}
