package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.pages.UserPage;

@Name("User Steps")
public class UserSteps extends StepLibrary {

    private UserPage userPage;

    public void open_user_page() {
        userPage.open_page();
        userPage.page_must_be_loaded();
    }

    public void user_page_is_loaded() {
        userPage.page_must_be_loaded();
    }

    public void enter_$_currentPassword(String currentPassword) {
        userPage.set_currentPassword_to_$(currentPassword);
    }

    public void enter_$_password(String password) {
        userPage.set_password_to_$(password);
    }

    public void enter_$_password2(String password2) {
        userPage.set_password2_to_$(password2);
    }

    public void attempt_to_passwordChange() {
        userPage.click_on_password_change_button();
    }

    public void error_message_old_password_is_visible() {
        userPage.error_message_should_be_displayed();
        String text=getConfigurationValue("demo.user.oldpwderrormsg").toString();
        userPage.$_error_message_should_be_displayed(text) ;
    }

    public void error_message_new_password_is_visible() {
        userPage.error_message_should_be_displayed();
        String text=getConfigurationValue("demo.user.newpwderrormsg").toString();
        userPage.$_error_message_should_be_displayed(text) ;
    }

    public void expect_user_data_is_visible() {
        String userName = getConfigurationValue("demo.app.username").toString();
        String fullName = getConfigurationValue("demo.app.fullname").toString();
        userPage.expect_userName_is_$(userName);
        userPage.expect_fullName_is_$(fullName);
    }

    public void assume_userName_field_and_fullName_field_is_not_editable() {
        userPage.assume_userName_field_is_not_editable();
        userPage.assume_fullName_field_is_not_editable();
    }

}
