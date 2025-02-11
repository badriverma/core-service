package com.core_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistrationResDto {
    private Long id;
    private String name;
    private String email;
    private String mobileNo;
    private String gender;
    private String address;
    private String password;
    public Date createdOn;
    public Date updatedOn;
}
