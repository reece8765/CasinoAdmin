package model;

import static java.lang.Double.parseDouble;

public class User {

    private String id;
    private String name;
    private int phone;
    private String address;
    private String password;
    private double balance;
    private boolean active;

    public int getActive() {
        if (active) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setActive(int status) {
        this.active = (status == 1);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(String input) {
        try {
            double set = parseDouble(input);
            this.balance = set;
        } catch (NumberFormatException e) {
            this.balance = 0.0;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        int phoneStart = this.phone;
        return phoneStart;
    }

    public void setPhone(String input) {
        try {
            this.phone = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            this.phone = 0;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getPassword() {
        return this.password;
    }

}
