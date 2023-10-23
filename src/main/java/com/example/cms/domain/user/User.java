package com.example.cms.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String country;
    private Date birth;
    private int gender;

    public User(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();
        this.password = userRequestDto.getPassword();
        this.name = userRequestDto.getName();
        this.email = userRequestDto.getEmail();
        this.phone = userRequestDto.getPhone();
        this.country = userRequestDto.getCountry();
        this.birth = userRequestDto.getBirth();
        this.gender = userRequestDto.getGender();
    }

    public void update(UserRequestDto userRequestDto) {
        this.password = userRequestDto.getPassword();
//        this.email = userRequestDto.getEmail() != null ? userRequestDto.getEmail() : this.email;
//        this.phone = userRequestDto.getPhone() != null ? userRequestDto.getPhone() : this.phone;
//        this.country = userRequestDto.getCountry() != null ? userRequestDto.getCountry() : this.country;
    }

    @Override
    public String toString() {
        return String.format("%d) %s/%s %s/%s/%s/%d/%s/%s", id, username, password, email, name, birth, gender, country, phone);
    }
}
