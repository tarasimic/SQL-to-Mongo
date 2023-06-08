package adapter.conventor;

import parser.model.SQLQuery;

import java.util.HashMap;
import java.util.List;

public interface Conventor {
    HashMap<String, String> adapt(SQLQuery sqlQuery);
}