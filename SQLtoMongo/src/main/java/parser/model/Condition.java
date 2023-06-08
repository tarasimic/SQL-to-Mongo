package parser.model;

public class Condition {
    private String field;
    private String operator;
    private String value;
    private WhereClause subQuery;

    public Condition() {
        this.field = null;
        this.operator = null;
        this.value = null;
        this.subQuery = null;
    }

    public String getField() {
        return field;
    }

    public String getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSubQuery(WhereClause subQuery) {
        this.subQuery = subQuery;
    }

    @Override
    public String toString() {
        return field + " " + operator + " " + value;
    }
}