package com.web.fainashop.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Home on 20.09.2014.
 */

@Entity
@Table(name = "faina_Customer")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String nickname;
    private String email;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "faina_CustomerToProduct", joinColumns = {@JoinColumn (name = "customer_id")},inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Set<Product> products;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Review> reviews;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (nickname != null ? !nickname.equals(customer.nickname) : customer.nickname != null) return false;
        if (products != null ? !products.equals(customer.products) : customer.products != null) return false;
        if (reviews != null ? !reviews.equals(customer.reviews) : customer.reviews != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + (reviews != null ? reviews.hashCode() : 0);
        return result;
    }
}
