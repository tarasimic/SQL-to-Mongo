package database.controller.mongo;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Collation;
import org.bson.Document;

import javax.print.Doc;
import java.util.Arrays;

public class MongoConnection implements DB{

    private static String user = "writer";
    private static String database = "bp_tim88";
    private static String password = "uKMomxMtoFm02kmI";
    private MongoCredential credential;
    private MongoClient mongoClient;

    @Override
    public MongoClient getConnection() {

        credential = MongoCredential.createCredential(user, database, password.toCharArray());
        mongoClient = new MongoClient(new ServerAddress("134.209.239.154", 27017), Arrays.asList(credential));
        System.out.println("Connected to database successfully");

        MongoDatabase database1=mongoClient.getDatabase("bp_tim88");

        return mongoClient;
    }

    public static String getDatabase() {
        return database;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}