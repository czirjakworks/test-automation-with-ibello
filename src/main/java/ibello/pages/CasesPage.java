package ibello.pages;
import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;


@Name("Cases page")
public class CasesPage extends PageObject {

    private static final String URL = "https://ibello.hu/tasks/cases/#/cases";

    @Find(by = By.CLASS_NAME, using = "panel-title")
    private WebElement casesTitle;

    @Find(by = By.CLASS_NAME, using = "table table-hover")
    private WebElement casesTable;

    @Find(by = By.BUTTON_TEXT, using = "${demo.cases.newcasebutton}")
    private WebElement newCaseButton;

    //@Find(by = By.CSS_SELECTOR, using = "ul.nav.navbar-nav.navbar-right li a[href='#/user']")
    @Find(by = By.CSS_SELECTOR, using = "#navigation-navbar-collapse-1 > ul:nth-child(2) > li > a")
    private WebElement userDataLink;

    public void open_page(){
        browser().openURL(URL);
        browser().resize(1920, 1080);
        browser().maximize();
    }

    public void page_must_be_loaded() {
        String text=getConfigurationValue("demo.cases.title").toString();
        expectations().expect(casesTitle).toHave().textOrValue(text);
    }

    public void click_on_new_case_button() {
        doWith(newCaseButton).click();
    }

    public void open_user_data() {
        doWith(userDataLink).click();
    }

}
