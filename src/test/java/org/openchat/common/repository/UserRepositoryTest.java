package org.openchat.common.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openchat.common.models.User;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest {

    private HashMap<String, User> map;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        userRepository = new UserRepository(map);
    }

    @Test
    void shouldFindTheUserWithGivenUsername() {
        User user = new User("id", "john", "password", "about");
        map.put(user.getUsername(), user);

        Optional<User> optionalUser = userRepository.find(user.getUsername());
        User actual = optionalUser.get();

        assertThat(actual.getUsername()).isEqualTo(user.getUsername());
        assertThat(actual.getPassword()).isEqualTo(user.getPassword());
        assertThat(actual.getAbout()).isEqualTo(user.getAbout());
    }

    @Test
    void shouldRegisterTheGivenUser() {
        String idOfNewUser = "550e8400-e29b-41d4-a716-446655440000";
        User expected = new User(idOfNewUser, "john", "password", "about");

        UUID uuid = userRepository.registerUser(expected);

        assertThat(uuid.toString()).isEqualTo(expected.getId());

        User user = userRepository.userMap.get(expected.getUsername());
        assertThat(user.getUsername()).isEqualTo(expected.getUsername());
        assertThat(user.getPassword()).isEqualTo(expected.getPassword());
        assertThat(user.getAbout()).isEqualTo(expected.getAbout());
        assertThat(user.getId()).isEqualTo(expected.getId());
    }
}
