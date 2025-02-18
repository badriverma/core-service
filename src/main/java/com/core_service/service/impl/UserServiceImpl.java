package com.core_service.service.impl;

import com.core_service.dto.ApiResponse;
import com.core_service.dto.UserRegistrationReqDto;
import com.core_service.dto.UserRegistrationResDto;
import com.core_service.entity.User;
import com.core_service.repository.UserRepository;
import com.core_service.service.UserService;
import com.core_service.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ApiResponse createUser(UserRegistrationReqDto reqDto) {
        try{

            User user = User.builder()
                    .firstName(reqDto.getFirstName()).middleName(reqDto.getMiddleName())
                    .lastName(reqDto.getLastName()).email(reqDto.getEmail())
                    .mobileNo(reqDto.getMobileNo()).address(reqDto.getAddress())
                    .gender(reqDto.getGender()).password(passwordEncoder.encode(reqDto.getPassword()))
                    .createdOn(reqDto.getCreatedOn()).updatedOn(reqDto.getUpdatedOn())
                    .build();

            User savedUser = userRepository.saveAndFlush(user);

            UserRegistrationResDto response = UserRegistrationResDto
                    .builder().id(savedUser.getId()).firstName(savedUser.getFirstName())
                    .middleName(savedUser.getMiddleName()).lastName(savedUser.getLastName())
                    .email(savedUser.getEmail()).mobileNo(savedUser.getMobileNo())
                    .address(savedUser.getAddress()).gender(savedUser.getGender())
                    .password(savedUser.getPassword()).createdOn(savedUser.getCreatedOn())
                    .updatedOn(savedUser.getUpdatedOn()).build();

            return ApiResponse.builder().statusCode(HttpStatus.CREATED)
                    .message("User Created Successfully").data(response).build();

        }catch (Exception exception){
            return ApiResponse.builder().statusCode(HttpStatus.BAD_REQUEST)
                    .message("Invalid User").build();
        }
    }
}
