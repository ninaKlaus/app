package com.app.gatewaymodule.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ninak
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String id;

    private String name;

    private String password;
}
