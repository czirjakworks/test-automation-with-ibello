package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.data.Case;
import ibello.pages.AbstractFormPage;
import ibello.pages.NewCasesPage;

@Name("New Case steps")
public class NewCaseSteps extends AbstractFormSteps {

    private NewCasesPage newCasesPage;

    public void open_new_case_page() {
        newCasesPage.open_page();
        newCasesPage.page_must_be_loaded();
    }

    public void new_case_page_is_loaded() {
        newCasesPage.page_must_be_loaded();
    }

    public void save_form() {
        newCasesPage.press_save_button();
    }

    public void cancel_form() {
        newCasesPage.press_cancel_button();
    }

    public void assume_case_status_is_new() {
        newCasesPage.expect_case_status_is_new();
    }

    public void assume_case_responsible_is_$(String responsible) {
        newCasesPage.expect_case_responsible_is_$(responsible);
    }


    @Override
    public AbstractFormPage getFormPage() {
        return newCasesPage;
    }
}
