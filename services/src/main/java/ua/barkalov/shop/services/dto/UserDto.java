package ua.barkalov.shop.services.dto;

import ua.barkalov.shop.DAO.model.Order;

import java.util.Set;

public class UserDto {

    private String firstName;
    private String lastName;
    private int age;
//    private Set<Order> orders;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, int age /*Set<Order> orders*/) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        /*this.orders = orders;*/
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//
//    public Set<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Order> orders) {
//        this.orders = orders;
//    }

    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
