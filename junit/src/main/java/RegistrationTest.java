import org.junit.Test;

import static org.testng.AssertJUnit.*;

public class RegistrationTest {
    Registration registration = new Registration("Chilavert", "Mapah","Ch12!","King19%","+27677804673");

    //Test valid username
    @Test
     public void testUsernameCorrectlyfomatted() {
        assertTrue(registration.checkUsername("Ch12!"));
    }

    //Test invalid username
    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(registration.checkUsername("Chila123"));
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

    //Test the entire Registration Success
    @Test
    public void testRegisterUserSuccess() {
        assertEquals("User has been registered successfully", registration.result());
    }

    // Test registration fail
    @Test
    public void testRegisterUserFailUsername() {
        assertEquals("Username is incorrectly formatted; please ensure that your username contains an underscore and is no longer than five characters in length", registration.result());
    }

}