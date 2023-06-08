package executor;

import com.mongodb.MongoClient;

public interface Executor {

    void execute(String query);
}
