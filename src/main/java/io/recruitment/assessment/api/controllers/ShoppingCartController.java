package io.recruitment.assessment.api.controllers;

import io.recruitment.assessment.api.dto.ShoppingItemDTO;
import io.recruitment.assessment.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Title       :   ShopingCartController
 * <p>Description :
 */
@RestController
@RequestMapping("/excercise/cart")
public class ShoppingCartController {

  @Autowired
  private OrderService orderService;

  @PostMapping("/addItemToCart")
  public @ResponseBody
  List<ShoppingItemDTO> addItem(@RequestBody ShoppingItemDTO addedItem, @RequestParam(name = "userCode") String userCode){
      return orderService.addShoppingItem(addedItem, userCode);
  }

  @PostMapping("/removeItemFromCart")
  public @ResponseBody
  List<ShoppingItemDTO> removeItem(@RequestBody ShoppingItemDTO removedItem){
    return orderService.removeShoppingItem(removedItem);
  }
}

