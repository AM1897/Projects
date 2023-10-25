import java.io.IOException;
import java.util.Scanner;

public class Menu {
    SQlite db = new SQlite(); // skapar en instans av SQlite-klassen för databasen åtkomst
    APIkey apIkey = new APIkey(); // Skapar en instans av APIkey-klassen för att hämta API-nyckeln och data från API

    public Menu() throws IOException {
        showMenu(); // Kör showMenu-metoden
    }

    public void showMenu() {
        Scanner scan = new Scanner(System.in); // Skapar en scanner för att läsa in användarens inmatning
        db.deleteAllMovies();   // Rensar databasen vid varje körning av programmet
        try {
            // Huvudmenyn som körs tills användaren väljer att avsluta programmet
            while (true) {
                System.out.println("------------------");
                System.out.println("Movie Searcher");
                System.out.println("1. Search movie by title");
                System.out.println("2. Search movie by year only in database!");
                System.out.println("3. Search movie by actor only in database!");
                System.out.println("4. Search movie by director only in database!");
                System.out.println("5. Exit");
                System.out.println("------------------");
                System.out.println("Enter your choice: ");
                int choice = scan.nextInt();    //läser in användarens val

                // Switch-sats som kör olika metoder beroende på användarens val
                while (true) {

                    if (choice == 1) {
                        // Läser in en titel från användaren och kollar om den finns i databasen
                        Scanner scan2 = new Scanner(System.in);
                        System.out.println("Enter a title: ");
                        String word = scan2.next();
                        // Om titeln inte finns i databasen så hämtas den från API:et och läggs till i databasen
                        if (!db.findMovieInDatabaseByTitle(word)) {
                            System.out.println("Movie not found in database.. Connecting to API..");
                            Movie movie = apIkey.getDataByTitle(apIkey.getKey(), word.toLowerCase());
                            System.out.println("Movie Details");
                            System.out.println("-------------");
                            movie.printMovie();
                            db.addMovieToDatabase(movie);
                            break;
                        }
                    }
                    if (choice == 2) {
                        // söker efter en film i databasen med hjälp av årtalet
                        System.out.println("Enter a year: ");
                        Scanner scan3 = new Scanner(System.in);
                        String word2 = scan3.next();
                        db.findMovieInDatabaseByYear(word2);
                        break;
                    }
                    if (choice == 3) {
                        // söker efter en film i databasen med hjälp av skådespelaren
                        System.out.println("Enter an actor: ");
                        Scanner scan4 = new Scanner(System.in);
                        String word3 = scan4.next();
                        db.findMovieInDatabaseByActor(word3);
                        break;
                    }
                    if (choice == 4) {
                        // söker efter en film i databasen med hjälp av regissören
                        System.out.println("Enter a director: ");
                        Scanner scan5 = new Scanner(System.in);
                        String word4 = scan5.next();
                        db.findMovieInDatabaseByDirector(word4);
                        break;
                    }
                    if (choice == 5) {
                        // Avslutar programmet
                        System.out.println("Exiting..");
                        System.exit(0);
                    } else {
                        // om användaren inte ger ett giltigt val så körs loopen om
                        System.out.println("Invalid choice, try again");
                        break;
                    }
                }
            }
        } catch (Exception e) { // Om användaren matar in något annat än en siffra så fångas felet och programmet avslutas
            System.out.println("Wrong input... Exiting..");
        }
    }
}
