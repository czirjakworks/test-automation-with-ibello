package ibello.workflows;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.steps.UserSteps;

@Name("User")
public class UserWorkflow extends StepLibrary {

    private UserSteps userSteps;

    public void a_rendszerben_van_már_egy_létező_felhasználó() {
        output().recordCustomAction("There is a user in the application.");
    }

    public void a_felhasználó_megnyitja_a_felhasználó_adatai_képernyőt() {
        userSteps.open_user_page();
    }

    public void a_felhasználói_adatok_képernyő_megnyílik() {
        userSteps.user_page_is_loaded();
    }

    public void a_felhasználói_adatok_megjelennek() {
        // TODO auto-generated method
    }

    public void a_felhasználói_név_és_a_teljes_név_nem_szerkeszthető() {
        // TODO auto-generated method
    }

    public void a_felhasználó_a_felhasználói_adatok_oldalon_van() {
        userSteps.open_user_page();
        userSteps.user_page_is_loaded();
    }

    public void a_felhasználó_helyesen_megadja_a_jelenlegi_jelszót() {
        String password = getConfigurationValue("demo.app.password").toString();
        userSteps.enter_$_currentPassword(password);
    }

    public void a_felhasználó_megadja_az_új_jelszót_kétszer() {

    }

    public void a_felhasználó_a_jelszó_változtatás_gombra_nyom() {
        // TODO auto-generated method
    }

    public void a_jelszó_módosítása_sikeres() {
        // TODO auto-generated method
    }

    public void a_felhasználó_hibásan_adja_meg_a_jelenlegi_jelszót() {
        // TODO auto-generated method
    }

    public void a_felhasználó_a_régi_jelszóval_kapcsolatos_hibaüzenetet_kap() {
        // TODO auto-generated method
    }

    public void a_jelszó_módosítása_sikertelen() {
        // TODO auto-generated method
    }

    public void a_felhasználó_egyszer_adja_meg_jól_az_új_jelszót() {
        // TODO auto-generated method
    }

    public void a_felhasználó_az_új_jelszóval_kapcsolatos_hibaüzenetet_kap() {
        // TODO auto-generated method
    }

}
