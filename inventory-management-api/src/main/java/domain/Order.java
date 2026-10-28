package domain;

import java.time.LocalDate;

public class Order {

    private final String id;
    private Double total;
    private LocalDate createdAt;
    private final User user;
    private Status status;

    public Order(String id, Double total, LocalDate createdAt, User user, Status status) {
        this.id = id;
        this.total = total;
        this.createdAt = createdAt;
        this.user = user;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
