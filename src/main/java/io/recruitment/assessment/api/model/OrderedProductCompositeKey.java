package io.recruitment.assessment.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Title       :   OrderedProductCompositeKey
 * <p>Description :
 */
@Embeddable
public class OrderedProductCompositeKey implements Serializable {

  @Column(name = "product_id")
  private long productId;

  @Column(name = "order_id")
  private long orderId;

  public OrderedProductCompositeKey() {
  }

  public OrderedProductCompositeKey(long productId, long orderId) {
    this.productId = productId;
    this.orderId = orderId;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderedProductCompositeKey that = (OrderedProductCompositeKey) o;
    return productId == that.productId && orderId == that.orderId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, orderId);
  }
}

