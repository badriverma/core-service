package com.core_service.util;
import com.core_service.dto.UserRegistrationReqDto;
import com.core_service.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserRegistrationReqDto entityToDto(User user) {
        return modelMapper.map(user, UserRegistrationReqDto.class);
    }

    public User DtoToEntity(UserRegistrationReqDto userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

}
