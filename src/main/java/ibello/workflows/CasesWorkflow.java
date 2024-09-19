package ibello.workflows;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.data.Case;
import ibello.steps.CasesSteps;
import ibello.steps.NewCaseSteps;

@Name("Cases")
public class CasesWorkflow extends StepLibrary {

    private CasesSteps casesSteps;
    private NewCaseSteps newCaseSteps;
    private Case newCase;

    public void a_felhasználó_az_új_ügy_rögzítési_felületen_van() {
        newCaseSteps.open_new_case_page();
    }

    public void a_felhasználó_kitöltötte_az_összes_adatot() {
        newCase = testData().fromJson(Case.class).withId("tomorrow").load();
        newCaseSteps.fill_form(newCase);
    }

    public void a_felhasználó_a_holnapi_napot_adja_meg_érvényességi_időnek() {
        // The previous method covers it.
    }

    public void a_felhasználó_elmenti_az_új_ügyet() {
        newCaseSteps.save_form();
    }

    public void a_felhasználó_visszatér_az_ügyek_oldalra() {
        casesSteps.cases_page_is_loaded();
    }

    public void az_új_ügy_megjelenik_az_ügyek_táblázatban() {
        casesSteps.expect_case_exists(newCase);
    }

    public void a_felhasználó_az_ügyek_oldalon_van() {
        // TODO auto-generated method
    }

    public void a_rendszerben_van_már_egy_létező_ügy() {
        // TODO auto-generated method
    }

    public void a_felhasználó_megnyitja_az_ügyet() {
        // TODO auto-generated method
    }

    public void az_ügy_oldala_megnyílik() {
        // TODO auto-generated method
    }

    public void az_ügy_adatai_megjelennek() {
        // TODO auto-generated method
    }

    public void a_felhasználó_az_ügyek_oldalra_lép() {
        // TODO auto-generated method
    }

    public void az_ügyek_listája_megjelenik_az_összes_ügy() {
        // TODO auto-generated method
    }

    public void a_felhasználó_az_új_ügy_gombra_nyom() {
        // TODO auto-generated method
    }

    public void új_ügy_oldala_megnyílik() {
        // TODO auto-generated method
    }

    public void az_ügy_státusza_Új() {
        // TODO auto-generated method
    }

    public void az_ügy_felelőse_a_felhasználó() {
        // TODO auto-generated method
    }

    public void a_felhasználó_a_Mégsem_gombra_nyom() {
        // TODO auto-generated method
    }

    public void az_új_ügy_automatikusan_kap_azonosítót() {
        // TODO auto-generated method
    }

    public void a_felhasználó_az_ügy_szerkesztése_oldalon_van() {
        // TODO auto-generated method
    }

    public void a_felhasználó_megváltoztatja_az_ügy_alapadatait() {
        // TODO auto-generated method
    }

    public void a_felhasználó_megváltoztatja_az_ügy_címét() {
        // TODO auto-generated method
    }

    public void a_megváltozott_adatok_láthatóak_az_ügynél() {
        // TODO auto-generated method
    }

}
