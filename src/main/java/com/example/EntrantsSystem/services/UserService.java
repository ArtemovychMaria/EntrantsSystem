package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.domain.UserRole;
import com.example.EntrantsSystem.dto.UserDto;
import com.example.EntrantsSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private static final Set<UserRole> DEFAULT_USER_ROLES = Collections.singleton(UserRole.ROLE_USER);
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> readAll(){
        return userRepository.findAll();
    }

    public void save(UserDto userDto) {
        String encodePassword = passwordEncoder.encode(userDto.getPassword());
        User user=new User(userDto.getUsername(),userDto.getFirstName(),userDto.getLastName(),
                Integer.parseInt(userDto.getAge()),userDto.getGender(),userDto.getEmail(),encodePassword,DEFAULT_USER_ROLES);
        userRepository.saveAndFlush(user);
    }
}
