package io.recruitment.assessment.api.service;

import io.recruitment.assessment.api.dto.*;
import io.recruitment.assessment.api.model.*;
import io.recruitment.assessment.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * <p>Title       :   OrderService
 * <p>Description :
 */
@Service
@Transactional
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private OrderedProductsRepository orderedProductsRepository;

  @Autowired
  private UserRepository userRepository;

  public List<ShoppingItemDTO> addShoppingItem(ShoppingItemDTO shoppingItemDTO, String userCode){
    DeliveryOrder deliveryOrder = null;
    List<ShoppingItemDTO> out = new ArrayList<>();
    User user = userRepository.findByUserName(userCode);
    if (shoppingItemDTO.getOrderId() > 0){
      Optional<DeliveryOrder> orderOpt = orderRepository.findById(shoppingItemDTO.getOrderId());
      if( orderOpt.isPresent()) {
        deliveryOrder = orderOpt.get();
      }
    }
    else {
      deliveryOrder = new DeliveryOrder();
      deliveryOrder.setUser(user);
      deliveryOrder = orderRepository.save(deliveryOrder);
    }

    if(deliveryOrder != null) {
      Product product = productRepository.findProductByCode(shoppingItemDTO.getOrderedProduct().getProductCode());
      if (product != null && user != null) {
        Set<OrderedProducts> orderedProductsSet = deliveryOrder.getProductsSet();
        orderedProductsSet = orderedProductsSet != null ? orderedProductsSet: new HashSet<>();
        OrderedProductCompositeKey orderedProductCompositeKey  = new OrderedProductCompositeKey(product.getId(), deliveryOrder.getId());
        Optional<OrderedProducts> optProducts = orderedProductsSet.stream().filter(orderedProducts -> orderedProducts.getId().equals(orderedProductCompositeKey)).findAny();

        OrderedProducts orderedProduct;
        if (optProducts.isEmpty()) {
          orderedProduct = new OrderedProducts();
          orderedProduct.setId(orderedProductCompositeKey);
          orderedProduct.setProduct(product);
          orderedProduct.setDeliveryOrder(deliveryOrder);
        }
        else {
          orderedProduct = optProducts.get();
        }
        orderedProduct.setOrderQty(shoppingItemDTO.getOrderedProduct().getQuantity());
        orderedProduct.setUnitPrice(product.getPrice());

        // I am not sure, this is the correct way ??
        orderedProduct = orderedProductsRepository.save(orderedProduct);

        orderedProductsSet.add(orderedProduct);

        deliveryOrder.setProductsSet(orderedProductsSet);
        deliveryOrder.setUser(user);
        DeliveryOrder newDeliveryOrder = orderRepository.save(deliveryOrder);

        orderedProductsSet = newDeliveryOrder.getProductsSet();
        ShoppingItemDTO item;
        for (OrderedProducts orderedProducts:orderedProductsSet) {
          item = new ShoppingItemDTO();
          item.setOrderId(newDeliveryOrder.getId());
          item.setOrderedProduct(new OrderedProductDTO(orderedProducts.getProduct().getCode(), orderedProducts.getOrderQty()));
          out.add(item);
        }
      }
    }

    return out;
  }

  public List<ShoppingItemDTO> removeShoppingItem(ShoppingItemDTO shoppingItemDTO){
    DeliveryOrder deliveryOrder = null;
    List<ShoppingItemDTO> out = new ArrayList<>();
    if (shoppingItemDTO.getOrderId() > 0){
      Optional<DeliveryOrder> orderOpt = orderRepository.findById(shoppingItemDTO.getOrderId());
      if( orderOpt.isPresent()) {
        deliveryOrder = orderOpt.get();
      }
    }

    if(deliveryOrder != null) {
      Product product = productRepository.findProductByCode(shoppingItemDTO.getOrderedProduct().getProductCode());
      if (product != null) {
        Set<OrderedProducts> orderedProductsSet = deliveryOrder.getProductsSet();
        orderedProductsSet = orderedProductsSet != null ? orderedProductsSet: new HashSet<>();

        OrderedProducts orderedProduct = new OrderedProducts();
        orderedProduct.setProduct(product);
        orderedProduct.setDeliveryOrder(deliveryOrder);
        orderedProduct.setId(new OrderedProductCompositeKey(product.getId(), deliveryOrder.getId()));
        orderedProduct.setOrderQty(shoppingItemDTO.getOrderedProduct().getQuantity());
        orderedProduct.setUnitPrice(product.getPrice());
        // I am not sure, this is the correct way ??
        orderedProductsRepository.delete(orderedProduct);

        orderedProductsSet.removeIf(orderedProducts -> orderedProducts.getId().equals(orderedProduct.getId()));

        deliveryOrder.setProductsSet(orderedProductsSet);

        DeliveryOrder newDeliveryOrder = orderRepository.findById(shoppingItemDTO.getOrderId()).get();

        orderedProductsSet = newDeliveryOrder.getProductsSet();
        ShoppingItemDTO item;
        for (OrderedProducts orderedProducts:orderedProductsSet) {
          item = new ShoppingItemDTO();
          item.setOrderId(newDeliveryOrder.getId());
          item.setOrderedProduct(new OrderedProductDTO(orderedProducts.getProduct().getCode(), orderedProducts.getOrderQty()));
          out.add(item);
        }
      }
    }

    return out;
  }
}

