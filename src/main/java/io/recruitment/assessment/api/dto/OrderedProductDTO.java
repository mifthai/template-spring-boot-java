package io.recruitment.assessment.api.dto;

/**
 * <p>Title       :   OrderedProductDTO
 * <p>Description :
 */
public class OrderedProductDTO {
  private String productCode;
  private long quantity;

  public OrderedProductDTO(String productCode, long quantity) {
    this.productCode = productCode;
    this.quantity = quantity;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }
}

