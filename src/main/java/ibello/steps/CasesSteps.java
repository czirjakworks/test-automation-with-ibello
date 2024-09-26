package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.data.Case;
import ibello.pages.CasesPage;
import ibello.pages.CasesTable;

@Name("Cases Steps")
public class CasesSteps extends StepLibrary {

    private CasesPage casesPage;
    private CasesTable casesTable;

    public void open_cases_page() {
        casesPage.open_page();
        casesPage.page_must_be_loaded();
    }

    public void cases_page_is_loaded() {
        casesPage.page_must_be_loaded();
    }

    public void assume_case_exists(Case caseData) {
        casesTable.case_exists_with_$_name(caseData.getName());
    }

    public void expect_more_than_one_case_exists() {
        casesTable.expect_minimum_one_case_exists();
    }

    public void open_first_case() {
        casesTable.click_first_case_id();
    }

    public void expect_minimum_one_case_exists() {
        casesTable.expect_minimum_one_case_exists();
    }

    public void expect_exactly_$_case_exists(int count) {
        casesTable.expect_exactly_$_case_exists(count);
    }

    public void click_on_new_case_button() {
        casesPage.click_on_new_case_button();
    }

    public void first_case_has_id() {
        casesTable.expect_first_row_has_id();
    }

    public void first_case_has_data(Case caseData) {
        casesTable.expect_first_row_has_$_name(caseData.getName());
        casesTable.expect_first_row_has_$_person(caseData.getPerson());
        casesTable.expect_first_row_has_$_status(caseData.getStatus());
        casesTable.expect_first_row_has_$_date(caseData.getDate());
        casesTable.expect_first_row_has_$_responsible(caseData.getResponsible());
    }

}
