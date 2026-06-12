import java.util.Scanner;

public class login {
    String userName;
    String password;
    String firstName;
    String lastName;

    public login(String username, String firstName, String lastName, String name) {
    }

    public login(String ch19, String firstName) {
    }

    public void Login(String userName, String password, String firstName, String lastName){
        this.userName = userName;
        this.password= password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean loginProcess(){
       Scanner scanner = new Scanner(System.in);
       int attempts = 0;

        System.out.println("\n==============");
        System.out.println("LOGIN");

        while(attempts < 3){
            System.out.println("Please enter your username: ");
            String userName = scanner.nextLine();

            System.out.println("Please enter your password: ");
            String password = scanner.nextLine();

            if( userName.length() < 5){
                System.out.println("\n Welcome " + firstName + " " + lastName + ". It is great to see you again! ");
                return true;
            }else{
                attempts++;
                System.out.println("Username or Password is incorrect. Attempts left: " + (3-attempts));
            }
        }
        System.out.println("Login failed after 3 attempts.");
        return false;
    }

    public boolean loginUser(String ch19, String s) {
        return false;
    }

    public String returnLoginStatus(boolean b) {
        return "";
    }

    public String returnLoginStatus(boolean loginFail, String chilavert, String mapah) {
        return chilavert;
    }
}
