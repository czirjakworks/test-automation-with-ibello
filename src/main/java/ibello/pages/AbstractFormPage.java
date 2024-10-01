package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractFormPage extends PageObject {

    @Find(by = By.ID, using = "name")
    private WebElement nameField;

    @Find(by = By.ID, using = "validity")
    private WebElement dateField;

    @Find(by = By.ID, using = "status")
    private WebElement statusField;

    @Find(by = By.ID, using = "person")
    private WebElement personField;

    @Find(by = By.ID, using = "city")
    private WebElement cityField;

    @Find(by = By.ID, using = "zipCode")
    private WebElement zipCodeField;

    @Find(by = By.ID, using = "street")
    private WebElement streetField;

    @Find(by = By.ID, using = "number")
    private WebElement numberField;

    @Find(by = By.ID, using = "responsible")
    private WebElement responsibleField;

    @Find(by = By.BUTTON_TEXT, using = "${demo.newcases.savebutton}")
    private WebElement saveButton;

    @Find(by = By.BUTTON_TEXT, using = "${demo.newcases.cancelbutton}")
    private WebElement cancelButton;

    @Find(by = By.CLASS_NAME, using = "panel-title")
    private WebElement casesTitle;

    public WebElement getCasesTitle() {
        return casesTitle;
    }

    @Name("press_save_button")
    public void press_save_button() {
        doWith(saveButton).click();
    }

    public void press_cancel_button() {
        doWith(cancelButton).click();
    }

    public void set_name_to_$(String name) {
        doWith(nameField).setValue(name);
    }

    public void set_status_to_$(String status) {
        doWith(statusField).selectOption(status);
    }

    public void set_date_to_$(LocalDate date) {
        String dateFormat = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String[] splitDate = dateFormat.split("/");
        doWith(dateField).sendKeys(splitDate[0]);
        doWith(dateField).sendKeys(keys().TAB);
        doWith(dateField).sendKeys(splitDate[1]+splitDate[2]);
    }

    public void set_person_to_$(String person) {
        doWith(personField).setValue(person);
    }

    public void set_city_to_$(String city) {
        doWith(cityField).setValue(city);
    }

    public void set_zipCode_to_$(String zipCode) {
        doWith(zipCodeField).setValue(zipCode);
    }

    public void set_street_to_$(String street) {
        doWith(streetField).setValue(street);
    }

    public void set_number_to_$(String number) {
        doWith(numberField).setValue(number);
    }

    public void expect_case_name_is_$(String name) {
        expectations().expect(nameField).toHave().textOrValue(name);
    }

    public String get_name() {
        String nameData = get(nameField).text();
        return nameData;
    }

    public String get_responsible() {
        String responsibleData = get(responsibleField).value();
        return responsibleData;
    }

    public void expect_case_status_is_$(String status) {
        expectations().expect(statusField).toHave().textOrValue(status);
    }

    public void expect_case_status_is_new() {
        expectations().expect(statusField).toHave().textOrValue("Új");
    }

    public void expect_case_date_is_$(LocalDate date) {
        String text=get(dateField).value();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);
        if (!formattedDate.equals(text)) {
            throw new TestException("The date is not: " + formattedDate + ", the date is: " + text + ".");
        }
    }

    public void expect_case_person_is_$(String person) {
        expectations().expect(personField).toHave().textOrValue(person);
    }

    public void expect_case_city_is_$(String city) {
        expectations().expect(cityField).toHave().textOrValue(city);
    }

    public void expect_case_zipCode_is_$(String zipCode) {
        expectations().expect(zipCodeField).toHave().textOrValue(zipCode);
    }

    public void expect_case_street_is_$(String street) {
        expectations().expect(streetField).toHave().textOrValue(street);
    }

    public void expect_case_number_is_$(String number) {
        expectations().expect(numberField).toHave().textOrValue(number);
    }

    public void expect_case_responsible_is_$(String responsible) {
        expectations().expect(responsibleField).toHave().textOrValue(responsible);
    }

    public void assume_responsible_field_is_not_editable() {
        expectations().assume(responsibleField).toBe().readonly();
    }

}
