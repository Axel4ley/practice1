package ua.barkalov.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.barkalov.shop.DAO.model.Product;
import ua.barkalov.shop.DAO.repository.ProductDao;
import ua.barkalov.shop.services.ProductService;
import ua.barkalov.shop.services.converters.ProductConverter;
import ua.barkalov.shop.services.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final ProductConverter productConverter;

    @Autowired
    public ProductServiceImpl(ProductDao productDao, ProductConverter productConverter) {
        this.productDao = productDao;
        this.productConverter = productConverter;
    }


    public void create(ProductDto product) {
        Product productEntity = productConverter.toEntity(product);
        productDao.create(productEntity);
    }

    public List<ProductDto> findAll() {

        List<Product> products = productDao.getAll();

        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : products) {
            ProductDto dto = productConverter.toDto(product);
            productDtos.add(dto);
        }
        return productDtos;
    }
}
