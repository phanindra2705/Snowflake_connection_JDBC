package com.testSnowflake.snowflake.service;

import com.testSnowflake.snowflake.model.User;
import com.testSnowflake.snowflake.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        Long nextId = getNextUserId(); // Fetch the next ID
        user.setId(nextId);
        return userRepository.save(user);
    }

    private Long getNextUserId() {
        return jdbcTemplate.queryForObject("SELECT user_sequence.NEXTVAL", Long.class);

    }

    public User updateUser(long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
