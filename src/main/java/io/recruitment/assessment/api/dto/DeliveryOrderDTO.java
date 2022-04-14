package io.recruitment.assessment.api.dto;

import java.util.Set;

/**
 * <p>Title       :   OrderDTO
 * <p>Description :
 */
public class DeliveryOrderDTO {

  private long id;

  private Set<OrderedProductDTO> orderedProductDTOSet;

  private String deliveryAddress;

  private int status;
}

