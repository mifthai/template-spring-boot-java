package io.recruitment.assessment.api.dto;

import io.recruitment.assessment.api.model.Product;

/**
 * <p>Title       :   ProductDTO
 * <p>Description :
 */
public class ProductDTO {
  private long id;

  private String code;

  private String description;
  
  private double price;

  private long stock;

  public ProductDTO() {
  }

  public ProductDTO(long id, String code, String description, double price, long stock) {
    this.id = id;
    this.code = code;
    this.description = description;
    this.price = price;
    this.stock = stock;
  }

  public ProductDTO(Product product) {
    this.id = product.getId();
    this.description = product.getDescription();
    this.price = product.getPrice();
    this.stock = product.getStock();
    this.code = product.getCode();
  }

  public long getId() {
    return id;
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

  public void setDescription(String description) {
    this.description = description;
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


}

