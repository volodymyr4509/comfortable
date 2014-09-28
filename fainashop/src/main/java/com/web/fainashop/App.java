package com.web.fainashop;

import com.web.fainashop.entity.Customer;
import com.web.fainashop.entity.Product;
import com.web.fainashop.entity.Review;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Begin main method!" );

        Customer customer1 = new Customer();
        customer1.setNickname("nickname1");
        customer1.setEmail("email1@gmail.com");

        Product product1 = new Product();
        product1.setDescription("description1");
        product1.setPrice(99.99);
        product1.setProductName("productname1");

        Product product2 = new Product();
        product2.setDescription("description2");
        product2.setPrice(199.99);
        product2.setProductName("productname2");

        Set<Product> products = new HashSet<Product>();
        products.add(product1);
        products.add(product2);

        Review review1 = new Review();
        review1.setRating(4);
        review1.setText("text of first review");
        review1.setTitle("title 1");
        review1.setCustomer(customer1);

        Set<Review> reviews = new HashSet<Review>();
        reviews.add(review1);

        customer1.setProducts(products);
        customer1.setReviews(reviews);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer1);
        session.getTransaction().commit();

    }
}
