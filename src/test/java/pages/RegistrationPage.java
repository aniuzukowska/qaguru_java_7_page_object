package pages;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import pages.components.Calendar;
import pages.components.RegistrationResultsModal;
import java.util.Objects;


public class RegistrationPage {
    private Calendar calendar = new Calendar();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        if (Objects.equals(value, "Male")) {
            $(".custom-control-label[for='gender-radio-1']").click();
        } else if (Objects.equals(value, "Female")) {
            $(".custom-control-label[for='gender-radio-2']").click();
        }
        else if (Objects.equals(value, "Other")) {
            $(".custom-control-label[for='gender-radio-3']").click();
        }
        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        $("#submit").click();
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }


}
