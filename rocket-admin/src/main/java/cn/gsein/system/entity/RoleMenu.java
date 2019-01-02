package cn.gsein.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色菜单关系实体
 *
 * @author G.Seinfeld
 * @date 2019/1/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenu extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 菜单ID
     */
    private Integer menuId;
}
