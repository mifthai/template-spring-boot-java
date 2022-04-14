package io.recruitment.assessment.api.dto;

/**
 * <p>Title       :   ShoppingItemDTO
 * <p>Description :
 */
public class ShoppingItemDTO {
  private long orderId;
  private OrderedProductDTO orderedProductDTO;

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public OrderedProductDTO getOrderedProductDTO() {
    return orderedProductDTO;
  }

  public void setOrderedProductDTO(OrderedProductDTO orderedProductDTO) {
    this.orderedProductDTO = orderedProductDTO;
  }
}

