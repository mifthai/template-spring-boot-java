package io.recruitment.assessment.api.model;

import javax.persistence.*;
import java.util.Set;

/**
 * <p>Title       :   Order
 * <p>Description :
 */
@Entity
public class DeliveryOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToMany(mappedBy = "deliveryOrder")
  private Set<OrderedProducts> productsSet;

  private String deliveryAddress;

  private int status;

  @ManyToOne
  @JoinColumn(name="user_id", nullable=false)
  private User user;

  public DeliveryOrder() {
  }

  public DeliveryOrder(long id, Set<OrderedProducts> productsSet, String deliveryAddress, byte status) {
    this.id = id;
    this.productsSet = productsSet;
    this.deliveryAddress = deliveryAddress;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Set<OrderedProducts> getProductsSet() {
    return productsSet;
  }

  public void setProductsSet(Set<OrderedProducts> productsSet) {
    this.productsSet = productsSet;
  }

  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}

