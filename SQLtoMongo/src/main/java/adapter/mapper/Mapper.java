package adapter.mapper;

import adapter.conventor.ParametarConventor;
import parser.model.SQLQuery;

import java.util.*;

public class Mapper implements MapInterface{


    private String values;
    private MongoMap mongoMap = new MongoMap();
    private String key;
    private String mongoKey;
    private String sqlToMongoValue;
    public Mapper(LinkedHashMap<String, String> map){
        map(map);
    }

    @Override
    public void map(LinkedHashMap<String, String> paramMap) {
        for(Map.Entry<String, String> entry : paramMap.entrySet()){
            key = entry.getKey();
            values = entry.getValue();
            for(Map.Entry<String, String> stringEntry : mongoMap.getSqlToMongo().entrySet()){
                mongoKey = stringEntry.getKey();
                if(key.equalsIgnoreCase(mongoKey)){
                    sqlToMongoValue = stringEntry.getValue();
                    mongoMap.getMongoMap().put(sqlToMongoValue, values);
                }
            }


        }
        System.out.println(mongoMap.getMongoMap());
    }

    public MongoMap getMongoMap() {
        return mongoMap;
    }


}