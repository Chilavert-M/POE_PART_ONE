import org.example.Message;
import java.util.ArrayList;
import java.util.Scanner;
import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;

public class Main {

    static ArrayList<String> sentMessages = new ArrayList<>();
    static ArrayList<String> storedMessages = new ArrayList<>();
    static ArrayList<String> disregardedMessages = new ArrayList<>();

    static ArrayList<String> messageIDs = new ArrayList<>();
    static ArrayList<String> messageHashes = new ArrayList<>();
    static ArrayList<String> recipients = new ArrayList<>();

    public static int totalMessagesSent = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //REGISTRATION
        Registration registration = new Registration();
        registration.Register();

        //LOGIN
        login login = new login(registration.username, registration.password,
                registration.firstName, registration.lastName);

        if (!login.loginProcess()) {
            System.out.println("Too many failed attempts. Exiting...");
            input.close();
            return;
        }

        int choice;

        //A welcome message is displayed before entering the application
        System.out.println("======================");
        System.out.println("Welcome to QuickChat.");
        System.out.println("======================");

        System.out.println();

        int menuChoice = 0;

        while (menuChoice != 4) {

            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Show stored messages");
            System.out.println("4) Quit");
            System.out.print("Choose an option: ");
            menuChoice = Integer.parseInt(input.nextLine());

            if (menuChoice == 1) {

                //Ask the user to enter the amount of messages they would like to send
                System.out.print("How many messages do you want to send? ");
                int numMessages = Integer.parseInt(input.nextLine());

                //The for loop keeps track of the amount of messages
                for (int i = 1; i <= numMessages; i++) {

                    System.out.println("Message " + i + " " +" of " + " " + numMessages);

                    //Ask the user to enter a recipient number
                    System.out.print("Enter recipient number: ");
                    String recipient = input.nextLine();

                    if (recipient.startsWith("+27") || recipient.startsWith("0")) {
                        System.out.println("Recipient is the correct format. ");
                    } else {
                        System.out.println("Recipient is incorrectly formatted. Please make sure that recipient starts with either +27 or 0.");
                    }

                    Message tempMsg = new Message(recipient, "placeholder", i);
                    System.out.println(tempMsg.
                            checkRecipientCell());

                    //Ask the user to enter a message that has less than 250 characters
                    System.out.print("Enter message (max 250 chars): ");
                    String messageText = input.nextLine();

                    if (messageText.length() > 250) {
                        int excess = messageText.length() - 250;
                        System.out.println("Message exceeds 250 characters by " + excess + "; please reduce the size.");
                    } else {
                        System.out.println("Message ready to send.");

                        Message message = new Message(recipient, messageText, i);
                        System.out.println("Message ID generated: " + message.getMessageID());
                        System.out.println("Message Hash: " + message.getMessageHash());

                        System.out.println();

                        System.out.println("1) Send Message");
                        System.out.println("0) Disregard Message");
                        System.out.println("2) Store Message to send later");
                        System.out.print("Choose: ");
                        int sendChoice = Integer.parseInt(input.nextLine());

                        System.out.println(message.SentMessage(sendChoice));

                        if (sendChoice == 1) {

                            sentMessages.add(message.getMessageText());
                            recipients.add(message.getRecipient());
                            messageIDs.add((String) message.getMessageID());
                            messageHashes.add(message.getMessageHash());

                            message.totalMessagesSent++;

                            System.out.println("Message has been sent");

                        }
                        if (sendChoice == 0) {

                            disregardedMessages.add(messages.toString());
                            System.out.println("Message has been disregarded");

                        }
                        if (sendChoice == 2) {
                            storedMessages.add(message.getMessageText());

                            recipients.add(message.getRecipient());
                            messageIDs.add((String) message.getMessageID());
                            messageHashes.add(message.getMessageHash());

                            System.out.println("Message has been stored");

                        }
                    }
                }

                System.out.println("Total messages sent: " + sentMessages.size());
                System.out.println(new Message("", "", 0).printMessages());

            } else if (menuChoice == 2) {

                    System.out.println("\nRECENTLY SENT MESSAGES");

                    if(sentMessages.isEmpty())
                    {
                        System.out.println("No messages sent.");
                    }
                    else {
                        for (String msg : sentMessages) {
                            System.out.println(msg);
                        }
                    }

                System.out.println("Total Sent: " + totalMessagesSent);

            } else if (menuChoice == 3) {

                System.out.println("\n===== STORED MESSAGES =====");
                System.out.println("1. Longest Message");
                System.out.println("2. Search By Message ID");
                System.out.println("3. Search By Recipient");
                System.out.println("4. Delete By Hash");
                System.out.println("5. Full Report");

                int menuchoice = input.nextInt();
                input.nextLine();

                switch (menuchoice) {

                    case 1:

                        String longest = "";

                        for (String msg : Main.storedMessages) {

                            if (msg.length() > longest.length()) {
                                longest = msg;
                            }
                        }

                        System.out.println("Longest Message:");
                        System.out.println(longest);

                        break;

                    case 2:

                        System.out.print("Enter Message ID: ");
                        String id = input.nextLine();

                        for (int i = 0; i < Main.messageIDs.size(); i++) {

                            if (Main.messageIDs.get(i).equals(id)) {

                                System.out.println(
                                        Main.recipients.get(i) + " : " + Main.storedMessages.get(i)
                                );
                            }
                        }

                        break;

                    case 3:

                        System.out.print("Enter Recipient: ");
                        String number = input.nextLine();

                        for (int i = 0; i < Main.recipients.size(); i++) {

                            if (Main.recipients.get(i).equals(number)) {

                                System.out.println(Main.storedMessages.get(i));
                            }
                        }

                        break;

                    case 4:

                        System.out.print("Enter Hash: ");
                        String hash = input.nextLine();

                        for (int i = 0; i < Main.messageHashes.size(); i++) {

                            if (Main.messageHashes.get(i).equals(hash)) {

                                Main.storedMessages.remove(i);
                                Main.recipients.remove(i);
                                Main.messageIDs.remove(i);
                                Main.messageHashes.remove(i);

                                System.out.println("Message deleted.");
                                break;
                            }
                        }

                        break;

                    case 5:

                        System.out.println("\n===== REPORT =====");

                        for (int i = 0; i < Main.storedMessages.size(); i++) {

                            System.out.println("ID: " + Main.messageIDs.get(i));
                            System.out.println("Recipient: " + Main.recipients.get(i));
                            System.out.println("Hash: " + Main.messageHashes.get(i));
                            System.out.println("Message: " + Main.storedMessages.get(i));
                            System.out.println();
                        }

                }

            } else if (menuChoice == 4) {
                System.out.println(" Thank You for using QuickChat. GOODBYE!");
            }
        }
    }
}


