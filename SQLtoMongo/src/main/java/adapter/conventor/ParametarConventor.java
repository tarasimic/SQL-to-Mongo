package adapter.conventor;

import adapter.conventor.Conventor;
import parser.model.*;

import java.util.*;

public class ParametarConventor implements Conventor {
    private LinkedHashMap<String, String> parametermap;

    public ParametarConventor(SQLQuery query){

        adapt(query);
    }

    @Override
    public LinkedHashMap<String, String>  adapt(SQLQuery clauseList) {
        parametermap = new LinkedHashMap<>();
        for (Clause clause1 : clauseList.getClauses()) {
            String key = clause1.getKeyword();

            if (key.equalsIgnoreCase("SELECT")) {
                StringBuilder builder = new StringBuilder();
                SelectClause select = (SelectClause)(clause1);
                if(select.getParameters().contains("*")){
                    builder.append("{}");
                }else{
                    builder.append("{ ");
                    for(String element: select.getParameters()){
                        builder.append(element);
                        builder.append(": 1");
                    }
                }
                builder.append("{ ");
                //co

                builder.delete(builder.length() - 2, builder.length()); // Removing the trailing comma and space
                builder.append(" }");
                parametermap.put(key, builder.toString());
            } else if(key.equalsIgnoreCase("ORDER BY")) {
                StringBuilder builder = new StringBuilder();
                builder.append("{");
                OrderByClause orderByClause = (OrderByClause) clause1;
                for (Order element : orderByClause.getParameters()) {
                    builder.append(element.getParameter());
                    if(orderByClause.getOrder().contains("desc")) {
                        builder.append(":-1");
                    } else if(orderByClause.getOrder().contains("asc")) {
                        builder.append(":1");
                    }
                    if(orderByClause.getParameters().size() > 2) {
                        builder.append(",");
                    }
                }

                builder.append(" }");
                parametermap.put(key, builder.toString());
            }
            else if(key.equalsIgnoreCase("FROM")){
                parametermap.put("from", ((FromClause)clause1).getTable());
            }
        }

        for (String key1 : parametermap.keySet()) {
            String values = parametermap.get(key1);
            System.out.println("Key: " + key1);
            System.out.println("Values: " + values);
        }

        return parametermap;
    }

    public LinkedHashMap<String, String> getParametermap() {
        return parametermap;
    }


}

