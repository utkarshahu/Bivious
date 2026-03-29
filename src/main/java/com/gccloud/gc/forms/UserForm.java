package com.gccloud.gc.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    
    private String name;

    
    private String email;

    
    private String password;

    private String about;

    
    private String phoneNumber;
}
