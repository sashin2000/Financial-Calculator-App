package app;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import javafx.scene.control.Label;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class History {

    // Establishing the connection with mongodb
    private static MongoClient mongoClient = new MongoClient("localhost", 27017);

    // Connecting to the database
    private static MongoDatabase mongoDatabase = mongoClient.getDatabase("FinancialCalculator");

    public static void addToHistory(String[] historyKeys, String[] strValues, String collectionName){

        // Connecting to the collection in the database
        MongoCollection mongoCollection = mongoDatabase.getCollection(collectionName);
        Document document = new Document();

        for (int i = 0; i < historyKeys.length; i++) {
            document.append(historyKeys[i],strValues[i]);
        }

        mongoCollection.insertOne(document);
    }

    public  static Label displayHistory(String collectionName){
        // Connecting to the collection in the database
        MongoCollection mongoCollection = mongoDatabase.getCollection(collectionName);

        MongoCursor<Document> cursor = mongoCollection.find().iterator();

        // Making a well arranged displaying output by getting the data from the relevant collection
        Label lblHistory = new Label("");
        while (cursor.hasNext()){
            Document doc = cursor.next();
            List fields = new ArrayList(doc.keySet());
            List values = new ArrayList(doc.values());
            for (int i = 1; i < fields.size(); i++) {
                lblHistory.setText(lblHistory.getText() + fields.get(i) + " : " + values.get(i) + "\n");
                System.out.println(fields.get(i) + " : " + values.get(i));
            }
            lblHistory.setText(lblHistory.getText() + "\n");
            System.out.println();
        }
        return lblHistory;
    }
}
