package ua.barkalov.shop.DAO.repository.impl;

import org.springframework.stereotype.Repository;
import ua.barkalov.shop.DAO.model.Product;
import ua.barkalov.shop.DAO.repository.ProductDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    private final Map<Long, Product> products = new HashMap<>();

    private static volatile long idGenerator = 1L;

    public void create(Product product) {
        product.setId(idGenerator++);
        products.put(product.getId(), product);
    }

    public List<Product> getAll(){
        return new ArrayList<>(products.values());
    }

}
