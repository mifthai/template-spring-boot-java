package io.recruitment.assessment.api.model;

import javax.persistence.*;

/**
 * <p>Title       :   User
 * <p>Description :
 */
@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true)
  private String userName;

  private String password;

  private int userType;

  //private UserPrevilage [] userPrevilages;


  public User() {
  }

  public User(long id, String userName, String password, int userType) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.userType = userType;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
