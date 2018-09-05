package ua.barkalov.shop.DAO.repository.impl;

import org.springframework.stereotype.Repository;
import ua.barkalov.shop.DAO.model.Product;
import ua.barkalov.shop.DAO.repository.ProductDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

//    private final Map<Long, Product> products = new HashMap<>();
//
//    private static volatile long idGenerator = 1L;

    public void create(Product product) {
        entityManager.persist(product);
    }

    //
    @Override
    public Product get(Long id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> getAll(){
        TypedQuery<Product> findAllProducts =
                entityManager.createQuery("SELECT p FROM Product p", Product.class);

        return findAllProducts.getResultList();
    }

    //
    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Product p WHERE p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    //
    @Override
    public void update(Long id, Product product) {
        product.setId(id);
        entityManager.merge(product);
    }
}
