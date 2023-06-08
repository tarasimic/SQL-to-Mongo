package parser.model;

import java.util.ArrayList;
import java.util.List;

public class WhereClause extends Clause {
    private List<Condition> conditions = new ArrayList<>();


    public WhereClause() {
        super("WHERE");
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    @Override
    public String toString() {
        return "WhereClause{" +
                "conditions=" + conditions +
                '}';
    }
}
