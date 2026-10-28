package domain;

import java.time.LocalDate;

public class Product {

    private final Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private LocalDate createdAt;

    private final User createBy;
    private Category category;

    public Product(Integer id, String name, String description, Double price, Integer quantity, User createBy, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.createBy = createBy;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreateBy() {
        return createBy;
    }

    public Category getCategory() {
        return category;
    }

}
