package com.example.cms.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
public class UserRequestDto {
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String country;
    private Date birth;
    private int gender;
}
