package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class MembershipsPage extends CommonMethods {

    @FindBy(id ="btnAdd")
    public WebElement addButton;

    @FindBy(id ="btnDelete")
    public WebElement delButton;

    @FindBy(xpath = "//input[@id='membership_name']")
    public WebElement membershipNameField;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement saveButton;

    @FindBy(xpath ="table[@id='resultTable']/tbody/tr/td[2]")
    public WebElement membershipTblNameColumn;

    @FindBy (xpath = "//h1[text()='Memberships']")
    public WebElement MembershipsPageHeader;


    public MembershipsPage() {
        PageFactory.initElements(driver,this);
    }

}
