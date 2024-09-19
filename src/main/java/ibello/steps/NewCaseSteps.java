package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.data.Case;
import ibello.pages.NewCasesPage;

@Name("New Case steps")
public class NewCaseSteps extends StepLibrary {

    private NewCasesPage newCasesPage;

    public void open_new_case_page() {
        newCasesPage.open_page();
        newCasesPage.page_must_be_loaded();
    }

    public void new_case_page_is_loaded() {
        newCasesPage.page_must_be_loaded();
    }

    public void fill_form(Case caseData) {
        newCasesPage.set_name_to_$(caseData.getName());
        newCasesPage.set_date_to_$(caseData.getDate());
        newCasesPage.set_person_to_$(caseData.getPerson());
        newCasesPage.set_city_to_$(caseData.getCity());
        newCasesPage.set_zipCode_to_$(caseData.getZipCode());
        newCasesPage.set_street_to_$(caseData.getStreet());
        newCasesPage.set_number_to_$(caseData.getNumber());
    }

    public void save_form() {
        newCasesPage.press_save_button();
    }





}
