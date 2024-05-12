package model;

import enummeration.TypeUser;

public class Manager extends Customer {
    public Manager(String name, String password, int age, Address address) {
        super(name, password, age, address);
        setTypeUser(TypeUser.MANAGER);
    }
}
