package com.intern.ecom;

import com.intern.ecom.entity.user.User;
import com.intern.ecom.entity.user.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;
//@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    private User testUser;


    @Test
    void givenUser_whenFindById_thenReturnUser() {
        testUser = new User("1","1","123456",(short)0,Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(testUser);
        User savedUser = userRepository.findById(testUser.getUuidUser()).orElse(null);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUuidUser()).isEqualTo(testUser.getUuidUser());
        assertThat(savedUser.getPassword()).isEqualTo(testUser.getPassword());
    }

}
