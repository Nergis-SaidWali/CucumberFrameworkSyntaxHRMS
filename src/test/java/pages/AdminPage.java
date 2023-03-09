package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AdminPage extends CommonMethods {

    @FindBy(xpath = "//b[text()='Admin']")
    public WebElement AdminOption;

    @FindBy (xpath = "//a[text()='Qualifications']")
    public WebElement QualificationsDropdown;

    @FindBy (xpath = "//a[text()='Memberships']")
    public WebElement MembershipOption;

    public AdminPage(){
        PageFactory.initElements(driver, this);
    }
}