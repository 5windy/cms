package com.example.cms.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);


}
