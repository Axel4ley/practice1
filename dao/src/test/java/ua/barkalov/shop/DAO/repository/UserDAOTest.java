package ua.barkalov.shop.DAO.repository;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.barkalov.shop.DAO.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class UserDAOTest {

    @Autowired
    private UserDao userDAO;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    @Sql("/sql/cleanup.sql")
    public void cleanUp() {
        System.out.println("CleanUp!!!");
    }

    @Test
    public void testFindById() {
        // given
        User user = new User(null, "John", "Dowson", 35);
        entityManager.persist(user);

        // when
        User actualUser = userDAO.get(user.getId());

        // then
        Assert.assertEquals(user, actualUser);
    }
}
