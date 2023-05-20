package com.app.base.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ninak
 */
@Data
@AllArgsConstructor
public class ValidateException extends BusinessException {

    public ValidateException(String message) {
        super(10000, message);
    }
}
