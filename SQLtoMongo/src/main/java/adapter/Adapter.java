package adapter;

import java.util.HashMap;
import java.util.LinkedHashMap;

public interface Adapter {

    void buildJson(LinkedHashMap<String, String> mapForMongo);
}
