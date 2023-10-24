public class Main {
    public static void main(String[] args) {

        String[] name = {"Elena Gilbert ", "Stefan Salvatore ", "Damon Salvatore ",
                "Caroline Forbes ", "Bonnie Bennett ", "Tyler Lockwood ", "Matt Donovan ",
                "Alaric Saltzman ", "Klaus Mikaelson ", "Rebekah Mikaelson "};
        int[] age = {17, 162, 177, 17, 17, 22, 19, 41, 1000, 1012};

        //1. Skriv ut alla personer som är under 20 år.

        System.out.println("Personer som är under 20 år:");
        for (int i = 0; i < name.length; i++) {
            if (age[i] < 20) {                      // if ser till att allt som är under 20 år i arrayen
                System.out.println(name[i] + "" + age[i] + " år");  // den skriver ut namnet för sedan ålder
            }
        }
        System.out.println("------------------------------");
        //2. Skriv ut alla personer som är 20 år och alla som är under 30 år.
        System.out.println("Personer mellan 20 och 30 år:");
        for (int i = 0; i < name.length; i++) {
            if (age[i] >= 20 && age[i] < 30) {          //mellan 20 och 30 skall hittas.
                System.out.println(name[i] + "" + age[i] + " år");  // Skriver ut personer som hittades i arrayen
            }
        }
        //3. Skriv ut alla personer som är yngre än 20 år och alla som är äldre än 29 år.
        System.out.println("------------------------------");
        System.out.println("Personer som är under 20 år och är äldre än 29 år:");
        for (int i = 0; i < name.length; i++) {
            if (age[i] < 20 || age[i] > 29) {           //hittar personer som inte är mellan 20 och 29
                System.out.println(name[i] + "" + age[i] + " år");  // här skriver den ut som hittades i sökningen
            }
        }
        //4. Visa namn och ålder på äldsta och yngsta karaktären (1 av varje)
        System.out.println("------------------------------");
        int oldestAge = Integer.MIN_VALUE;      //vi har gett Oldest max värde
        int youngest = Integer.MAX_VALUE;       // Här har vi gett youngest lägsta värden
        System.out.println("Äldsta och yngsta Personerna:");
        for (int i = 0; i < name.length; i++) {
            if (age[i] > oldestAge) {       // kollar om det finns större än oldest som är max värde.
                oldestAge = age[i];         //representerar att oldestAge är störst i åldern
            }
            if (age[i] < youngest) {        // här är det likadant som ovanför men i det minsta värdet
                youngest = age[i];
            }
        }
        for (int i = 0; i < name.length; i++) {
            if (age[i] == oldestAge) {      //detta jämförs med den högsta siffran som skall finnas i arrayen
                System.out.println("Äldsta personen är " + name[i] + "" + oldestAge + " år"); // här skriver den ut den äldsta
            }
            if (age[i] == youngest) {       // nästan samma som ovanför men här kör den efter den minsta i arrayen
                System.out.println("Yngsta personen är " + name[i] + "" + youngest + " år");    // här skriver vi ut den Yngsta.
            }
        }
        //5. Visa en lista på alla personer som har jämna tal i sin ålder
        System.out.println("------------------------------");
        System.out.println("Personer med jämnt antal år:");
        for (int i = 0; i < name.length; i++) {
            if (age[i] % 2 == 0) {              //Om åldern är jämnt delbar med 2
                System.out.println(name[i] + "" + age[i] + " år"); //Skriver ut alla namn med jämnt ålder.
            }
        }
        //6. Visa alla namn men stoppa körningen vid första person över 40 år.
        System.out.println("------------------------------");
        System.out.println("Personer under 40 år:");
        for (int i = 0; i < name.length; i++) {
            if (age[i] < 40) {          // hittar alla som är mindre än 40 år
                System.out.println(name[i] + "" + age[i] + " år");      //skriver ut de med namn och ålder
            }
        }
    }
}