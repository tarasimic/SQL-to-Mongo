package parser.model;

public class FromClause extends Clause {
    private String table;
    public  FromClause(String table) {
        super("FROM");
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    @Override
    public String toString() {
        return this.getKeyword() + " "  + table;
    }
}
