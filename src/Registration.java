import java.util.Scanner;

public class Registration {
    Scanner scanner = new Scanner(System.in);


    String firstName;
    String lastName;
    String username;
    String password;
    String cellphoneNumber;



    //Check userName
    public boolean checkUserName(String userName) { return userName.contains("_") && userName.length() <= 5;}

    //Check password complexity
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8 ) {
            return false;
        }
        Boolean hasUppercase = false;
        Boolean hasSpecial = false;
        Boolean hasDigit = false;

        String specialCharacters = "`~!@#$%^&*{}[]:;<>.,?/";

        for(char ch : password.toCharArray()){
            if(Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if(!Character.isLetterOrDigit(ch)) {
                hasSpecial =true;
            } else if(Character.isDigit(ch)) {
                hasDigit = true;
            }

        }
        return hasUppercase && hasSpecial && hasDigit;
    }

    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        // A South African Number contains 9 digits and starts with a +27
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    //Register user
    public void Register() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n======================");
        System.out.println("Registration");

        System.out.println("Please enter your first name:");
        firstName = scanner.nextLine();

        System.out.println("Please enter your  last name: ");
        lastName = scanner.nextLine();

        while (true) {

            System.out.println("Please enter your username( it must contain '_' and be < 5 charcters): ");
            username = scanner.nextLine();

            if (checkUserName(username)) {
                System.out.println("Username successully captured");
                break;
            } else {
                System.out.println("Username must contain '_' and must be 5 cahrcters or less.");
            }
        }

        while (true) {
            System.out.println("Enter your password (password must be > 8 chars, uppercase, digit, special): ");
            password = scanner.nextLine();

            if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured");
                break;
            } else {
                System.out.println("Password must be at least 8 characters long, contain an uppercase, digit, and special character");
            }
        }

        while (true) {
            System.out.println("Enter your Phone Number (+27 or 0 followed by 9 digits): ");
            cellphoneNumber = scanner.nextLine();

            if (checkCellPhoneNumber(cellphoneNumber)) {
                System.out.println("Phone number successfully captured");
                break;
            } else {
                System.out.println("Phone number must contain '+27' or start with 0");
            }
        }

        System.out.println("\nRegistration Complete!\n");
    }

}




