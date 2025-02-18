package com.core_service.controller;

import com.core_service.dto.ApiResponse;
import com.core_service.dto.UserRegistrationReqDto;
import com.core_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
   @PostMapping("/create")
    public ApiResponse createNewUser(@RequestBody UserRegistrationReqDto userRegistrationReqDto){
       return  userService.createUser(userRegistrationReqDto);
    }

}
