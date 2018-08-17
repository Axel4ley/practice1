package ua.barkalov.shop.services.dto;

import ua.barkalov.shop.DAO.model.Product;
import ua.barkalov.shop.DAO.model.User;

import java.util.Date;
import java.util.Set;

public class OrderDto {

    private User user;
    private Set<Product> products;
    private String status;
    private Date date;

    public OrderDto() {
    }

    public OrderDto(User user, Set<Product> products, String status, Date date) {
        this.user = user;
        this.products = products;
        this.status = status;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "user=" + user +
                ", products=" + products +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
