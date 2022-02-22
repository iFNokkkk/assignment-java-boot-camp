package com.work1.JavaBoot_WorkI.services;

import com.work1.JavaBoot_WorkI.entity.User;
import com.work1.JavaBoot_WorkI.exception.UserNotFoundException;
import com.work1.JavaBoot_WorkI.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("SuccessCase Input aaxxcc3, Result = ยินดีต้อนรันคุณ เทวทิณณ์ เทพประทาน")
    void successCase1() {
        //Arrange
        User user = new User();
        user.setId(5942);
        user.setUserName("aaxxcc3");
        user.setName("เทวทิณณ์");
        user.setLastName("เทพประทาน");
        when(userRepository.findByUserName("aaxxcc3")).thenReturn(Optional.of(user));
        //Act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        String result = userService.checkUsername("aaxxcc3");
        //Verify
        assertEquals("ยินดีต้อนรันคุณ เทวทิณณ์ เทพประทาน" , result);
    }

    @Test
    @DisplayName("FailedCase Input esx21aa, Result = ไม่พบ UserName [esx21aa] นี้ในระบบ กรุณาทำการสมัครด้วย")
    void failedCase(){
        //Act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        String result = "";
        try{
            result = userService.checkUsername("esx21aa");
        }catch (UserNotFoundException e){
            result = String.format("ไม่พบ UserName [%s] นี้ในระบบ กรุณาทำการสมัครด้วย", e.getMessage());
        }
        //Verify
        assertEquals("ไม่พบ UserName [esx21aa] นี้ในระบบ กรุณาทำการสมัครด้วย" , result);
    }
}