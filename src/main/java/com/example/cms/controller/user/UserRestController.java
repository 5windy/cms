package com.example.cms.controller.user;

import com.example.cms.domain.user.User;
import com.example.cms.domain.user.UserRequestDto;
import com.example.cms.domain.user.UserRepository;
import com.example.cms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/user")
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserRepository userRepository;
    private final UserService userService;

    // 요청 시 데이터 가져오기 1.
    @GetMapping("/search")
    public User getUserByUsername(@RequestParam String username) {
        User user = null;
        user = userRepository.findByUsername(username);
        return user;
    }

    // 요청 시 데이터 가져오기 2.
    @GetMapping("/search/{id}")
    public User getUserById(@PathVariable int id) {
        User user = null;
        user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 사용자입니다.")
        );
        return user;
    }

    // 요청 시 데이터 가져오기 3.
    @PostMapping("/search")
    public User getUserByUsernameAndPassword(@RequestBody UserRequestDto userRequestDto) {
        User user = null;
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();
        user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }

    @GetMapping("/list")
    public List<User> getUserAll() {
        return userRepository.findAll();
    }

    // C
    // POST /v1/user/join                   [X]

    // request 단에서
    // User 객체를 만들 수 있는 파라미터(유저 객체를 Body로)를 받아
    // 연동된 데이터 베이스에 Insert
    // JPA의 기구현된 인터페이스 메소드를 활용 : save()

    @PostMapping("/join")
    public User joinUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    // R
    // GET  /v1/user/list                   [X]
    // GET  /v1/user/search?username=       [X]
    // GET  /v1/user/search/{id}            [X]
    // POST /v1/user/search                 [X]

    // U
    // PUT  /v1/user/edit                   []
    // * 기존에 존재하는 User 객체를 수정한 후 -> save() 호출
    @PutMapping("/edit")
    public User editUser(@RequestBody UserRequestDto userRequestDto, @RequestParam String newPassword) {
        return userService.updateUser(userRequestDto, newPassword);
    }

    // D
    // DELETE   /v1/user/leave              []
    @DeleteMapping("/leave")
    public void leaveUser(@RequestBody UserRequestDto userRequestDto) {
       userService.deleteUser(userRequestDto);
    }

}
