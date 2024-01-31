package SAGroup.client.menu;

import java.util.Scanner;

public class UserMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            System.out.println("\nAnvändarmeny:");
            System.out.println("1. Visa min info");
            System.out.println("2. Ändra mitt lösenord");
            System.out.println("3. Ta bort mitt konto");
            System.out.println("4. Hantera min kundvagn");
            System.out.println("5. Logga ut och återgå till huvudmenyn");
            System.out.print("Val: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    // Visa användarinfo
                    break;
                case 2:
                    // Ändra lösenord
                    break;
                case 3:
                    // Ta bort konto
                    break;
                case 4:
                    // Hantera kundvagn
                    break;
                case 5:
                    // Logga ut och återgå till huvudmenyn
                    return;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }
}


























































/*
import java.util.Scanner;

public class UserMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            System.out.println("\nAnvändarmeny:");
            System.out.println("1. Visa min info");
            System.out.println("2. Ändra mitt lösenord");
            System.out.println("3. Ta bort mitt konto");
            System.out.println("4. Hantera min kundvagn");
            System.out.println("5. Logga ut och återgå till huvudmenyn");
            System.out.print("Val: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    // Visa användarinfo
                    break;
                case 2:
                    // Ändra lösenord
                    break;
                case 3:
                    // Ta bort konto
                    break;
                case 4:
                    // Hantera kundvagn
                    break;
                case 5:
                    // Logga ut och återgå till huvudmenyn
                    return;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }
}
*/