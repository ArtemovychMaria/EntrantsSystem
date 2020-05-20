package com.example.EntrantsSystem.services;

import com.example.EntrantsSystem.domain.User;
import com.example.EntrantsSystem.domain.UserRole;
import com.example.EntrantsSystem.dto.UserDto;
import com.example.EntrantsSystem.repositories.UserRepository;
import com.example.EntrantsSystem.services.EmailSendingService;
import com.example.EntrantsSystem.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private static final Set<UserRole> DEFAULT_USER_ROLES = Collections.singleton(UserRole.ROLE_USER);

    private static final String CONFIRM_HASH = "ewgf34-fg53y4-fg354h";
    private static final int USER_ID = 2;
    public static final String USER_PASSWORD = "12345";
    private static final String USER_PASSWORD_ENCODED = "pass-encoded";
    public static final String USER_EMAIL = "test@email.com";
    public static final String FIRST_NAME = "Foo";
    public static final String LAST_NAME = "Bar";
    public static final String USERNAME = "supername";
    public static final String USER_AGE = "22";
    public static final String USER_GENDER = "male";
    public static final String USER_PHOTO_ID = "hdgf4-sdhgf5-dghf6-64gfdfg";

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private EmailSendingService emailSendingService;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService(userRepository, passwordEncoder, emailSendingService);
    }


    @Test
    public void itCanConfirmEmail() {
        User user = new User();
        user.setId(USER_ID);

        when(userRepository.findByVerifyEmailHash(CONFIRM_HASH))
                .thenReturn(Optional.of(user));

        userService.confirmEmail(CONFIRM_HASH);

        verify(userRepository).findByVerifyEmailHash(CONFIRM_HASH);
        verify(userRepository).confirmEmail(USER_ID);
    }

    @Test
    public void itCanConfirmEmailWhenUserNotFound() {
        when(userRepository.findByVerifyEmailHash(CONFIRM_HASH))
                .thenReturn(Optional.empty());

        userService.confirmEmail(CONFIRM_HASH);

        verify(userRepository).findByVerifyEmailHash(CONFIRM_HASH);
        verify(userRepository, times(0)).confirmEmail(anyInt());
    }


    @Test
    public void itCanRegisterUser() {
        UserDto userDto = new UserDto();
        userDto.setEmail(USER_EMAIL);
        userDto.setFirstName(FIRST_NAME);
        userDto.setLastName(LAST_NAME);
        userDto.setPassword(USER_PASSWORD);
        userDto.setUsername(USERNAME);
        userDto.setAge(USER_AGE);
        userDto.setGender(USER_GENDER);
        userDto.setPhotoId(USER_PHOTO_ID);

        when(passwordEncoder.encode(USER_PASSWORD))
                .thenReturn(USER_PASSWORD_ENCODED);

        userService.save(userDto);

        User expectedUser = new User(USERNAME,FIRST_NAME, LAST_NAME,Integer.parseInt(USER_AGE),USER_GENDER,
                USER_EMAIL,USER_PASSWORD_ENCODED,DEFAULT_USER_ROLES);
        expectedUser.setEmailVerified(false);
        expectedUser.setPhotoId(USER_PHOTO_ID);
        expectedUser.setVerifyEmailHash("hash");

        verify(userRepository).saveAndFlush(userCaptor.capture());

        assertThat(userCaptor.getValue())
                .isEqualToIgnoringGivenFields(expectedUser, "verifyEmailHash");

        verify(emailSendingService).sendVerificationEmail(eq(USER_EMAIL), anyString());
    }


}
