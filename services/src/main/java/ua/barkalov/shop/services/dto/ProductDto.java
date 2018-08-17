package ua.barkalov.shop.services.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDto {

    private String name;
    private BigDecimal price;
    private String category;
    private String gender;
    private String color;
    private String size;
    private int remainingCount;

    public ProductDto() {
    }

    public ProductDto(String name, BigDecimal price, String category, String gender, String color, String size, int remainingCount) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.gender = gender;
        this.color = color;
        this.size = size;
        this.remainingCount = remainingCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getRemainingCount() {
        return remainingCount;
    }

    public void setRemainingCount(int remainingCount) {
        this.remainingCount = remainingCount;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", gender=" + gender +
                ", color=" + color +
                ", size=" + size +
                ", remainingCount=" + remainingCount +
                '}';
    }
}
