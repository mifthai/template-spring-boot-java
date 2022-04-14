package io.recruitment.assessment.api.model;

import javax.persistence.*;

/**
 * <p>Title       :   CustomerUser
 * <p>Description :
 */
public class CustomerUser extends User{
  public CustomerUser() {
  }

  public CustomerUser(long id, String userName, String password, byte userType) {
    super(id, userName, password, userType);
  }
}

