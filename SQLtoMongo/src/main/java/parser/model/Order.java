package parser.model;

public class Order {

    private String order;
    private String parameter;


    public Order() {
        this.order = null;
        this.parameter = null;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order='" + order + '\'' +
                ", parameter='" + parameter + '\'' +
                '}';
    }
}
