package io.recruitment.assessment.api.repository;

import io.recruitment.assessment.api.model.*;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>Title       :   OrderedProductsRepository
 * <p>Description :
 */
public interface OrderedProductsRepository extends CrudRepository<OrderedProducts, OrderedProductCompositeKey> {
}

