package ua.barkalov.shop.dao.repository;

import ua.barkalov.shop.dao.model.Product;

import java.util.List;

public interface ProductDao {

    void create(Product product);
    List<Product> getAll();
}
