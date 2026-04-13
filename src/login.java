public class login {

    private static String enteredUsername = "";
    private static String enteredPassword = "";

    public login(String enteredUsername, String enteredPassword) {
        this.enteredUsername = enteredUsername;
        this.enteredPassword = enteredPassword;
    }

    //Checks if entered details match registration details
    public static boolean loginUser(String storedUsername, String storedPassword) {
        return enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword);
    }
    //Returns login status message
    public static String returnLoginStatus(boolean loginSuccess, String firstName, String lastName) {
        if (loginSuccess) {
            return "Welcome" + firstName + "," + lastName + "It is great to see you again";
        }else{
            return "UserName or password is incorrect, please try again";
        }
    }

    public String returnLoginStatus(boolean b) {
        return "b";
    }
}