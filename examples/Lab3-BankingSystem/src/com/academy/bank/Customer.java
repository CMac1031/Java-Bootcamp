package com.academy.bank;

public class Customer implements Printable {

    private String customerId;
    private String name;
    private String email;
    private String phone;


    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        if(customerID != null && !customerId.isBlank()){
            this.customerId = customerId;}
        else{ System.out.println("Invalid account number!"); }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isBlank()){this.name = name;}
        else{ System.out.println("Invalid name!"); }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null && !email.isBlank()){this.email = email;}
        else{ System.out.println("Invalid email!"); }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone != null && !phone.isBlank()&&(phone.length == 10){this.phone = phone;}
        else{ System.out.println("Invalid phone number!"); }

    }

    public void display() {
        System.out.printf(
                "Customer %s: %s, %s, %s%n",
                customerId,
                name,
                email,
                phone);
    }

    @Override
    public void printDetails() {
        display();
    }

}