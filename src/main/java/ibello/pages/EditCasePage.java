package ibello.pages;

import java.util.regex.Pattern;

public class EditCasePage extends AbstractFormPage {

    public void page_must_be_loaded() {
        String text=getConfigurationValue("demo.editcase.title").toString();
        expectations().expect(getCasesTitle()).toHave().textOrValue(Pattern.compile("^"+ text + "\\d{2,}"));
    }

}
