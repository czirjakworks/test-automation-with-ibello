package ibello.workflows;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.steps.CasesSteps;
import ibello.steps.LoginSteps;
import ibello.steps.UserSteps;

@Name("User")
public class UserWorkflow extends StepLibrary {

	private UserSteps userSteps;
	private CasesSteps casesSteps;
	private LoginSteps loginSteps;
	private String currentPassword;
	private String password;
	private static final String URL = "https://ibello.hu/tasks/cases/#/login";

	public void a_rendszerben_van_már_egy_létező_felhasználó() {
		output().recordCustomAction("There is a user in the application.");
	}

	public void a_felhasználó_ellenőrzi_az_adatokat() {
		output().recordCustomAction("Not used for automation testing.");
	}

	public void a_felhasználói_adatok_megjelennek() {
		userSteps.expect_user_data_is_visible();
	}

	public void a_felhasználói_név_és_a_teljes_név_nem_szerkeszthető() {
		userSteps.assume_userName_field_and_fullName_field_is_not_editable();
	}

	public void a_felhasználó_a_felhasználói_adatok_oldalon_van() {
		String username = getConfigurationValue("demo.app.username").toString();
		if (currentPassword == null) {
			currentPassword = getConfigurationValue("demo.app.password").toString();
		}
		loginSteps.login_with_$_user(username, currentPassword);
		casesSteps.open_user_data_page();
		userSteps.user_page_is_loaded();
	}

	public void a_felhasználó_helyesen_megadja_a_jelenlegi_jelszót() {
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
		//Loginra visszalépés. Új jelszó megadása. Bejelentkezés gomb. Ügyek oldal betöltődése.
		String username = getConfigurationValue("demo.app.username").toString();
		loginSteps.return_loading_page();
		loginSteps.enter_$_username(username);
		loginSteps.enter_$_password(currentPassword);
		//loginSteps.enter_$_password(password);
		loginSteps.attempt_to_login();
		loginSteps.cases_page_is_loaded();
		output().recordCustomAction("The password change was successful.");
	}

	public void a_felhasználó_hibásan_adja_meg_a_jelenlegi_jelszót() {
		userSteps.enter_$_currentPassword("blablabla");
	}

	public void a_felhasználó_a_régi_jelszóval_kapcsolatos_hibaüzenetet_kap() {
		userSteps.error_message_old_password_is_visible();
	}

	public void a_jelszó_módosítása_sikertelen_hibás_jelenlegi_jelszó_esetén() {
		//Loginra visszalépés. Jelenlegi (új) jelszó megadása. Bejelentkezés gomb. Elvárjuk, hogy ne nyíljon meg, hibaüzenetet kapjunk.
		String username = getConfigurationValue("demo.app.username").toString();
		currentPassword = password;
		loginSteps.login_failed_with_$_user(username, currentPassword);
		loginSteps.error_message_is_visible();
		output().recordCustomAction("The password change was unsuccessful.");
	}

	public void a_jelszó_módosítása_sikertelen_hibás_új_jelszó_esetén() {
		//Loginra visszalépés. Régi jelszó megadása. Bejelentkezés gomb. Elvárjuk, hogy megnyíljon.
		String username = getConfigurationValue("demo.app.username").toString();
		loginSteps.login_with_$_user(username, currentPassword);
		output().recordCustomAction("The password change was unsuccessful.");
	}

	public void a_felhasználó_egyszer_adja_meg_jól_az_új_jelszót() {
		userSteps.enter_$_password("Goodpassword1");
		userSteps.enter_$_password2("Wrongpassword2");
	}

	public void a_felhasználó_az_új_jelszóval_kapcsolatos_hibaüzenetet_kap() {
		userSteps.error_message_new_password_is_visible();
	}

}