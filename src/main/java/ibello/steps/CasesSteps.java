package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.data.Case;
import ibello.pages.CasesPage;

@Name("Cases Steps")
public class CasesSteps extends StepLibrary {

    private CasesPage casesPage;

    public void open_cases_page() {
        casesPage.open_page();
        casesPage.page_must_be_loaded();
    }

    public void cases_page_is_loaded() {
        casesPage.page_must_be_loaded();
    }

    public void expect_case_exists(Case caseData) {
        casesPage.case_exists_with_$_name(caseData.getName());
    }

    public void expect_more_than_one_case_exists() {
        casesPage.expect_table_has_more_than_one_rows();
    }



}
