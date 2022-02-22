package com.work1.JavaBoot_WorkI.login;

import com.work1.JavaBoot_WorkI.response.UserResposnse;
import com.work1.JavaBoot_WorkI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{userName}")
    public UserResposnse login(@PathVariable String userName){
        return new UserResposnse(userService.checkUsername(userName));
    }
}
