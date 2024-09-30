package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("User page")
public class UserPage extends PageObject {

    private static final String URL = "https://ibello.hu/tasks/cases/#/user";

    @Find(by = By.CLASS_NAME, using = "panel-title")
    private WebElement userTitle;

    @Find(by = By.ID, using = "username")
    private WebElement userNameField;

    @Find(by = By.ID, using = "fullName")
    private WebElement fullNameField;

    @Find(by = By.ID, using = "currentPassword")
    private WebElement currentPasswordField;

    @Find(by = By.ID, using = "password")
    private WebElement passwordField;

    @Find(by = By.ID, using = "password2")
    private WebElement password2Field;

    @Find(by = By.BUTTON_TEXT, using = "${demo.user.button}")
    private WebElement passwordButton;

    @Find(by = By.CLASS_NAME, using = "error")
    private WebElement error;

    public void open_page(){
        browser().openURL(URL);
        browser().resize(1920, 1080);
        browser().maximize();
    }

    public void page_must_be_loaded() {
        String text=getConfigurationValue("demo.user.title").toString();
        expectations().expect(userTitle).toHave().textOrValue(text);
    }

    public void click_on_password_change_button() {
        doWith(passwordButton).click();
    }

    public void set_currentPassword_to_$(String currentPassword) {
        doWith(currentPasswordField).setValue(currentPassword);
    }

    public void set_password_to_$(String password) {
        doWith(passwordField).setValue(password);
    }

    public void set_password2_to_$(String password2) {
        doWith(password2Field).setValue(password2);
    }

    public void error_message_should_be_displayed() {
        expectations().assume(error).toBe().displayed();
    }

    public void $_error_message_should_be_displayed(String msg) {
        expectations().assume(error).toHave().text(msg);
    }

    public void expect_userName_is_$(String userName) {
        expectations().expect(userNameField).toHave().textOrValue(userName);
    }

    public void expect_fullName_is_$(String fullName) {
        expectations().expect(fullNameField).toHave().textOrValue(fullName);
    }

    public void expect_currentPassword_is_$(String currentPassword) {
        expectations().expect(currentPasswordField).toHave().textOrValue(currentPassword);
    }

    public void expect_password_is_$(String password) {
        expectations().expect(passwordField).toHave().textOrValue(password);
    }

    public void expect_password2_is_$(String password2) {
        expectations().expect(password2Field).toHave().textOrValue(password2);
    }

    public void assume_userName_field_is_not_editable() {
        expectations().assume(userNameField).toBe().readonly();
    }

    public void assume_fullName_field_is_not_editable() {
        expectations().assume(fullNameField).toBe().readonly();
    }
}
