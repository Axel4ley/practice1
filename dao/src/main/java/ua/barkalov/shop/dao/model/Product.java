package ua.barkalov.shop.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private Gender gender;
    private Color color;
    private Size size;
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

}
