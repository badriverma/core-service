package com.core_service.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First is Mandatory")
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

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
}
