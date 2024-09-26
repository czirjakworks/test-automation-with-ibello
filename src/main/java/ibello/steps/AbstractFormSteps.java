package ibello.steps;

import hu.ibello.core.TestException;
import hu.ibello.steps.StepLibrary;
import ibello.data.Case;
import ibello.pages.AbstractFormPage;
import ibello.pages.NewCasesPage;

public abstract class AbstractFormSteps extends StepLibrary {

    public abstract AbstractFormPage getFormPage();

    public void fill_form(Case caseData) {
        getFormPage().set_name_to_$(caseData.getName());
        getFormPage().set_date_to_$(caseData.getDate());
        getFormPage().set_person_to_$(caseData.getPerson());
        getFormPage().set_city_to_$(caseData.getCity());
        getFormPage().set_zipCode_to_$(caseData.getZipCode());
        getFormPage().set_street_to_$(caseData.getStreet());
        getFormPage().set_number_to_$(caseData.getNumber());
        if (caseData.getStatus() != null) {
            getFormPage().set_status_to_$(caseData.getStatus());
        }
    }

    public void expect_responsible_field_is_not_empty() {
        String text = getFormPage().get_responsible();
        if (text == null || text.isEmpty()) {
            throw new TestException("The responsible field is empty.");
        }
    }

    public void assume_responsible_field_is_not_editable() {
        getFormPage().assume_responsible_field_is_not_editable();
    }

}
