package parser.controller;

import parser.model.Order;
import parser.model.OrderByClause;

public class OrderByImplementation implements  Parse{
    OrderByClause orderByClause;

    public OrderByImplementation() {
        this.orderByClause = new OrderByClause("ORDER BY");
    }

    @Override
    public void parse(String query) {
        String words[] = query.trim().split("order_by")[1].replaceAll(",", " ").split("\\s+");
        Order order = new Order();
        for(String word : words) {
            if(word.equalsIgnoreCase("")) {
                continue;
            }
            if(word.toLowerCase().contains("asc") || word.contains("desc")) {
                orderByClause.setOrder(word.toLowerCase());
                order.setOrder(word);

                order = new Order();
            } else {
                order.setParameter(word);
                orderByClause.getParameters().add(order);
            }
        }
    }

    public OrderByClause getOrderByClause() {
        return orderByClause;
    }
}
