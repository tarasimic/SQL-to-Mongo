package parser.model;

import parser.model.Clause;

import java.util.ArrayList;
import java.util.List;

public class SQLQuery {
    private List<Clause> clauses;

    public SQLQuery(){
        clauses = new ArrayList<>();
    }

    public List<Clause> getClauses() {
        return clauses;
    }

    public void addClause(Clause clause) {
        this.clauses.add(clause);
    }
}
