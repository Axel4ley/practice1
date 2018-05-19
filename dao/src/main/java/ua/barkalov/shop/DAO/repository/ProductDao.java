package ua.barkalov.shop.DAO.repository;

import ua.barkalov.shop.DAO.model.Product;

import java.util.List;

public interface ProductDao {

    void create(Product product);
    List<Product> getAll();
}
