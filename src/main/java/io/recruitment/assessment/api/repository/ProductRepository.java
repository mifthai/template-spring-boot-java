package io.recruitment.assessment.api.repository;

import io.recruitment.assessment.api.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Title       :   ProductRepository
 * <p>Description :
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    @Query("SELECT product FROM Product product WHERE product.description LIKE CONCAT('%',:searchText,'%')")
    List<Product> findAllByCodeContains(String searchText);

    Product findProductByCode(String code);
}

