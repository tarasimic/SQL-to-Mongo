package adapter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class AdapterImplementation implements Adapter{

    private StringBuilder buildQuery;
    private String value;
    private String collection;
    private String key;
    private int aggIndex = 2;
    private int actualAggIndex;
    private int findIndex = 1;
    private int actualFindIndex;
    private String mongoQuery;
    private boolean aggregate = true;
    private Iterator<Map.Entry<String, String>> iterator;
    private String find = ".find(%s,%s";

    public AdapterImplementation(LinkedHashMap<String, String> mapForMongo){
        this.buildQuery = new StringBuilder();
        buildJson(mapForMongo);
    }
    @Override
    public void buildJson(LinkedHashMap<String, String> mapForMongo) {
        for(Map.Entry<String, String> entry : mapForMongo.entrySet()){
            if(entry.getKey().equalsIgnoreCase("collection")){
                collection = entry.getValue();
            }
        }
        iterator = mapForMongo.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            if((entry.getValue() == null || entry.getKey().equalsIgnoreCase("collection"))){
                iterator.remove();
            }
        }
        buildQuery.append("bp_tim88." + collection);
//        if(mapForMongo.containsKey("$groupby")){
//            aggregate = true;
//            buildQuery.append(".aggregate([");
//        }
        if(aggregate){
            buildQuery.append(".aggregate([");
        }

        for(Map.Entry<String, String> entry : mapForMongo.entrySet()){
            value = entry.getValue();
            key = entry.getKey();
            if(aggregate){
                buildQuery.append("{"+key+":"+value+"},");
            }
//                else{
//                    find = String.format(find, value);
//                    buildQuery.append(find);
//                }


        }
        if(aggregate){
            buildQuery.append("])");
            actualAggIndex = buildQuery.length() - aggIndex-1;
            buildQuery.deleteCharAt(actualAggIndex);
        }else{
            buildQuery.append(")");
            actualFindIndex = buildQuery.length() - findIndex-1;
            buildQuery.deleteCharAt(actualFindIndex);
        }
        mongoQuery = buildQuery.toString();
        System.out.println(mongoQuery);

    }

    public String getCollection() {
        return collection;
    }

    public String getMongoQuery() {
        return mongoQuery;
    }
}


