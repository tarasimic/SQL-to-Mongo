package parser.model;

import java.util.ArrayList;
import java.util.List;

public class GroupByClause extends Clause{
    private List<String> parameters;

    public GroupByClause(String keyword) {
        super(keyword);
        parameters = new ArrayList<>();
    }
}
