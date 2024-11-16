package com.app.usermodule.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

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
    @Id
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 测试提交密码
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
     * 用户来源，如：微信、QQ等
     */
    private String source;

    /**
     * 用户来源ID
     */
    private String sourceId;

    /**
     * 备注
     */
    private String remark;
    /**
     * 是否有效
     */
    private String isEnabled;
    /**
     * 是否删除
     */
    private String isDeleted;
    /**
     * 创建时间
     */
    private Date crtTime;

    /**
     * 创建用户Id
     */
    private Date crtUser;

    /**
     * 创建用户名称
     */
    private Date crtUserName;

    /**
     * 创建用户主机
     */
    private Date crtHost;

    /**
     * 最后更新时间
     */
    private Date updTime;

    /**
     * 最后用户Id
     */
    private Date updUser;

    /**
     * 最后用户名称
     */
    private Date updUserName;

    /**
     * 最后用户主机
     */
    private Date updHost;
}
