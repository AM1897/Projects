import java.util.ArrayList;             //ArrayList paketet användes för att lagra namn i en lista.
import java.util.Scanner;              // Scanner paket används för att läsa inmatning från användaren.

public class Main {                     //
    public static void main(String[] args) {
        ArrayList<String> namnLista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;                 //Skapa en variabel för att lagra användarens val.

        //Skapar en loop som kör tills användaren väljer att avsluta
        do {
            //Skapar en meny av alternativ för användaren att välja.
            System.out.println("Choose one of the options:");
            System.out.println("1 - Create name:");
            System.out.println("2 - Delete name:");
            System.out.println("3 - Update name:");
            System.out.println("4 - List name:");
            System.out.println("5 - Finish name:");

            choice = scanner.nextInt();             //Läser in användarens val som finns i menyn.

            switch (choice) {                               //Switch som hanterar användarens val
                case 1 -> {                                 //Om användaren har valt alternativ 1.
                    System.out.println("Create a name:");   // då kommer att detta skrivas ut
                    String namn = scanner.next();           //läs in användarens inmatning och spara den som namnet
                    namnLista.add(namn);                    // här sparar vi namnet i listan
                    System.out.println("The name has been added to the list.");     //Här berättar vi att namnet finns med i listan.
                }
                case 2 -> {                                 //om användaren har valt alternativ 2.
                    System.out.println("Enter a name to delete:");  // nu ber den om att skriva namnet du vill ta bort
                    String namnRadera = scanner.next();     //läser in användarens inmatning och sparar det i en variabel som heter namnRadera
                    if (namnLista.contains(namnRadera)) {   //namnet som sparades för att ta bort finns nu, och sedan kontrollerar om den finns i namnLista också
                        namnLista.remove(namnRadera);         //om namnet finns i namnLista så kommer den att tas bort.
                        System.out.println("The name has been deleted from the list."); // här skriver den en bekräftelse om att den är bort tagen
                    } else {          //om den inte finns i namnListan då ska den skriva ut nedanför print.
                        System.out.println("The name is not in the list.");
                    }
                }
                case 3 -> {                             //om användaren har valt alternativ 3.
                    System.out.println("Enter the name to update:");    // den ber om att skriva namnet du vill uppdatera
                    String namnUppdatera = scanner.next();      //den tar emot inmatningen och sparar den i namnUppdatera
                    if (namnLista.contains(namnUppdatera)) {    //om namnet finns i namnlistan som vi fick från användaren, så kommer den om att be dig skriva in ett nytt namn.
                        System.out.println("choose a new name:"); // den här texten får du om du och matar in den nya namnet efter du har fått den.
                        String ersattningsNamn = scanner.next();    //läser in nya namnet och sparar den i ersattningssNamn.
                        namnLista.set(namnLista.indexOf(namnUppdatera), ersattningsNamn);   //här ersätter det nya namnet det gamla namnet i namnLista.
                        System.out.println("The name has been updated in the list."); // här skrives den ut att det gamla namnet har ersätts av det nya.
                    } else {        //om den inte finns i namnListan kommer den att skriva ut dessa
                        System.out.println("The name is not in the list."); //om den inte finns i namnListan kommer den att skriva ut dessa
                    }
                }
                case 4 -> {                                     //om man har valt alternativ 4.
                    if (namnLista.size() > 0) {                 //Kontrollerar om namnListan innehåller några namn. Om den är tom skriv ut den i println
                        System.out.println("Name in the list:");
                        for (String namnIListan : namnLista) {      // den lopper igenom hela listan och ber om att skriva ut alla som finns i namnListan
                            System.out.println(namnIListan);
                        }
                    } else {
                        System.out.println("The list is empty.");  // om det inte finns något så skriver du ut detta
                    }
                }
                case 5 ->
                        System.out.println("The program ends.");      //om användaren valt alternativ 5. Så kommer att programmet avslutar
                default -> System.out.println("Invalid selection. Please try again.");
            }
        } while (choice != 5);               //programmet kommer att fortsätta så länge choice är inte lika med 5. väljer alternativ 5 i menyn, kommer villkoret för loopen att vara falskt och loopen kommer att avslutas,
    }
}