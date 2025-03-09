import java.util.Scanner;

public class UserInterface {
    private PasswordManager passwordManager = new PasswordManager();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\nPASSWORD MANAGER");
            System.out.println("1. Add Credential");
            System.out.println("2. Get Credential");
            System.out.println("3. List All Credentials");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addCredential();
                case 2 -> getCredential();
                case 3 -> passwordManager.listCredentials();
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addCredential() {
        System.out.print("Enter site name: ");
        String site = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        passwordManager.addCredential(site, password);
    }

    private void getCredential() {
        System.out.print("Enter site name: ");
        String site = scanner.nextLine();
        System.out.println("Password: " + passwordManager.getCredential(site));
    }
}
