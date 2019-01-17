package cn.gsein.common.mapper;

import java.util.List;
import java.util.Map;

/**
 * Mapper的基础接口，所有Mapper接口必须继承自起接口
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
public interface BaseMapper<T> {
    /**
     * 保存实体
     *
     * @param t 实体对象
     * @return 保存成功返回1，否则返回0
     */
    int save(T t);

    /**
     * 更新实体，默认是根据ID修改，如果需要根据其他字段修改，请另外编写方法
     *
     * @param t 实体对象
     * @return 更新成功返回1，否则返回0
     */
    int update(T t);

    /**
     * 根据ID删除数据
     *
     * @param id 实体ID
     * @return 删除成功返回1，否则返回0
     */
    int deleteById(Integer id);

    /**
     * 根据ID获取实体
     *
     * @param id 实体ID
     * @return 实体
     */
    T getById(Integer id);

    /**
     * 根据查询条件获取实体列表
     *
     * @param conditions 查询条件
     * @return 实体列表
     */
    List<T> getByConditions(Map<String, Object> conditions);
}
