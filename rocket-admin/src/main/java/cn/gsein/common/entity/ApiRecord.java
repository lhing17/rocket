package cn.gsein.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * API调用记录
 *
 * @author G_Seinfeld
 * @date 2019/1/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiRecord extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * API名称
     */
    private String name;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 返回结果
     */
    private String result;

}
