package org.example;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            // Skapar en anslutning till en MongoDB server.
        MongoClient mongoClient = create("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("CRUD-DB-JAVA");
        MongoDBFacade mongoDBFacade = new MongoDBFacade(db, "Collection");

        Scanner scanner = new Scanner(System.in);  // Skapar en scanner för att läsa in data från användaren.
        int choice; // Skapar en variabel för att läsa in val från användaren.

        while (true) {      // Skapar en loop som körs tills användaren väljer att avsluta.
            System.out.println("Menu:");
            System.out.println("1. Create a person");
            System.out.println("2. Show all Customers and Employees");
            System.out.println("3. Update");
            System.out.println("4. Delete person with ID");
            System.out.println("0. Exit");

            choice = scanner.nextInt();    // Läser in val från användaren.
            scanner.nextLine();

            if (choice == 0) {  // Om användaren väljer 0 så avslutas programmet.
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Are you an employee or customer? (E/C): ");
                    String type = scanner.nextLine();

                    mongoDBFacade.create(name, age, address, type, scanner);
                    System.out.println("Person created.");
                    break;

                case 2:
                    System.out.println("All persons in the database:");
                    for (Document doc : mongoDBFacade.getAllDocuments()) {
                        System.out.println(doc.toJson());
                    }
                    break;

                case 3:
                    System.out.print("Enter the ID of the person you want to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter the key for the field you want to update: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter the new value for the field: ");
                    String value = scanner.nextLine();

                    mongoDBFacade.update(updateId, key, value);
                    System.out.println("Person updated.");
                    break;

                case 4:
                    System.out.println("Enter the ID of the person you want to delete: ");
                    String deleteId = scanner.nextLine();

                    mongoDBFacade.delete(deleteId);
                    System.out.println("The person has been permanently removed from the database.");
                    break;

                case 0:
                    System.out.println("Exit the program..");
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
        scanner.close();        // Stänger scanner.
    }

    private static MongoClient create(String host, int port) {      // skapar 2 nya variabler för att skapa en anslutning till en MongoDB server.
        return MongoClients.create(                                 // Skapar en anslutning till en MongoDB server.
                MongoClientSettings.builder()                           // Skapar en instans av MongoClientSettings.
                        .applyToClusterSettings(builder ->              // Skapar en instans av ClusterSettings.
                                builder.hosts(Arrays.asList(new ServerAddress(host, port))))        // Skapar en instans av ServerAddress.
                        .build());                            // Skapar en instans av MongoClient.
    }
}