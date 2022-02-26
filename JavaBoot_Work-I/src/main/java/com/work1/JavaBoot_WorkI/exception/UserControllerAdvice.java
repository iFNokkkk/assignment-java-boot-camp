package com.work1.JavaBoot_WorkI.exception;

import com.work1.JavaBoot_WorkI.response.ErrorMessageResponse;
import com.work1.JavaBoot_WorkI.response.UserResposnse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageResponse userNotFound(UserNotFoundException e) {
        return new ErrorMessageResponse("001",String.format("ไม่พบ UserName [%s] นี้ในระบบ กรุณาทำการสมัครด้วย", e.getMessage()));
    }
}
