package org.campusmolndal;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;



public class MongoDBFacade {
    private final MongoCollection<Document> collection;

    public MongoDBFacade(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void create(Todo task) {
        // Skapa dokumentet för att lägga till i samlingen
        Document doc = new Document("name", task.getName())
                .append("todo", task.getTodo());

        // Lägg till dokumentet i samlingen
        collection.insertOne(doc);
    }

    public FindIterable<Document> getAllDocuments() {
        return collection.find();
    }

    public void update(String id, String key, Object value) {
        Bson filter = Filters.eq("_id", new ObjectId(id));
        Bson update = Updates.set(key, value);
        collection.updateOne(filter, update);
    }

    public void delete(String id) {
        Bson filter = Filters.eq("_id", new ObjectId(id));
        collection.deleteOne(filter);
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
