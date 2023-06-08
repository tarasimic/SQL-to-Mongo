package parser.model;

import java.util.ArrayList;
import java.util.List;

public class OrderByClause extends Clause{
    private List<Order> parameters;
    private String order;

    public OrderByClause(String keyword) {
        super(keyword);
        parameters = new ArrayList<>();
        this.order = null;
    }

    public List<Order> getParameters() {
        return parameters;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderByClause{" +
                "parameters=" + parameters +
                ", order='" + order + '\'' +
                '}';
    }
}
