package model;

import enummeration.TypeUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Setter
@Getter
@NoArgsConstructor
public class Customer {
    public final static List<Customer> CUSTOMERS = new ArrayList<>();

    private Long id;
    private String name;
    private String password;
    private Integer age;
    private Address address;
    private Account account;
    private TypeUser typeUser;

    public Customer(String name, String password, Integer age, Address address) {
        this.id = new Random().nextLong(1000000000L);
        this.name = name;
        this.password = password;
        this.age = age;
        this.address = address;
        this.typeUser = TypeUser.CUSTOMER;
        CUSTOMERS.add(this);
    }


    @Override
    public String toString() {
        return  "\nId: " + id +
                "\nPassword: " + password +
                "\nName: " + name +
                "\nAge: " + age +
                "\n\nADDRESS " + address +
                "\n\nACCOUNT " + account +
                "\nTypeUser: " + typeUser;
    }
}
