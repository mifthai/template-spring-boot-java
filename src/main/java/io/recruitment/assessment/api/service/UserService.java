package io.recruitment.assessment.api.service;

import io.recruitment.assessment.api.dto.UserDTO;
import io.recruitment.assessment.api.model.*;
import io.recruitment.assessment.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

/**
 * <p>Title       :   UserService
 * <p>Description :
 */
@Service
public class UserService {
  @Value("adminUser.userName")
  private String adminUser;
  @Value("adminUser.defaultPassword")
  private String defaultAdminPassword;

  @Autowired
  private UserRepository userRepository;

  public void createAdminUser(){
    createUser(adminUser, defaultAdminPassword, UserType.ADMIN);
  }

  public UserDTO createUser(String userName, String password, UserType userType){
    User user = userRepository.findByUserName(userName);
    if (user == null || user.getId() < 0){
      User userToCreate = new User();
      userToCreate.setUserName(userName);
      userToCreate.setPassword(password);
      userToCreate.setUserType(userType.ordinal());
      user = userRepository.save(userToCreate);
    }

    return new UserDTO(user);
  }
}

