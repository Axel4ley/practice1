package ua.barkalov.shop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ua.barkalov.shop.dao.model.Product;
import ua.barkalov.shop.dao.repository.impl.UserDaoImpl;
import ua.barkalov.shop.services.ProductService;
import ua.barkalov.shop.services.UserService;
import ua.barkalov.shop.services.dto.ProductDto;
import ua.barkalov.shop.services.dto.UserDto;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new GenericXmlApplicationContext("context-main.xml");
        UserService userService = context.getBean(UserService.class);
        ProductService productService = context.getBean(ProductService.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = reader.readLine();
            String[] arguments = input.split(" ");

            if("UC".equals(arguments[0])) {
                UserDto dto = new UserDto(arguments[1], arguments[2], Integer.parseInt(arguments[3]));
                userService.create(dto);
                System.out.println("User has been created successfully");
            } else if ("UL".equals(arguments[0])) {
                System.out.println("List of users:");
                System.out.println(userService.findAll());
            } else if ("PC".equals(arguments[0])) {
                ProductDto dto = new ProductDto(
                        arguments[1],
                        new BigDecimal(arguments[2]),
                        Product.Category.valueOf(arguments[3]),
                        Product.Gender.valueOf(arguments[4]),
                        Product.Color.valueOf(arguments[5]),
                        Product.Size.valueOf(arguments[6]),
                        Integer.parseInt(arguments[7]));
                productService.create(dto);
                System.out.println("Product has been created successfully");
            } else if ("PL".equals(arguments[0])) {
                System.out.println("List of products:");
                System.out.println(productService.findAll());
            }
        }
    }
}
