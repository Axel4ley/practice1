package ua.barkalov.shop.services.converters;

import ua.barkalov.shop.dao.model.Product;
import ua.barkalov.shop.services.dto.ProductDto;

public interface ProductConverter {

    Product toEntity(ProductDto dto);

    ProductDto toDto(Product entity);
}
