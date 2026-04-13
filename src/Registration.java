public class Registration {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;

    //Constructor
    public Registration(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    //Check userName
    public boolean checkUserName(String userName) {
        return userName.contains("_") && userName.length() <= 5;
    }

    //Check password complexity
    public boolean checkPasswordComplexity(String Password) {
        Boolean hasCapital = false;
        Boolean hasNumber = false;
        Boolean hasSpecial = false;

        for (int i = 0; i < Password.length(); i++) {
            char ch = Password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }

        }
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String cellPhoneNumber)
    {
        // A South African Number contains 9 digits and starts with a +27
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    //Register user
    public String registerUser() {
        if (!checkUserName("")) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length ";
        }
        if (!checkPasswordComplexity("")) {
            return " Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, and a special character. ";
        }
        if (!checkCellPhoneNumber("")) {
            return "Cell Phone number incorrectly formatted or does not contain international code.";
        }
        return "User has been registered successfully";
    }
    //Getters for login class
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public boolean checkUsername(String s) {
        return false;
    }
    public String checkRegisterUser() {
        return checkRegisterUser();
    }
    public String result() {
        return "result";

    }

}






