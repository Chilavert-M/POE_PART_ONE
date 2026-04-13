
import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        //Declarations
        String firstName;
        String lastName;
        String username;
        String password;
        String cellPhoneNumber;

        //Registration
        System.out.print(" Please enter your first name: ");
        firstName = scanner.nextLine();

        System.out.print(" Please enter your last name: ");
        lastName = scanner.nextLine();

        System.out.print(" Please enter username: ");
        username = scanner.nextLine();

        System.out.print(" Please enter your password: ");
        password = scanner.nextLine();

        System.out.print(" Please enter your cell phone number: ");
        cellPhoneNumber = scanner.nextLine();

        Registration reg = new Registration(firstName, lastName, username, password, cellPhoneNumber);

        String registrationMessage = reg.registerUser();
        System.out.println(registrationMessage);

        // The system will only continue if registration is successful
        String loginMessage = null;
        if (registrationMessage.equals("User has been registered successfully")) {

            System.out.print("Please enter username to login: ");
            String Username = scanner.nextLine();

            System.out.println("Please enter password to login: ");
            String loginPassword = scanner.nextLine();

            boolean loginSuccess = login.loginUser(reg.getUsername(), reg.getPassword());
            loginMessage = login.returnLoginStatus(loginSuccess, reg.getFirstName(), reg.getLastName());
        }
        System.out.println(loginMessage);
    }

}