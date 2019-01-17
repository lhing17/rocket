package cn.gsein.generator;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 用于生成实体类的Dao文件和Mapper文件，
 * 包含getById、update、save、deleteById方法
 *
 * @author G_Seinfeld
 * @date 2019/1/9
 */
public class MapperGenerator {
    /**
     * 实体类名
     */
    private static final String ENTITY_NAME = "ApiRecord";
    /**
     * 数据库表名
     */
    private static final String TABLE_NAME = "sys_api_record";
    /**
     * 实体类描述
     */
    private static final String ENTITY_DESCRIPTION = "API调用记录";
    /**
     * 作者
     */
    private static final String AUTHOR_NAME = "G_Seinfeld";
    /**
     * 实体所在路径
     */
    private static final String ENTITY_PATH = "cn.gsein.common.entity";
    /**
     * Dao层文件所在路径
     */
    private static final String DAO_PATH = "cn.gsein.common.mapper";
    /**
     * Mapper文件所在路径
     */
    private static final String MAPPER_PATH = "mapper";
    /**
     * 项目输出根路径
     */
    private static final String BASE_OUTPUT_PATH = "F:\\";

    /**
     * 生成Mapper.xml和对应的Dao接口文件
     */
    public static void generateMapperAndDao() throws ClassNotFoundException {
        Class<?> clazz = Class.forName(ENTITY_PATH + "." + ENTITY_NAME);
        Field[] fields = clazz.getDeclaredFields();
//                generateDao();
        generateMapper(fields);
    }

    /**
     * 驼峰转下划线
     *
     * @param source 源字符串
     * @return 转换后的字符串
     */
    private static String camelCaseToUnderline(String source) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = source.toCharArray();
        for (char c : chars) {
            if (c <= 'Z' && c >= 'A') {
                c = (char) (c + 32);
                stringBuilder.append("_");
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static void generateMapper(Field[] fields) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis" +
                ".org/dtd/mybatis-3-mapper.dtd\">\n");
        stringBuilder.append("<mapper namespace=\"").append(DAO_PATH).append(".").append(ENTITY_NAME).append("Dao" +
                "\">\n");

        stringBuilder.append("\t<sql id=\"baseGet\">\n");
        stringBuilder.append("\t\tselect ").append(getAllColumnNames(fields)).append(" from \n");
        stringBuilder.append("\t\t").append(TABLE_NAME).append("\n");
        stringBuilder.append("\t</sql>\n");

        stringBuilder.append("\t<select id=\"getById\" parameterType=\"string\" resultType=\"").append(capitalLowerCase(ENTITY_NAME)).append("\">\n");
        stringBuilder.append("\t\t<include refid=\"baseGet\"/>\n");
        stringBuilder.append("\t\twhere id = #{id}\n");
        stringBuilder.append("\t</select>\n");

        stringBuilder.append("\t<delete id=\"deleteById\" parameterType=\"string\">\n");
        stringBuilder.append("\t\tdelete from ").append(TABLE_NAME).append("\n");
        stringBuilder.append("\t\twhere id = #{id}\n");
        stringBuilder.append("\t</delete>\n");

        stringBuilder.append("\t<insert id=\"save\" parameterType=\"").append(capitalLowerCase(ENTITY_NAME)).append("\">\n");
        stringBuilder.append("\t\tinsert into ").append(TABLE_NAME).append("\n");
        stringBuilder.append("\t\t(").append(getAllColumnNames(fields)).append(")\n");
        stringBuilder.append("\t\tvalues\n");
        stringBuilder.append("\t\t(").append(getAllFieldNamesEl(fields)).append(")\n");
        stringBuilder.append("\t</insert>\n");

        stringBuilder.append("\t<update id=\"update\" parameterType=\"").append(capitalLowerCase(ENTITY_NAME)).append("\">\n");
        stringBuilder.append("\t\tupdate ").append(TABLE_NAME).append("\n");
        stringBuilder.append("\t\t<set>\n");
        for (Field field : fields) {
            if (("serialVersionUID".equals(field.getName())) || ("id".equals(field.getName()))){
                continue;
            }
            stringBuilder.append("\t\t\t<if test=\"").append(field.getName()).append(" != null");
            if (field.getType() == String.class){
                stringBuilder.append(" and ").append(field.getName()).append(" != ''");
            }
            stringBuilder.append("\">\n");
            stringBuilder.append("\t\t\t\t").append(camelCaseToUnderline(field.getName())).append(" = #{").append(field.getName()).append("},\n");
            stringBuilder.append("\t\t\t</if>\n");
        }
        stringBuilder.append("\t\t</set>\n");
        stringBuilder.append("\t\twhere id = #{id}\n");
        stringBuilder.append("\t</update>\n");


        stringBuilder.append("</mapper>\n");

        System.out.println(stringBuilder.toString());
    }

    /**
     * 生成dao文件
     */
    private static void generateDao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package ").append(DAO_PATH).append(";\n");
        stringBuilder.append("import ").append(ENTITY_PATH).append(".").append(ENTITY_NAME).append(";\n");
        stringBuilder.append("import org.springframework.stereotype.Repository;\n");
        stringBuilder.append("import cn.gsein.common.mapper.BaseMapper;\n");
        stringBuilder.append("\n");

        stringBuilder.append("/**\n");
        stringBuilder.append(" * ").append(ENTITY_DESCRIPTION).append("相关持久层\n");
        stringBuilder.append(" *\n");
        stringBuilder.append(" * @author ").append(AUTHOR_NAME).append("\n");
        stringBuilder.append(" * @date ").append(formatter.format(LocalDate.now())).append("\n");
        stringBuilder.append(" */\n");
        stringBuilder.append("@Repository\n");
        stringBuilder.append("public interface ").append(ENTITY_NAME).append("Mapper extends BaseMapper<").append(ENTITY_NAME).append("> {\n");
        stringBuilder.append("\n");


        stringBuilder.append("}\n");
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) throws ClassNotFoundException {
        generateMapperAndDao();
    }

    /**
     * 首字母小写
     *
     * @param source 源字符串
     * @return 首字母小写的字符串
     */
    private static String capitalLowerCase(String source) {
        if (StringUtils.isEmpty(source)) {
            return source;
        }
        return source.substring(0, 1).toLowerCase() + source.substring(1);
    }

    /**
     * 根据字段数组获取所有列名，默认字段和数据库表中的列是驼峰和下划线的关系
     *
     * @param fields 类的属性数组
     * @return 以逗号分隔的所有列名
     */
    private static String getAllColumnNames(Field[] fields) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : fields) {
            if (!"serialVersionUID".equals(field.getName())) {
                stringBuilder.append(camelCaseToUnderline(field.getName())).append(", ");
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    /**
     * 根据字段数组获取所有字段名的EL表达式
     *
     * @param fields 类的属性数组
     * @return 以逗号分隔的所有字段名的EL表达式
     */
    private static String getAllFieldNamesEl(Field[] fields) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : fields) {
            if (!"serialVersionUID".equals(field.getName())) {
                stringBuilder.append("#{").append(field.getName()).append("}, ");
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
