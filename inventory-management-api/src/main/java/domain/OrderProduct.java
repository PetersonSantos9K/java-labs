package domain;

public class OrderProduct {

    private final Integer id;
    private final Order order;
    private final Product product;
    private Integer quantity;
    private Double unitPrice;
    private Double subtotal;

    public OrderProduct(Integer id, Order order, Product product) {
        this.id = id;
        this.order = order;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
