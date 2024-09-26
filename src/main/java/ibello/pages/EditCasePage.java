package ibello.pages;

import hu.ibello.elements.WebElement;

import java.util.regex.Pattern;

public class EditCasePage extends AbstractFormPage {

    public void page_must_be_loaded() {
        String text=getConfigurationValue("demo.editcase.title").toString();
        expectations().expect(getCasesTitle()).toHave().textOrValue(Pattern.compile("^"+ text + "\\d{2,}"));
    }

    public void expect_case_id_is_$(String id) {
        expectations().expect(getCasesTitle()).toHave().textOrValue(Pattern.compile(".*"+ id + "$"));
    }

    public void assume_case_id_is_$(String id) {
        expectations().assume(getCasesTitle()).toHave().textOrValue(Pattern.compile(".*"+ id + "$"));
    }


}
