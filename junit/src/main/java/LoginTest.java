import org.junit.Test;

import static org.testng.AssertJUnit.*;

public class LoginTest {
    login login = new login("Ch_19", "King123%");

    //Test successful login
    @Test public void testLoginSuccess() {
        boolean result = login.loginUser("Ch_19", "King123%");
        assertTrue(result);
    }
    @Test public void testLoginFail() {
        boolean result = login.loginUser("Ch_19", "King123%");
        assertFalse(result);
    }
    @Test public void testReturnLoginStatusSuccess() {
        boolean result = login.loginUser("Ch_19", "King123%");
       String message = login.returnLoginStatus(true );
        assertEquals("Welcome user, it is great to see you again",message);
    }
    // Test fail message
    @Test public void testReturnLoginFail() {
        boolean result = login.loginUser("Ch_19", "King123%");
        String s = login.returnLoginStatus(Boolean.parseBoolean("loginFail"), "Chilavert", "Mapah");
        String message = (login.returnLoginStatus(Boolean.parseBoolean("loginFail"), "Chilavert", "Mapah"));
        assertEquals("Username or password incorrect, please try again.", message);
    }

}
