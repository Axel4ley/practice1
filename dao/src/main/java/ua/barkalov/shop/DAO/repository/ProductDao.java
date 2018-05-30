package ua.barkalov.shop.DAO.repository;

import ua.barkalov.shop.DAO.model.Product;

import java.util.List;

public interface ProductDao {

    void create(Product product);
    Product get(Long id);
    List<Product> getAll();
    void delete(Long id);
    void update(Long id, Product product);
}
