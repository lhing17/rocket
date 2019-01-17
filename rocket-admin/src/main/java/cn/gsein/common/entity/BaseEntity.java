package cn.gsein.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * 所有实体类的父类，实体类均应继承自该类
 *
 * @author G.Seinfeld
 * @date 2018/12/29
 */
@Data
public class BaseEntity {
    /**
     * 软删除字段 0-未删除 1-已删除
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;
}
