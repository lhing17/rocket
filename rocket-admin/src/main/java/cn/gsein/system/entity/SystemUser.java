package cn.gsein.system.entity;

import lombok.*;

import java.io.Serializable;

/**
 * 系统用户实体类
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
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
     * 密码加密的盐
     */
    private String salt;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别 0-女 1-男
     */
    private Integer gender;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 用户状态 0-正常使用 1-锁定
     */
    private Integer status;
}
