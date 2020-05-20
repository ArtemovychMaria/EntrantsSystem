package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.domain.UserRole;
import com.example.EntrantsSystem.dto.UserDto;
import com.example.EntrantsSystem.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private static final Logger Log= LoggerFactory.getLogger(UserService.class);

    private static final Set<UserRole> DEFAULT_USER_ROLES = Collections.singleton(UserRole.ROLE_USER);
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private final EmailSendingService emailSendingService;

    @Autowired
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder,
                       EmailSendingService emailSendingService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailSendingService = emailSendingService;
    }

    public List<User> readAll(){
        Log.info("Getting all users");
        return userRepository.findAll();
    }

    public void save(UserDto userDto) {
        String encodePassword = passwordEncoder.encode(userDto.getPassword());
        User user=new User(userDto.getUsername(),userDto.getFirstName(),userDto.getLastName(),
                Integer.parseInt(userDto.getAge()),userDto.getGender(),
                userDto.getEmail(),encodePassword,DEFAULT_USER_ROLES);

        user.setEmailVerified(false);
        UUID uuid = UUID.randomUUID();
        user.setVerifyEmailHash(uuid.toString());

        String photoId = userDto.getPhotoId();
        if(!photoId.isEmpty()) {
            user.setPhotoId(photoId);
        }

        userRepository.saveAndFlush(user);

        emailSendingService.sendVerificationEmail(userDto.getEmail(), uuid.toString());
    }

    public void confirmEmail(String hash) {
        userRepository.findByVerifyEmailHash(hash)
                .ifPresent(user -> userRepository.confirmEmail(user.getId()));
    }

    public Optional<User> readById(int id){
        return userRepository.findById(id);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
