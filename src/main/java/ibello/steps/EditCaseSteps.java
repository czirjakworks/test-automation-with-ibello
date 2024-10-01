package ibello.steps;

import ibello.data.Case;
import ibello.pages.AbstractFormPage;
import ibello.pages.EditCasePage;

public class EditCaseSteps extends AbstractFormSteps {

    private EditCasePage editCasePage;

    public void edit_case_page_is_loaded() {
        editCasePage.page_must_be_loaded();
    }

    public void expect_case_data_is_visible(Case caseData) {
        //output().recordCustomAction(editCasePage.get_name());
        editCasePage.expect_case_id_is_$(caseData.getId());
        editCasePage.expect_case_name_is_$(caseData.getName());
        editCasePage.expect_case_status_is_$(caseData.getStatus());
        editCasePage.expect_case_date_is_$(caseData.getDate());
        editCasePage.expect_case_person_is_$(caseData.getPerson());
        editCasePage.expect_case_city_is_$(caseData.getCity());
        editCasePage.expect_case_zipCode_is_$(caseData.getZipCode());
        editCasePage.expect_case_street_is_$(caseData.getStreet());
        editCasePage.expect_case_number_is_$(caseData.getNumber());
        editCasePage.expect_case_responsible_is_$(caseData.getResponsible());
    }

    public void assume_$_case_id_is_visible(String caseId) {
        editCasePage.assume_case_id_is_$(caseId);
    }

    @Override
    public AbstractFormPage getFormPage() {
        return editCasePage;
    }
}
