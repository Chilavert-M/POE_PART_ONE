import org.junit.Test;

import static org.testng.AssertJUnit.*;

public class RegistrationTest {
    Registration registration = new Registration();

    //Test valid username
    @Test
    public void testUsernameCorrectlyfomatted() {
        assertTrue(registration.checkUserName("Ch12!"));
    }

    //Test invalid username
    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(registration.checkUserName("Chila123"));
    }

    //Test valid Password
    @Test
    public void testPasswordComplexity() {
        assertTrue(registration.checkPasswordComplexity("King129%"));
    }

    //Test invalid Password
    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertFalse(registration.checkPasswordComplexity("car1234"));
    }

    //Test valid CellPhoneNumber
    @Test
    public void testCellPhoneNumberCorrectFormat() {
        assertTrue(registration.checkCellPhoneNumber("+27677804673"));
    }

    //Test invalid CellPhoneNumber
    @Test
    public void testCellPhoneNumberIncorrectFormat() {
        assertFalse(registration.checkCellPhoneNumber("06778046734"));
    }
}