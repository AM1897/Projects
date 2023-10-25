package org.example;    // paketdeklaration för att kunna använda klasserna i paketet org.example.

import com.mongodb.client.MongoCollection;  // Den används för att representera en collection i en databas.
import com.mongodb.client.MongoDatabase;    // Den används för att representera en databas och hämta en collection.
import com.mongodb.client.FindIterable;     // den hittar alla dokument i en collection.
import com.mongodb.client.model.Filters;    // skapar filter för att använda vid sökning, uppdatering och radering av dokument i databasen.
import com.mongodb.client.model.Updates;    // uppdateringar för att använda vid uppdatering av dokument i databasen.
import org.bson.Document;                   // representerar ett dokument i en collection.
import org.bson.conversions.Bson;           // konverterar ett dokument till ett filter.
import org.bson.types.ObjectId;             // representerar ett ObjectID i MongoDB.
import java.util.Scanner;

public class MongoDBFacade {
    private final MongoCollection<Document> collection;     // skapar en variabel av typen MongoCollection<Document> som heter collection.

    public MongoDBFacade(MongoDatabase db, String collectionName) {
        this.collection = db.getCollection(collectionName);
    }

    public void create(String name, int age, String address, String type, Scanner scanner) {
        Bson filter = Filters.and(
                Filters.eq("name", name),
                Filters.eq("age", age),
                Filters.eq("address", address),
                Filters.eq("type", type)
        );

        if (collection.countDocuments(filter) == 0) {
            Document doc = new Document("name", name)
                    .append("age", age)
                    .append("address", address)
                    .append("type", type);

            String number;      // skapar en variabel av typen String som heter number.
            String numberFilter;// skapar en variabel av typen String som heter numberFilter.

            // Skapar en if-sats som kollar om type är lika med E eller C.
            if (type.equalsIgnoreCase("E")) {   // Om type är lika med E så skrivs Employees number ut.
                System.out.print("Employees number: ");
                numberFilter = "Employees number";          // Skapar en variabel av typen String som heter numberFilter och sätter värdet till Employees number.
                } else if (type.equalsIgnoreCase("C")) {    // Om type är lika med C så skrivs Customers number ut.
                System.out.print("Customers number: ");
                numberFilter = "Customers number";      // Skapar en variabel av typen String som heter numberFilter och sätter värdet till Customers number.
                } else {
                throw new IllegalArgumentException("Invalid type: " + type);

                }
            number = scanner.nextLine();    // Skapar en variabel av typen String som heter number och sätter värdet till det som användaren skriver in.
            Bson filter2 = Filters.or(Filters.eq("Employees number", number), Filters.eq("Customers number", number));  // Skapar en variabel av typen Bson som heter filter2 och sätter värdet till Employees number eller Customers number.
                if (collection.countDocuments(filter2) == 0) {   // Skapar en if-sats som kollar om det finns ett dokument med samma number.
                    doc.append(numberFilter, number);   // Om det inte finns ett dokument med samma number så läggs number till i dokumentet.
                } else {
                    System.out.println("A customer with that number already exists.");  // Om det finns ett dokument med samma number så skrivs ett meddelande ut.
                    return;
                }
            collection.insertOne(doc);
        }
    }


    public FindIterable<Document> getAllDocuments() {       // Hittar alla dokument i en collection.
        return collection.find();
    }

    public void update(String id, String key, Object value) {       // Uppdaterar ett dokument i en collection.
        Bson filter = Filters.eq("_id", new ObjectId(id));
        Bson update = Updates.set(key, value);
        collection.updateOne(filter, update);
    }

    public void delete(String id) {         // Raderar ett dokument i en collection.
        Bson filter = Filters.eq("_id", new ObjectId(id));
        collection.deleteOne(filter);
    }
}


