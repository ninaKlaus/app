package com.app.usermodule.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ninak
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别，0：未知，1：男，2：女
     */
    private int gender;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 地址
     */
    private String address;

    /**
     * 状态，0：禁用，1：启用
     */
    private int status;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 用户来源，如：微信、QQ等
     */
    private String source;

    /**
     * 用户来源ID
     */
    private String sourceId;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;
}
