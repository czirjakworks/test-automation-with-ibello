package ibello.pages;

import hu.ibello.core.Name;

@Name("New Cases Page")
public class NewCasesPage extends AbstractFormPage {

    private static final String URL = "https://ibello.hu/tasks/cases/#/new-case";

    public void open_page(){
        browser().openURL(URL);
        browser().resize(1920, 1080);
        browser().maximize();
    }

    public void page_must_be_loaded() {
        String text=getConfigurationValue("demo.newcases.title").toString();
        expectations().expect(getCasesTitle()).toHave().textOrValue(text);
    }


}