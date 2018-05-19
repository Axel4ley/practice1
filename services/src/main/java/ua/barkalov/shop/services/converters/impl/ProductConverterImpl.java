package ua.barkalov.shop.services.converters.impl;

import org.springframework.stereotype.Component;
import ua.barkalov.shop.DAO.model.Product;
import ua.barkalov.shop.services.converters.ProductConverter;
import ua.barkalov.shop.services.dto.ProductDto;

@Component
public class ProductConverterImpl implements ProductConverter {

    public Product toEntity(ProductDto dto) {
        return new Product(
                null,
                dto.getName(),
                dto.getPrice(),
                dto.getCategory(),
                dto.getGender(),
                dto.getColor(),
                dto.getSize(),
                dto.getRemainingCount()
        );
    }

    public ProductDto toDto(Product entity) {
        return new ProductDto(
                entity.getName(),
                entity.getPrice(),
                entity.getCategory(),
                entity.getGender(),
                entity.getColor(),
                entity.getSize(),
                entity.getRemainingCount()
        );
    }
}
