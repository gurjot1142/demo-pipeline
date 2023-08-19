package com.example.demoPipeline.unit.service;

import com.example.demoPipeline.entity.User;
import com.example.demoPipeline.repo.UserRepo;
import com.example.demoPipeline.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = AutoConfigureMockMvc.class)
@WebMvcTest(UserService.class)
public class UserServiceTest {
   @Mock
   private UserRepo userRepo;

   @InjectMocks
   private UserService userService;

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User user = createUser(userId, "Gurjot");
        when(userRepo.findById(userId)).thenReturn(Optional.of(user));
        User foundUser = userService.getUserById(userId);
        assertEquals(user, foundUser);
        assertEquals(1L, foundUser.getId());
        assertEquals("Gurjot", foundUser.getUsername());
    }

    @Test
    void addUser() {
        Long userId = 1L;
        User user = createUser(userId, "Gurjot");
        when(userRepo.save(user)).thenReturn(user);
        User newUser = userService.addUser(user);
        assertNotNull(newUser);
        assertEquals(newUser, user);
        assertEquals("Gurjot", newUser.getUsername());
    }

    private User createUser(Long id, String name) {
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        return user;
    }
}
