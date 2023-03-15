package tests;
import org.junit.jupiter.api.Test;

public class DemoqaTest extends TestBase {
    @Test
    void fillFormTest() {
        String
                userFirstName = "Maria",
                userLastName = "Sklodowska",
                userEmail = "maria-sklodowska@gmail.com",
                userGender = "Female",
                userPhone = "1234567890",
                userBirthDay = "07",
                userBirthMonth = "February",
                userBirthYear = "2000",
                userSubject = "Physics",
                userHobby = "Music",
                userAddress = "France, Paris",
                userState = "Haryana",
                userCity = "Karnal";

        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .uploadFile("img/picture.jpg")
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResult("Subjects", userSubject)
                .verifyResult("Hobbies", userHobby)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);
    }
}
