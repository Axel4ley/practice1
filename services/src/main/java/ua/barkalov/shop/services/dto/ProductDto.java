package ua.barkalov.shop.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.barkalov.shop.dao.model.Product;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String name;
    private BigDecimal price;
    private Product.Category category;
    private Product.Gender gender;
    private Product.Color color;
    private Product.Size size;
    private int remainingCount;

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
