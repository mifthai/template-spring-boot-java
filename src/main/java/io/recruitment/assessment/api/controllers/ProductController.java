package io.recruitment.assessment.api.controllers;

import io.recruitment.assessment.api.dto.ProductDTO;
import io.recruitment.assessment.api.model.Product;
import io.recruitment.assessment.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Title       :   ProductController
 * <p>Description :
 */
@RestController
@RequestMapping("/excercise/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping("/save")
  public @ResponseBody ProductDTO addProduct(@RequestBody ProductDTO product, @RequestParam(name = "userType") String userType){
     return productService.createProduct(product);
  }

  @GetMapping("/search")
  public @ResponseBody
  List<ProductDTO> searchProduct(@RequestParam(name = "searchText") String searchText){
    return productService.searchProduct(searchText);
  }
}

