package com.work1.JavaBoot_WorkI.exception;

public class ProductNotFoundException  extends RuntimeException {
    public ProductNotFoundException(String name) {
        super(name);
    }
}
