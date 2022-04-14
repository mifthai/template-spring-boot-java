package io.recruitment.assessment.api.model;

public enum UserType {
  ADMIN,
  CUSTOMER,
  UNKNOWN;

  public UserType getUserType(int userType){
      switch (userType) {
        case 0: return ADMIN;
        case 1: return CUSTOMER;
        default: return UNKNOWN;
      }
  }
}
