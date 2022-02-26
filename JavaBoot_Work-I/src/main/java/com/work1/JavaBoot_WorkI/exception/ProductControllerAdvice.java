package com.work1.JavaBoot_WorkI.exception;

import com.work1.JavaBoot_WorkI.response.ErrorMessageResponse;
import com.work1.JavaBoot_WorkI.response.ProductResponse;
import com.work1.JavaBoot_WorkI.response.UserResposnse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageResponse productNotFound(ProductNotFoundException e) {
        return new ErrorMessageResponse("002",String.format("ไม่พบสินค้า %s", e.getMessage()));
    }
}