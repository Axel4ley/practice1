package ua.barkalov.shop.services;

import ua.barkalov.shop.services.dto.ProductDto;

import java.util.List;

public interface ProductService {

    void create(ProductDto product);

    List<ProductDto> findAll();
}
