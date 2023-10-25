package org.campusmolndal;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import com.mongodb.client.model.Filters;
import java.util.Scanner;

public class User {
    private final String username;
    private final MongoCollection<Document> collection;


    public User(String username, MongoCollection<Document> collection) {
        this.username = username;
        this.collection = collection;
    }
    public void createUser(String username) {
        Document user = new Document("username", username);
        collection.insertOne(user);
    }

    public void loginUser(String username, MongoDatabase db) {
        MongoCollection<Document> userCollection = db.getCollection(username);

        Scanner scanner = new Scanner(System.in);
        MongoDBFacade mongoDbFacade = new MongoDBFacade(userCollection);

        int choice;

        while (true) {
            System.out.println("User Menu");
            System.out.println("1. Add task");
            System.out.println("2. Show task");
            System.out.println("3. Show all tasks");
            System.out.println("4. Update task");
            System.out.println("5. Delete task");
            System.out.println("6. Logout");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 6) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter task name: ");
                    String taskName = scanner.nextLine();
                    System.out.println("Enter task todo: ");
                    String taskDescription = scanner.nextLine();

                    Todo task = new Todo(taskName, taskDescription);
                    mongoDbFacade.create(task);
                    System.out.println("Task added");
                    break;

                case 2:
                    System.out.println("Enter the ID of the task you want to view: ");
                    String taskId = scanner.nextLine();
                    showTask(taskId);
                    break;

                case 3:
                    System.out.println("All tasks: ");
                    for (Document doc : mongoDbFacade.getAllDocuments()) {
                        System.out.println(doc.toJson());
                    }
                    break;

                case 4:
                    System.out.println("Enter the ID of the task you want to update: ");
                    String updateId = scanner.nextLine();
                    System.out.println("Enter the key for the field you want to update: ");
                    String updateKey = scanner.nextLine();
                    System.out.println("Enter the new value: ");
                    String updateValue = scanner.nextLine();

                    mongoDbFacade.update(updateId, updateKey, updateValue);
                    System.out.println("Task updated");
                    break;

                case 5:
                    System.out.println("Enter the ID of the task you want to delete: ");
                    String deleteId = scanner.nextLine();

                    mongoDbFacade.delete(deleteId);
                    System.out.println("Task deleted");
                    break;

                default:
                    System.out.println("Invalid choice");
        }
        }
}
    public void showTask(String taskId) {
        Bson filter = Filters.eq("_id", new ObjectId(taskId));
        Document task = collection.find(filter).first();
        if (task != null) {
            System.out.println("Task details:");
            System.out.println(task.toJson());
        } else {
            System.out.println("Task not found.");
        }
}
}
