package parser.model;

public class JoinClause extends  Clause {
    String table;
    String localField;
    String foreignField;
    String alias;

    public JoinClause(String keyword, String table, String localField, String foreignField, String alias) {
        super(keyword);
        this.table = table;
        this.localField = localField;
        this.foreignField = foreignField;
        this.alias = alias;
    }

    public String getTable() {
        return table;
    }

    public String getLocalField() {
        return localField;
    }

    public String getForeignField() {
        return foreignField;
    }

    public String getAlias() {
        return alias;
    }
}
