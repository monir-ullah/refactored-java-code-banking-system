import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = Login.getInstance();
        UserInfo userInfo = null;  // Declare userInfo outside the loop

        while (true) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    registerUser(login, scanner);
                    break;
                case 2:
                    userInfo = loginAndShowMenu(login, scanner);  // Assign userInfo here
                    break;
                case 3:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void printMenu() {
        System.out.print("Press 1 to Register\nPress 2 to Login\nPress 3 to Exit\nEnter your choice: ");
    }

    private static int getUserChoice(Scanner scanner) {
        return scanner.nextInt();
    }

    private static void registerUser(Login login, Scanner scanner) {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        login.register(name, username, password);
    }

    private static UserInfo loginAndShowMenu(Login login, Scanner scanner) {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // return the function from here
        return login.login(username, password);  // Return userInfo here
    }

    private static void exitProgram() {
        System.out.println("Exiting the program. Goodbye!");
        System.exit(0);
    }
}
