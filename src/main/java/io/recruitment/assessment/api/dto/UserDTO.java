package io.recruitment.assessment.api.dto;

import io.recruitment.assessment.api.model.User;

/**
 * <p>Title       :   UserDTO
 * <p>Description :
 */
public class UserDTO {
  private String userName;

  private String password;

  private int userType;

  public UserDTO() {
  }

  public UserDTO(User user) {
    this.userName = user.getUserName();
    this.userType = user.getUserType();
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getUserType() {
    return userType;
  }

  public void setUserType(int userType) {
    this.userType = userType;
  }
}

