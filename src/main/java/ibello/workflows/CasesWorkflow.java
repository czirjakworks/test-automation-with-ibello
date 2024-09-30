package ibello.workflows;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.data.Case;
import ibello.steps.CasesSteps;
import ibello.steps.EditCaseSteps;
import ibello.steps.NewCaseSteps;

@Name("Cases")
public class CasesWorkflow extends StepLibrary {

    private CasesSteps casesSteps;
    private NewCaseSteps newCaseSteps;
    private Case newCase;
    private EditCaseSteps editCaseSteps;
    private static final int CASE_COUNT=4;

    public void a_felhasználó_az_új_ügy_rögzítési_felületen_van() {
        newCaseSteps.open_new_case_page();
    }

    public void a_felhasználó_kitöltötte_az_összes_adatot() {
        newCase = testData().fromJson(Case.class).withId("tomorrow").load();
        newCaseSteps.fill_form(newCase);
    }

    public void a_felhasználó_a_holnapi_napot_adja_meg_érvényességi_időnek() {
        //The previous method covers it.
    }

    public void a_felhasználó_elmenti_az_új_ügyet() {
        newCaseSteps.save_form();
    }

    public void a_felhasználó_visszatér_az_ügyek_oldalra() {
        casesSteps.cases_page_is_loaded();
    }

    public void az_új_ügy_megjelenik_az_ügyek_táblázatban() {
        casesSteps.assume_case_exists(newCase);
    }

    public void a_felhasználó_az_ügyek_oldalon_van() {
        casesSteps.open_cases_page();
        casesSteps.cases_page_is_loaded();
    }

    public void a_rendszerben_van_már_egy_létező_ügy() {
        casesSteps.open_cases_page();
        casesSteps.expect_minimum_one_case_exists();
    }

    public void a_felhasználó_megnyitja_az_ügyet() {
        casesSteps.open_first_case();
    }

    public void az_ügy_szerkesztő_oldala_megnyílik() {
        editCaseSteps.edit_case_page_is_loaded();
    }

    public void az_ügy_adatai_megjelennek() {
        Case caseData = testData().fromJson(Case.class).withId("existing").load();
        editCaseSteps.expect_case_data_is_visible(caseData);
    }

    public void a_felhasználó_az_ügyek_oldalra_lép() {
        casesSteps.open_cases_page();
        casesSteps.cases_page_is_loaded();
    }

    public void az_ügyek_listájában_megjelenik_az_összes_ügy() {
        casesSteps.expect_exactly_$_case_exists(CASE_COUNT);
    }

    public void a_felhasználó_az_új_ügy_gombra_nyom() {
        casesSteps.click_on_new_case_button();
    }

    public void új_ügy_oldala_megnyílik() {
        newCaseSteps.new_case_page_is_loaded();
    }

    public void az_ügy_státusza_Új() {
        newCaseSteps.assume_case_status_is_new();
    }

    public void az_ügy_felelőse_a_felhasználó() {
        String responsible = testData().fromJson(Case.class).withId("responsible").load().getResponsible();
        newCaseSteps.assume_case_responsible_is_$(responsible);
    }

    public void a_felhasználó_a_Mégsem_gombra_nyom() {
        newCaseSteps.cancel_form();
    }

    public void az_új_ügy_automatikusan_kap_azonosítót() {
        casesSteps.first_case_has_id();
    }

    public void a_felhasználó_az_ügy_szerkesztése_oldalon_van() {
        casesSteps.open_cases_page();
        casesSteps.open_first_case();
        editCaseSteps.edit_case_page_is_loaded();
    }

    public void a_felhasználó_megváltoztatja_az_ügy_alapadatait() {
        newCase = testData().fromJson(Case.class).withId("modification").load();
        editCaseSteps.fill_form(newCase);
    }

    public void a_felhasználó_megváltoztatja_az_ügy_címét() {
        //The previous method covers it.
    }

    public void a_megváltozott_adatok_láthatóak_az_ügynél() {
        casesSteps.first_case_has_data(newCase);
    }

    public void az_eredeti_adatok_láthatóak_az_ügynél() {
        Case caseData = testData().fromJson(Case.class).withId("existingdefaultdata").load();
        casesSteps.first_case_has_data(caseData);
    }

    public void az_ügy_azonosítója_megjelenik() {
        Case caseData = testData().fromJson(Case.class).withId("existingdefaultdata").load();
        editCaseSteps.assume_$_case_id_is_visible(caseData.getId());
    }

    public void az_ügy_felelőse_megjelenik() {
        editCaseSteps.expect_responsible_field_is_not_empty();
    }

    public void az_azonosító_és_a_felelős_nem_módosíthatóak() {
        output().recordCustomAction("The id is in the title can't be modified.");
        editCaseSteps.assume_responsible_field_is_not_editable();
    }


}
