package io.recruitment.assessment.api.model;

import javax.persistence.*;

/**
 * <p>Title       :   AdminUser
 * <p>Description :
 */

public class AdminUser extends User{
  public AdminUser() {
  }

  public AdminUser(long id, String userName, String password, byte userType) {
    super(id, userName, password, userType);
  }
}

