package io.recruitment.assessment.api.controllers;

import io.recruitment.assessment.api.dto.UserDTO;
import io.recruitment.assessment.api.model.UserType;
import io.recruitment.assessment.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Title       :   UserConroller
 * <p>Description :
 */
@RestController
@RequestMapping("/excercise/user")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/save")
  public @ResponseBody
  UserDTO addUser(@RequestBody UserDTO user, @RequestParam(name = "userType") String userType){
    return userService.createUser(user.getUserName(), user.getPassword(), UserType.getUserType(user.getUserType()));
  }
}

