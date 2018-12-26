package cn.gsein.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统用户实体类
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser {
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
