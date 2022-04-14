package io.recruitment.assessment.api.repository;

import io.recruitment.assessment.api.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>Title       :   UserRepository
 * <p>Description :
 */
public interface UserRepository extends CrudRepository<User, Long> {
  User findByUserName(String userName);
}

