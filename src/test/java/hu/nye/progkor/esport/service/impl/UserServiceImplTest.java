package hu.nye.progkor.esport.service.impl;

import hu.nye.progkor.esport.model.Role;
import hu.nye.progkor.esport.model.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class UserServiceImplTest {

    private static final User USER_1 = new User("User", "testmail@email.com", "Password", Arrays.asList(new Role("ROLE_USER")));


    @Test
    void save() {
    }

    @Test
    void loadUserByUsername() {
    }
}