package com.app.base.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ninaklaus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Response<T> success(T object) {
        return new Response<>(0, "成功", object);
    }

    public static <T> Response<T> success() {
        return success(null);
    }

    public static <T> Response<T> error(Integer code, String msg) {
        return new Response<>(code, msg, null);
    }
}
