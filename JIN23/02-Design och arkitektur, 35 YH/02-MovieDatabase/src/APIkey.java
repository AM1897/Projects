import org.json.JSONObject; // Importera json biblioteket. Paketet JSONObject används för att hantera JSON-data som tas emot från API-anropet.
import java.io.*;           // Importera java io biblioteket. Paketet som används för att hantera fil- och strömoperationer, såsom att läsa från och skriva till filer.
import java.net.HttpURLConnection; // Importera java net biblioteket. Paketet som används för att skapa och hantera HTTP-anslutningar för att skicka och ta emot data över nätverk.
import java.net.URL;                // Importera java net biblioteket. Paketet som används för att hantera och manipulera URL:er (Uniform Resource Locators), vilket representerar en webbadress
import java.util.Properties;    // Importera java util biblioteket. Paketet Properties används för att hantera en samling nyckel-värde-par, vilket är användbart för att läsa och skriva konfigurationsdata, såsom API-nyckeln i detta fall.
import java.util.Scanner;

public class APIkey {
    private String key;

    public APIkey() throws IOException { //create api key constructor
        getAPIKey();
    }

    public String getKey() {
        return key;
    }

    private void getAPIKey() { //läser in api key från en fil som sparar den i instansvariabeln key
        String userHome = System.getProperty("user.home"); //hämtar användarens hemkatalog

        Properties props = new Properties(); //Skapar ett properties-objekt. Properties är en samling nyckel-värde-par som används för att läsa och skriva konfigurationsdata, såsom API-nyckeln i detta fall.
        try { //försöker läsa in API-nyckeln från filen
            FileInputStream input = new FileInputStream(userHome + "/Documents/APIKeys/OMDB.txt"); //skapar en filinputstream som läser från filen
            props.load(input); //läser in filen
            this.key = props.getProperty("apiKey"); //sparar inläst nyckel i instansvariabeln key
        } catch (Exception e) { //om filen inte hittades eller om något annat fel uppstod
            System.out.println(e.getMessage()); //skriv ut felmeddelandet
            getAPIFromUser(); //fråga användaren om deras API-nyckel
        }
    }


    private void getAPIFromUser() {  //frågar användaren om deras API-nyckel och sparar den i en fil
        try { //försöker läsa in API-nyckeln från användaren
            System.out.println("Do you have an API key? (y/n)");  //fråga användaren om hen har en API-nyckel
            Scanner scanner1 = new Scanner(System.in);
            if (scanner1.nextLine().equalsIgnoreCase("y")) { //Om användaren svarar ja, läs in användarens svar
                System.out.println("Enter your API key: ");
                this.key = scanner1.nextLine(); //sparar inläst nyckel i instansvariabeln key
                createNewFileForAPI(key); //skapar en ny fil för att spara API-nyckeln
            } else {
                System.out.println("You can get an API key from http://www.omdbapi.com/");
                System.out.println("Enter your API key: ");
                this.key = scanner1.nextLine(); //sparar inläst nyckel i instansvariabeln key
            }
        } catch (Exception e) { //om något annat fel uppstod
            System.out.println("Wrong input!");
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public Movie getDataByTitle(String apiKey, String movieTitle) { //metod för att hämta data från API:et
        String APIUrl = "http://www.omdbapi.com/?apikey=" + apiKey + "&t=" + movieTitle;
        StringBuffer answer = null; //skapar en sträng buffer för att lagra svaret från API:et
        try {   //försöker hämta data från API:et

            URL url = new URL(APIUrl);  //skapar en URL-objekt med API:ets URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //skapar en HTTP-anslutning
            connection.setRequestMethod("GET"); //sätter anslutningens metod till GET

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));     //skapar en bufferedreader för att läsa in svaret från API:et
            String inputLine;  //skapar en sträng för att lagra varje rad från svaret
            answer = new StringBuffer();    //skapar en sträng buffer för att lagra svaret från API:et
            while ((inputLine = in.readLine()) != null) {       //läser in varje rad från svaret
                answer.append(inputLine);   //lägger till varje rad i svaret
            }
            in.close();

        } catch (Exception e) { //om något fel uppstod
            System.out.println(e.getMessage());     //skriv ut felmeddelandet
        }

        JSONObject movie = new JSONObject(answer.toString());   //skapar ett JSON-objekt med svaret från API:et
        String title = movie.getString("Title");
        String year = movie.getString("Year");
        String rated = movie.getString("Director");
        String released = movie.getString("Actors");
        String genre = movie.getString("Genre");

        Movie movie1 = new MovieBuilder()       //skapar ett Movie-objekt med data från API:et
                .setTitle(title)
                .setYear(year)
                .setDirector(rated)
                .setActors(released)
                .setGenre(genre)
                .build();

        return movie1;  //returnerar Movie-objektet

    }
    private void createNewFileForAPI(String key) {                      //metod för att skapa en ny fil för att spara API-nyckeln
        String userHome = System.getProperty("user.home");              //hämtar användarens hemkatalog

        String folderPath = userHome + "/Documents/APIKeys";            //hämtar sökvägen till mappen där filen ska sparas
        String fileName = "OMDB.txt";                                   //hämtar filnamnet
        String filePosition = folderPath + "/" + fileName;              //hämtar sökvägen till filen

        String toWrite = "apiKey=" + key;                               //hämtar innehållet som ska skrivas till filen

        File folder = new File(folderPath);                             //skapar en fil för mappen
        if (!folder.exists()) {                                         //om mappen inte existerar
            folder.mkdirs();
        }

        File file = new File(filePosition);                             //skapar en fil för filen
        try {
            file.createNewFile();
            System.out.println("File created successfully!");
        } catch (IOException e) {                                       //om filen inte kunde skapas
            System.out.println("An error occurred while creating the file.");
            System.out.println(e.getMessage());
        }

        try {
            FileWriter writer = new FileWriter(file);                   //skapar en filwriter för att skriva till filen
            writer.write(toWrite);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            System.out.println(e.getMessage());
        }
    }
}


