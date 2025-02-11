package com.core_service.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistrationReqDto {

    private Long id;

    @NotEmpty(message = "Name is Mandatory")
    private String name;

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
