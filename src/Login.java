// Refactored Login.java code
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private static Login instance;

    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    private Login() {}

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

    public void register(String name, String username, String password) {
        names.add(name);
        usernames.add(username);
        passwords.add(password);
        System.out.println("Registration Successful");
        System.out.println("Press any key and enter");
        scanner.next();
    }

    public UserInfo login(String inputUsername, String inputPassword) {
        int index = usernames.indexOf(inputUsername);
        if (index != -1 && passwords.get(index).equals(inputPassword)) {
            return new UserInfo(names.get(index), scanner);
        } else {
            return null; // Login failed
        }
    }
}
