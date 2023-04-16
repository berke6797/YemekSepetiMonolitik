package com.bilgeadam.yemeksepetimonolotik.exception;

import lombok.Getter;

@Getter
public class YemekSepetiExceptionManager extends RuntimeException{
private final ErrorType errorType;

    public YemekSepetiExceptionManager(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }
    public YemekSepetiExceptionManager(ErrorType errorType){
        this.errorType=errorType;
    }
}
