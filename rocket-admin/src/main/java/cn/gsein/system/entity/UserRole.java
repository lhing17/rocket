package cn.gsein.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户角色关系实体
 *
 * @author G.Seinfeld
 * @date 2019/1/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 角色ID
     */
    private Integer roleId;
}
