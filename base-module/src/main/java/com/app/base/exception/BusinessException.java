package com.app.base.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.Environment;

import javax.annotation.Resource;

/**
 * @author ninaklaus
 */
@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException{

    private Integer code;

    private String msg;


    public BusinessException() {
    }

}
