package io.recruitment.assessment.api.service;

import io.recruitment.assessment.api.dto.ProductDTO;
import io.recruitment.assessment.api.model.Product;
import io.recruitment.assessment.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Title       :   ProductService
 * <p>Description :
 */
@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public ProductDTO saveProduct(ProductDTO productDTO){
     Product existingProduct = productRepository.findProductByCode(productDTO.getCode());
     if (existingProduct != null){
       return updateProduct(existingProduct, productDTO);
     }
     return createProduct(productDTO) ;
  }

  public ProductDTO createProduct(ProductDTO productDTO){
    Product product = new Product();
    product.setDescription(productDTO.getDescription());
    product.setPrice(productDTO.getPrice());
    product.setStock(productDTO.getStock());
    product.setCode(productDTO.getCode());
    Product createdProduct = productRepository.save(product);
    return new ProductDTO(createdProduct);
  }

  public ProductDTO updateProduct(Product product, ProductDTO productDTO){
    product.setDescription(productDTO.getDescription());
    product.setPrice(productDTO.getPrice());
    product.setStock(productDTO.getStock());
    Product createdProduct = productRepository.save(product);
    return new ProductDTO(createdProduct);
  }

  public List<ProductDTO> searchProduct(String searchText){
    List<Product> productsFound = productRepository.findAllByCodeContains(searchText);
    return productsFound.stream().map(ProductDTO::new).collect(Collectors.toList());
  }
}

