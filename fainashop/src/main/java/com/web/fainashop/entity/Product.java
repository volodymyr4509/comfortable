package com.web.fainashop.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Home on 20.09.2014.
 */

@Entity
@Table(name = "faina_Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productName;
    private String description;
    private double price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "faina_CustomerToProduct", joinColumns = {@JoinColumn (name = "product_id")},inverseJoinColumns = {@JoinColumn(name = "customer_id")})
    private Set<Customer> customers;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (customers != null ? !customers.equals(product.customers) : product.customers != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (customers != null ? customers.hashCode() : 0);
        return result;
    }
}
