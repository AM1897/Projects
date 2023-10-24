import java.util.ArrayList;
import java.util.Random;

class WordList {        // Det här är vår nya klass med namnet WatdList
    private ArrayList<String> wordList; // Deklarerar en privat instansvariabel av typen ArrayList<String> med namnet wordList. Denna variabel kommer att användas för att lagra listan av ord.
    private String word; // här deklaretrar vi en privat instansvariabel av String med namnet word. den här variabeln kommer användas  för att lagra slumpmässiga valda ordet.

    public WordList() {     //Här hårdkodar vi orden och lagrar dem i vår ArrayList.
        wordList = new ArrayList<String>();     // Osäker men jag tror att man skapar en nu instans av ArrayList och tilldelar den till wordList.
        wordList.add("katt");

        wordList.add("dator");
        wordList.add("programmering");
        wordList.add("java");
        wordList.add("kod");
        wordList.add("algoritmer");
        wordList.add("databas");
        wordList.add("webb");
        wordList.add("webbsida");
        wordList.add("webbplats");
        wordList.add("webbserver");
        wordList.add("webbläsare");
        wordList.add("webbdesign");
        wordList.add("webbutveckling");
        wordList.add("Systemutveckling");
        wordList.add("Systemarkitektur");
        wordList.add("Systemdesign");
        wordList.add("Diagram");
        wordList.add("UML");
        wordList.add("Klassdiagram");
        wordList.add("UseCase");
        wordList.add("UseCaseDiagram");
    }

    public String randomWord() {        //Här väljer den en slumpmässig ord från listan och retunerar den.
        Random random = new Random();   // Här skapar vi en ny instans av random klassen för att kunna generera ett slumpmässig tal.
        word = wordList.get(random.nextInt(wordList.size())); //i denna rad genererar vi ett slumpmässigt tal mellan 0 och storleken på wordList och tilldelar det
        return word;
    }

    public void addWord(String word) { //en offentlig metod som lägger till ett ord i wordList.
        wordList.add(word);     // lägger till ordet i wordList.
    }

    public void removeWord(String word) { //en offentlig metod som tar bort ett ord från wordList.
        wordList.remove(word); // tar bort ordet som skickas in.
    }

    public String getword() { // metoden som retunerar ordet som det ordet som slumpmässigt valdes.
        return word;
    }
}