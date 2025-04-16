package com.mehmetberkan.exception;
import lombok.Getter;

@Getter
public class BudgetMateException extends RuntimeException {
    private ErrorType errorType;
    public BudgetMateException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

}
