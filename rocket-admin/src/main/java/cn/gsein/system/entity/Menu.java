package cn.gsein.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 菜单实体类
 *
 * @author G.Seinfeld
 * @date 2019/1/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单地址
     */
    private String url;
    /**
     * 菜单图标 如fa fa-car
     */
    private String icon;
    /**
     * 菜单描述
     */
    private String description;
    /**
     * 父级菜单ID，没有则为null
     */
    private Integer pid;
    /**
     * 菜单是否可用 0-不可用 1-可用 默认值为1
     */
    private Integer enabled;
}
