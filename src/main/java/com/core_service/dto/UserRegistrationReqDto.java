package com.core_service.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class UserRegistrationReqDto {

    private Long id;

    @NotEmpty(message = "First Name is Mandatory")
    private String firstName;

    private String middleName;

    @NotEmpty(message = "Last Name is Mandatory")
    private String lastName;

    @Email(message = "Email is Mandatory")
    private String email;

    @NotEmpty(message = "Mobile No is Mandatory")
    @Size(min = 10,max = 10)
    private String mobileNo;

    private String gender;

    private String address;

    @NotEmpty(message = "Password is Mandatory")
    private String password;

    private Date createdOn;
    private Date updatedOn;
}
