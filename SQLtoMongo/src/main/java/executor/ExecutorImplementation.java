package executor;

import adapter.AdapterImplementation;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import database.controller.mongo.MongoConnection;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImplementation implements Executor {

    private MongoCollection<Document> collection ;

    private String collectionName;
    private String collectionDB;
    private String filter;
    private MongoDatabase database;
    private MongoClient mongoClient;
    private Document parser;
    private String temp;
    private String prim;
    private Document document;
    private String json;
    private List<Bson> pipeline;
    private String[] stages;
    private AggregateIterable<Document> result;
    private List<Document> documents;
    public ExecutorImplementation(String query, MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        execute(query);

    }


    @Override

    public void execute(String query){
        prim = query;
        temp = prim.split("\\.", 2)[1];
        collectionName = temp.split("\\.aggregate", 2)[0];
        filter = query.substring(query.indexOf("[") + 1, query.lastIndexOf("]"));
        database = mongoClient.getDatabase("bp_tim88");
        collection = database.getCollection(collectionName);

        pipeline = new ArrayList<>();
        if(filter.contains(",")){
            stages = filter.split(",");
        }else {
            stages = new String[]{filter};
        }
        for(String stage: stages){
            parser = Document.parse(stage);
            pipeline.add(parser);
        }
        result = collection.aggregate(pipeline);
        MongoCursor<Document> cursor = result.iterator();
        documents = new ArrayList<>();
        while(cursor.hasNext()){
            document = cursor.next();
            documents.add(document);
            json = document.toJson();

        }
        System.out.println(documents);

//        try(MongoCursor<Document> cursor = collection.find(parser).iterator()){
//            while(cursor.hasNext()){
//                document = cursor.next();
//                //json = document.toJson();
//                System.out.println(document);
//            }
//        }
    }

    public List<Document> getDocuments() {
        return documents;
    }
}