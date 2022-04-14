package io.recruitment.assessment.api.model;

import javax.persistence.*;
import java.util.Set;

/**
 * <p>Title       :   Product
 * <p>Description :
 */
@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true)
  private String code;

  private String description;

  private double price;

  private long stock;

  @OneToMany(mappedBy = "product")
  private Set<OrderedProducts> order;

  public Product() {
  }

  public Product(long id, String code, String description, double price, long stock, Set<OrderedProducts> order) {
    this.id = id;
    this.code = code;
    this.description = description;
    this.price = price;
    this.stock = stock;
    this.order = order;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String code) {
    this.description = code;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public long getStock() {
    return stock;
  }

  public void setStock(long stock) {
    this.stock = stock;
  }

  public Set<OrderedProducts> getOrder() {
    return order;
  }

  public void setOrder(Set<OrderedProducts> order) {
    this.order = order;
  }


}

