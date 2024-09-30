package ibello.workflows;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.steps.CasesSteps;
import ibello.steps.UserSteps;

@Name("Users")
public class UserWorkflow extends StepLibrary {

    private UserSteps userSteps;
    private CasesSteps casesSteps;
    private String currentPassword;
    private String password;


    public void a_rendszerben_van_már_egy_létező_felhasználó() {
        output().recordCustomAction("There is a user in the application.");
    }

    public void a_felhasználó_megnyitja_a_felhasználó_adatai_képernyőt() {
        casesSteps.open_user_data_page();
    }

    public void a_felhasználói_adatok_képernyő_megnyílik() {
        userSteps.user_page_is_loaded();
    }

    public void a_felhasználói_adatok_megjelennek() {
        userSteps.expect_user_data_is_visible();
    }

    public void a_felhasználói_név_és_a_teljes_név_nem_szerkeszthető() {
        userSteps.assume_userName_field_and_fullName_field_is_not_editable();
    }

    public void a_felhasználó_a_felhasználói_adatok_oldalon_van() {
        casesSteps.open_cases_page();
        casesSteps.open_user_data_page();
        userSteps.user_page_is_loaded();
    }

    public void a_felhasználó_helyesen_megadja_a_jelenlegi_jelszót() {
        currentPassword = getConfigurationValue("demo.app.password").toString();
        userSteps.enter_$_currentPassword(currentPassword);
    }

    public void a_felhasználó_megadja_az_új_jelszót_kétszer() {
        password = "Kk123456";
        userSteps.enter_$_password(password);
        userSteps.enter_$_password2(password);
    }

    public void a_felhasználó_a_jelszó_változtatás_gombra_nyom() {
        userSteps.attempt_to_passwordChange();
    }

    public void a_jelszó_módosítása_sikeres() {
        currentPassword = password;
        output().recordCustomAction("The password change was successful.");
    }

    public void a_felhasználó_hibásan_adja_meg_a_jelenlegi_jelszót() {
        userSteps.enter_$_currentPassword("blablabla");
    }

    public void a_felhasználó_a_régi_jelszóval_kapcsolatos_hibaüzenetet_kap() {
        userSteps.error_message_old_password_is_visible();
    }

    public void a_jelszó_módosítása_sikertelen() {
        output().recordCustomAction("The password change was unsuccessful.");
    }

    public void a_felhasználó_egyszer_adja_meg_jól_az_új_jelszót() {
        userSteps.enter_$_password("goodpassword");
        userSteps.enter_$_password2("wrongpassword");
    }

    public void a_felhasználó_az_új_jelszóval_kapcsolatos_hibaüzenetet_kap() {
        userSteps.error_message_new_password_is_visible();
    }

}
