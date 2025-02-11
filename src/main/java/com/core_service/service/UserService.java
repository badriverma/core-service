package com.core_service.service;

import com.core_service.dto.ApiResponse;
import com.core_service.dto.UserRegistrationReqDto;

public interface UserService {
    ApiResponse createUser(UserRegistrationReqDto userRegistrationReqDto);
}
