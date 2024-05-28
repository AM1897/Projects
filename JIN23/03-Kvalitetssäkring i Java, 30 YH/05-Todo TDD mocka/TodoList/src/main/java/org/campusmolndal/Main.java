package org.campusmolndal;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = create("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("TodoList");
        MongoCollection<Document> usersCollection = db.getCollection("Users");

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 3) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter username: ");
                    String username = scanner.nextLine();
                    if (userExists(usersCollection, username)) {
                        System.out.println("User already exists. Please choose a different username.");
                        break;
                    }

                    User newUser = new User(username, usersCollection);
                    newUser.createUser(username);
                    System.out.println("User created successfully.");
                    break;

                case 2:
                    System.out.println("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    if (!userExists(usersCollection, loginUsername)) {
                        System.out.println("User not found. Please create a user first.");
                        break;
                    }

                    User existingUser = new User(loginUsername, usersCollection);
                    existingUser.loginUser(loginUsername, db);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }

    static MongoClient create(String host, int port) {
        return MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(new ServerAddress(host, port))))
                        .build());
    }
    static boolean userExists(MongoCollection<Document> usersCollection, String username) {
        Document user = usersCollection.find(new Document("username", username)).first();
        return user != null;
    }
}