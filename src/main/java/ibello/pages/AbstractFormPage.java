package ibello.pages;

import hu.ibello.core.Name;
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

    @Find(by = By.ID, using = "validity")
    private WebElement validityField;

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

    @Find(by = By.BUTTON_TEXT, using = "Mentés")
    private WebElement saveButton;

    @Find(by = By.BUTTON_TEXT, using = "Mégsem")
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

    public void set_name_to_$(String name) {
        doWith(nameField).setValue(name);
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

}
