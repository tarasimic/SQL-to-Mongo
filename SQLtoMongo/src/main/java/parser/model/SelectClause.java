package parser.model;

import java.util.ArrayList;
import java.util.List;

public class SelectClause extends Clause{
    private List<String> parameters;

    public SelectClause() {
        super("SELECT");
        this.parameters = new ArrayList<>();
    }

    public List<String> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return this.getKeyword() +
                " " + parameters;
    }
}
