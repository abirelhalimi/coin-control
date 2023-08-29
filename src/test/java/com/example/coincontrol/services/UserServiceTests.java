package com.example.coincontrol.services;

import com.example.coincontrol.models.User;
import com.example.coincontrol.repositories.UserRepository;
import com.example.coincontrol.services.Impl.UserServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void shouldCreateANewUser() {
        User expectedUser = new User();
        expectedUser.setEmail("usertest@gmail.com");
        expectedUser.setPassword("usertest");
        expectedUser.setUsername("usertest");

        when(userRepository.save(Mockito.any(User.class))).thenReturn(expectedUser);

        User createdUser = userService.add(expectedUser);

        assertNotNull(createdUser);
        assertEquals(expectedUser.getUsername(), createdUser.getUsername());
        assertEquals(expectedUser.getEmail(), createdUser.getEmail());
        assertEquals(expectedUser.getPassword(), createdUser.getPassword());
    }

    @Test
    public void shouldReturnTheUserGivenTheId() {
        Long id = 1L;
        User expectedUser = new User();
        expectedUser.setId(id);

        when(userRepository.findById(id)).thenReturn(Optional.of(expectedUser));

        User retrievedUser = userService.getById(id);

        assertEquals(expectedUser, retrievedUser);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldReturnNotFoundGivenAWrongId() {
        Long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.empty());
        userService.getById(id);
    }

    @Test
    public void shouldUpdateTheFieldsChangedInAUser() {

        Long id = 1L;
        User existingUser = new User();
        existingUser.setId(id);
        existingUser.setEmail("oldEmail");
        existingUser.setUsername("oldUsername");
        existingUser.setPassword("oldPassword");

        User updatedUser = new User();
        updatedUser.setEmail("newEmail");

        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(Mockito.any(User.class))).thenReturn(existingUser);

        User actual = userService.update(id, updatedUser);

        assertNotNull(actual);
        assertEquals(updatedUser.getEmail(), actual.getEmail());
        assertEquals(existingUser.getUsername(), actual.getUsername());

    }

    @Test
    public void shouldDeleteUserGivenId() {
        Long id = 1L;

        User user = new User();
        user.setId(id);

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        userService.delete(id);

        verify(userRepository, times(1)).delete(user);

    }

}
