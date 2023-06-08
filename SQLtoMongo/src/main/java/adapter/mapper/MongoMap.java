package adapter.mapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MongoMap {

    private LinkedHashMap<String, String> mongoMap = new LinkedHashMap<>();
    private LinkedHashMap<String, String> sqlToMongo = new LinkedHashMap<>();
    public MongoMap(){
        mongoMap.put("$project", null);
        mongoMap.put("$match", null);
        mongoMap.put("$groupby", null);
        mongoMap.put("$sort", null);
        mongoMap.put("collection", null);
        sqlToMongo.put("select", "$project");
        sqlToMongo.put("where", "$match");
        sqlToMongo.put("group by", "$groupby");
        sqlToMongo.put("order by", "$sort");
        sqlToMongo.put("from", "collection");
    }

    public LinkedHashMap<String, String> getMongoMap() {
        return mongoMap;
    }

    public LinkedHashMap<String, String> getSqlToMongo() {
        return sqlToMongo;
    }
}