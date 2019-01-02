package cn.gsein.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 权限实体类
 *
 * @author G.Seinfeld
 * @date 2019/1/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 标识字符串，如system:user:list
     */
    private String label;
    /**
     * 菜单ID
     */
    private Integer menuId;
    /**
     * 描述
     */
    private String description;
}
