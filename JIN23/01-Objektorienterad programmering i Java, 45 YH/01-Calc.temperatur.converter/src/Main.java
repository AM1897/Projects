import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Välj en kategori");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");

        int category = input.nextInt();

        if (category == 1) {
            System.out.println("Celsius");
            System.out.println("Väl en kategori");
            System.out.println("1. Celsius -> Fahrenheit");
            System.out.println("2. Celsius -> Kelvin");

            int conversion = input.nextInt();

            if (conversion == 1) {
                System.out.println("Celsius -> Fahrenheit");
                System.out.println("Ange temperaturen i Celsius");

                double celsius = input.nextDouble();
                double fahrenheit = (celsius * 1.8) + 32;

                System.out.println(celsius + " °C = " + fahrenheit + " °F ");
            }
            if (conversion == 2) {
                System.out.println("Celsius -> Kelvin");
                System.out.println("Ange temperaturen i Celsius");

                double celsius = input.nextDouble();
                double kelvin = celsius + 273.15;

                System.out.println(celsius + " °C = " + kelvin + " °K ");
            }
        }
        if (category == 2) {
            System.out.println("Fahrenheit");
            System.out.println("Välj en kategori");
            System.out.println("1. Fahrenheit -> Celsius");
            System.out.println("2. Fahrenheit -> Kelvin");

            int conversion = input.nextInt();

            if (conversion == 1) {
                System.out.println("Fahrenheit -> Celsius");
                System.out.println("Ange temperaturen i Fahrenheit");

                double fahrenheit = input.nextDouble();
                double celsius = (fahrenheit - 32) / 1.8;

                System.out.println(fahrenheit + " °F = " + celsius + " °C ");

            }
            if (conversion == 2) {
                System.out.println("Fahrenheit -> Kelvin");
                System.out.println("Ange temperaturen i Fahrenheit");

                double fahrenheit = input.nextDouble();
                double kelvin = (fahrenheit + 459.67) / 1.8;
                System.out.println(fahrenheit + " °F = " + kelvin + " °K ");
            }

        }

        if (category == 3) {
            System.out.println("Kelvin");
            System.out.println("Välj en kategori");
            System.out.println("1. Kelvin -> Celsius");
            System.out.println("2. Kelvin -> Fahrenheit");

            int conversion = input.nextInt();

            if (conversion == 1) {
                System.out.println("Kelvin -> Celsius");
                System.out.println("Ange temperaturen i Kelvin");

                double Kelvin = input.nextDouble();
                double celsius = (Kelvin - 273.15);

                System.out.println(Kelvin + " °K = " + celsius + " °C ");

            }
            if (conversion == 2) {
                System.out.println("Kelvin -> Fahrenheit");
                System.out.println("Ange temperaturen i Kelvin");

                double kelvin = input.nextDouble();
                double fahrenheit = kelvin * 1.8 - 459.67;
                System.out.println(kelvin + " °K = " + fahrenheit + " °F ");
            }

        }
    }

}