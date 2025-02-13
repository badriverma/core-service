package com.core_service.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@Builder
public class UserRegistrationResDto {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String gender;
    private String address;
    private String password;
    private Date createdOn;
    private Date updatedOn;
}
