package io.recruitment.assessment.api.repository;

import io.recruitment.assessment.api.model.DeliveryOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Title       :   OrderRepository
 * <p>Description :
 */
@Repository
public interface OrderRepository extends CrudRepository<DeliveryOrder, Long> {
}

