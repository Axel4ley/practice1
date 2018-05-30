package ua.barkalov.shop.DAO.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "CATEGORY", nullable = false)
    private Category category;

    @Column(name = "GENDER", nullable = false)
    private Gender gender;

    @Column(name = "COLOR", nullable = false)
    private Color color;

    @Column(name = "PRODUCT_SIZE", nullable = false)
    private Size size;

    @Column(name = "REMAINING_COUNT", nullable = false)
    private int remainingCount;

    public enum Category {
        CLOTHES, FOOTRWEAR, ACCESSORISE
    }

    public enum Gender {
        MALE, FEMALE, UNISEX
    }

    public enum Color {
        WHITE, YELLOW, ROSE, RED, GREEN, BLUE, PURPLE, GREY, BLACK
    }

    public enum Size {
        S, M, L, XL
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return remainingCount == product.remainingCount &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                category == product.category &&
                gender == product.gender &&
                color == product.color &&
                size == product.size;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, category, gender, color, size, remainingCount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", gender=" + gender +
                ", color=" + color +
                ", size=" + size +
                ", remainingCount=" + remainingCount +
                '}';
    }
}
