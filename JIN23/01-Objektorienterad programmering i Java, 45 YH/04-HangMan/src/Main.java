public class Main {             // Detta definerar offentlig klass med namnet Main.
    public static void main(String[] args) {        // Detta definierar en offentlig och statisk metod med namnet "main". Detta är där programmet börjar att köra.
        System.out.println("Hello HangMan");
        Game game = new Game(new WordList()); //Skapar ett  nytt objekt av Game med Wordlist som parameter och till delar variabeln gamr.
        game.start(); // här anropar metoden start på objektet game.
    }
}