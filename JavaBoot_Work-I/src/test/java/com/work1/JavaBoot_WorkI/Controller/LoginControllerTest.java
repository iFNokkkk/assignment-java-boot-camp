package com.work1.JavaBoot_WorkI.Controller;

import com.work1.JavaBoot_WorkI.entity.User;
import com.work1.JavaBoot_WorkI.repository.UserRepository;
import com.work1.JavaBoot_WorkI.response.ErrorMessageResponse;
import com.work1.JavaBoot_WorkI.response.UserResposnse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    //Mock Repository
    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("SuceeseeCase, Send UserName = ccxcxcc, Result = ยินดีต้อนรันคุณ วเรณย์ ประเสริฐสุด")
    void login() {
        //จำลอง Arrange
        User user = new User();
        user.setId(2222);
        user.setUserName("ccxcxcc");
        user.setName("วเรณย์");
        user.setLastName("ประเสริฐสุด");
        when(userRepository.findByUserName("ccxcxcc")).thenReturn(Optional.of(user));
        //Act
        UserResposnse result = testRestTemplate.getForObject("/login/ccxcxcc", UserResposnse.class);
        //Verify
        assertEquals("ยินดีต้อนรันคุณ วเรณย์ ประเสริฐสุด", result.getLoginMessage());
    }

    @Test
    @DisplayName("FailedCase,Send UserName = xxx3s21, Result = ไม่พบ UserName [xxx3s21] นี้ในระบบ กรุณาทำการสมัครด้วย")
    void sayhi2() {
        ErrorMessageResponse result = testRestTemplate.getForObject("/login/xxx3s21", ErrorMessageResponse.class);
        assertEquals("ไม่พบ UserName [xxx3s21] นี้ในระบบ กรุณาทำการสมัครด้วย", result.getErrorMessage());
    }
}