import java.util.ArrayList;
import java.util.Scanner;

public class Game {     //Definierar en offentlig klass med namnet Game. 
    private WordList wordList;
    private Word word; // deklarerar en privat instansvariabel av typen wordList med namnet wordList. variabeln kommer att användas frö att lagra listan av ord
    private Player player; // den hät kommer att göra samma jobb men med spelarens namn player. variabeln kommer att lagra spelarens namn.
    private Scanner input; // läser in data från användaren.
    private ArrayList<Character> guessedLetters; //den kommer att användas för att lagra de bokstäver som spelaren har gissat på.

    public Game(WordList wordList) { //konstruktor för klassen Game med en parameter WordList.
        this.wordList = wordList;
        input = new Scanner(System.in);
    }

    public void start() { // här startar spelet.
        System.out.println("Welcome to the hang man game!");

        System.out.println("What's your name?");
        String name = input.nextLine();
        player = new Player(name);

        boolean keepPlaying = true; // vi deklarerar en boolean variabel: keepPlaying och sätter den till true.

        while (keepPlaying) { // en loop som fortsätter så länge keepPlaing är true.
            guessedLetters = new ArrayList<Character>(); // Detta återställer listan med bokstäver som spelaren har gissat på inför varje nytt spel.
            System.out.println();
            System.out.println("OK " + player.getName() + ""); // skriver ut spelarens namn.
            this.word = new Word(wordList.randomWord()); // Skapar ett nytt Word med ett slumpmässigt valt ord från WordList och tilldelar det till instansvariabeln word.
            System.out.println("You have to guess a word that consists of " + word.getWord().length() + " letters."); //Skriver ut hur många bokstäver ordet innehåller.
            System.out.println("Good luck");
            boolean winner = false; //används för att kontrollera om spelaren har vunnit spelet.
            while (!winner) { // en loop som fortsätter så länge winner är false. loppen fortsätter tills spelaren har gissat rätt på alla bokstäver i ordet.
                guess();    // anropar mteoden guess.
                word.displayLetter(guessedLetters); // anropar metoden displayLetter i Word klassen för att visa de bokstäver som spelaren har gissat på i ordet.
                System.out.println(word.getGuess()); //skriver ut aktuella gissningari konsullen

                winner = winnerCheck(); //kontrollerar om spelaren har gissat rätt i ordet.
                if (winner) {   //om spelaren har vunnit spelet.
                    System.out.println("Congratulations! You guessed the word correctly.");
                    System.out.println("The word was " + word.getWord()); // skriver ut ordet som spelaren har gissat på.
                }
            }
            System.out.println("Do you want to play again? (Yes/No)");
            String answer = input.next();

            if (answer.equalsIgnoreCase("Yes")) {   //kontrollerar om svaret är Yes.
                winner = false; //återställer winner till false så att spelaren kan spela igen.
            } else {        //om svaret är No.
                keepPlaying = false; //sätter variabeln keepPlaying till false så att loppen inte fortsätter.
                finishGame(); // då anropar vi metoden finishGame.
            }
        }
    }

    private void guess() {
        System.out.println();
        System.out.println(player);     //Skriver ut spelarens namn och antal gissningar.
        System.out.println(word.getGuess()); //skriver ut aktuella gissningar.
        System.out.println("Guess a letter:"); // ber spelaren att gissa en bokstav.

        String guess = input.next(); //läser in gissningen från spelaren.
        char letter = guess.charAt(0); // tar in första bokstaven från användaren och tilldelar den till variabeln letter.
        player.increaseGuesses(); // ökar antalet gissningar för spelaren med ett.

        if (guessedLetters.contains(letter)) { //kontrollerar om spelaren har redan gissat på bokstaven.
            System.out.println("You have already guessed the letter " + letter + "! Try to be a little more creative.");
        } else {    //om spelaren inte har gissat på bokstaven.
            guessedLetters.add(letter); //lägger till bokstaven i listan.
            if (!word.matchGuess(letter)) { //matchar bokstaven med bokstäverna i ordet.
                System.out.println("Sorry, the letter " + letter + " is not in the word.");
            } else {
                System.out.println("Good guess! The letter " + letter + " is in the word.");
            }
        }
    }

    private boolean winnerCheck() {
        return word.getWord().equals(word.getGuess()); //retunerar tru om den gissningen är lika med den´t ordet annars false.
    }

    private void finishGame() {
        System.out.println("Thanks for playing!");
        System.exit(0); //avslutar spelet.
    }
}