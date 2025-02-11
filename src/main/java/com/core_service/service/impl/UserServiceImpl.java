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

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Override
    public ApiResponse createUser(UserRegistrationReqDto userRegistrationReqDto) {
        try{

            User user = userMapper.DtoToEntity(userRegistrationReqDto);

            User savedUser = userRepository.saveAndFlush(user);
            UserRegistrationReqDto userDto = userMapper.entityToDto(savedUser);

            UserRegistrationResDto response = UserRegistrationResDto.builder().id(userDto.getId()).name(savedUser.getName())
                    .email(userDto.getEmail()).mobileNo(userDto.getMobileNo())
                    .address(userDto.getAddress()).gender(userDto.getGender())
                    .password(userDto.getPassword()).createdOn(userDto.getCreatedOn())
                    .updatedOn(userDto.getUpdatedOn()).build();

            return ApiResponse.builder().statusCode(HttpStatus.CREATED)
                    .message("User Created Successfully").data(response).build();

        }catch (Exception exception){
            return ApiResponse.builder().statusCode(HttpStatus.BAD_REQUEST)
                    .message("Invalid User").build();
        }
    }
}
