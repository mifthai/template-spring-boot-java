package io.recruitment.assessment.api.model;

import javax.persistence.*;

/**
 * <p>Title       :   OrderedProducts
 * <p>Description :
 */
@Entity
public class OrderedProducts {

  @EmbeddedId
  private OrderedProductCompositeKey id;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = "order_id")
  private DeliveryOrder deliveryOrder;

  private long orderQty;

  private double unitPrice;

  public OrderedProductCompositeKey getId() {
    return id;
  }

  public void setId(OrderedProductCompositeKey id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public DeliveryOrder getDeliveryOrder() {
    return deliveryOrder;
  }

  public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
    this.deliveryOrder = deliveryOrder;
  }

  public long getOrderQty() {
    return orderQty;
  }

  public void setOrderQty(long orderQty) {
    this.orderQty = orderQty;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }
}

