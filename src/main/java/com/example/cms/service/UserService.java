package com.example.cms.service;

import com.example.cms.domain.user.User;
import com.example.cms.domain.user.UserRepository;
import com.example.cms.domain.user.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // C
    @Transactional
    public User createUser(UserRequestDto userRequestDto) {
        User user = new User(userRequestDto);
        return userRepository.save(user);
    }

    // U
    @Transactional
    public User updateUser(UserRequestDto userRequestDto, String newPassword) {
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();

        User user = userRepository.findByUsernameAndPassword(username, password);
        userRequestDto.setPassword(newPassword);
        user.update(userRequestDto);
        // userRepository.save(user);

        return user;
    }

    // D
    @Transactional
    public void deleteUser(UserRequestDto userRequestDto) {
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();

        User user = userRepository.findByUsernameAndPassword(username, password);
        int id = user.getId();
        System.out.println("delete id : " + id);

        userRepository.deleteById(id);
    }


}
