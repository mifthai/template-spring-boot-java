package io.recruitment.assessment.api.dto;

/**
 * <p>Title       :   ShoppingItemDTO
 * <p>Description :
 */
public class ShoppingItemDTO {
  private long orderId;
  private OrderedProductDTO orderedProduct;

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public OrderedProductDTO getOrderedProduct() {
    return orderedProduct;
  }

  public void setOrderedProduct(OrderedProductDTO orderedProduct) {
    this.orderedProduct = orderedProduct;
  }
}

