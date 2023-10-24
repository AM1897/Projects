import java.util.ArrayList;

class Word {

    private String word;    //lägra det rätta ordet
    private String guess;   //lagra gissningen.

    public Word(String word) {  //Som tar in det rätta ordet som en parameter.
        this.word = word;       //tilldelar värdet av det rätta ordet till instansvariabel word.
        this.guess = "";        //Sätter den aktuella gissningen till en tom String.
        for (int i = 0; i < word.length(); i++) { //Loppar genom varje bokstav i ordet.
            guess += "-"; // lägger till en sträck i gissningen för varje bokstav i ordet.
        }
    }

    public String getWord() {
        return word; //retunerar det rätta ordet.
    }

    public String getGuess() {
        return guess; //retunerar den aktulla gisningen.
    }

    public boolean matchGuess(char letter) { //tar in en bokstav som parameter och returnerar true om bokstaven finns i det rätta ordet, annars false.
        return word.contains(Character.toString(letter)); //retunerar true om bokstaven finns i ordet.
    }

    public String displayLetter(ArrayList<Character> guessedLetters) { //displayLetter() som tar in en lista med gissade bokstäver som parameter. Metoden uppdaterar den aktuella gissningen med de bokstäver som redan har gissats på
        String newGuess = ""; //skapar en ny tom Sring.
        for (int i = 0; i < word.length(); i++) { //Loppar genom varje bokstav i ordet.
            char letter = word.charAt(i);   //hämtar bokstaven på plats i ordet.
            if (guessedLetters.contains(letter)) { //om bokstaven finns i listan med gissade bokstäver.
                newGuess += letter; //lägger till bokstaven i den nya gissningen.
            } else {    //annars lägger till en sträck
                newGuess += "_";
            }
        }
        guess = newGuess;
        return guess;
    }


    public boolean hasWon() {
        return guess.equals(word);
    }
}