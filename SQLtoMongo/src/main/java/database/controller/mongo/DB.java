package database.controller.mongo;

import com.mongodb.MongoClient;

public interface DB {
    MongoClient getConnection();
}
