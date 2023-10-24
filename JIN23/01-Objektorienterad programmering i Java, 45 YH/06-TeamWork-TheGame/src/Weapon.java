import java.util.ArrayList;
import java.util.Scanner;

public class Weapon {
    ArrayList<String> name;
    ArrayList<Integer> damage;
    private int choice;

    public Weapon() {
        damage = new ArrayList<>();
        name = new ArrayList<>();
        addWeapon("Axe", 15);
        addWeapon("Bow", 20);
        addWeapon("Tomato", 25);
        addWeapon("Sword", 30);
    }


    public void addWeapon(String name, int damage) {
        this.name.add(name);
        this.damage.add(damage);
    }


    public int getDamage() {
        return damage.get(choice - 1);
    }


    public void displayWeapons() {//Print the list of weapons.
        System.out.println("Available weapons: ");
        for (int i = 0; i < name.size(); i++) {
            System.out.println(i + 1 + ". " + name.get(i) + " - " + damage.get(i) + " damage");
        }
    }


    public void choseWeapon() {

        System.out.println("Enter the number of the weapon you want to use!");
        Scanner scanner = new Scanner(System.in);
        if (GameLoop.checkIfInteger(scanner)) {
            choice = scanner.nextInt();
            if (choice > 0 && choice <= name.size()) {
                System.out.println("You chose " + name.get(choice - 1) + " for " + damage.get(choice - 1) + " damage.");
            } else {
                System.out.println("Invalid choice. Exiting...");
            }
        } else {
            System.out.println("invalid input. Exiting...");
        }
    }
}
