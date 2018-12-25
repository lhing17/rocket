package cn.gsein.system.entity;

import cn.gsein.system.utils.ReturnCode;
import lombok.Data;

/**
 * 前后端交互的JSON数据
 *
 * @author G.Seinfeld
 * @date 2018/12/25
 */
@Data
public class JsonResult {
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    private JsonResult(ReturnCode returnCode, Object data) {
        this.code = returnCode.getCode();
        this.message = returnCode.getMessage();
        this.data = data;
    }

    private JsonResult(ReturnCode returnCode) {
        this(returnCode, null);
    }

    /**
     * 请求成功时的返回结果
     *
     * @param data 请求成功的返回数据
     * @return 封装的json结果
     */
    public static JsonResult ok(Object data) {
        return new JsonResult(ReturnCode.SUCCESS, data);
    }

    /**
     * 请求成功且无返回数据时的返回结果
     *
     * @return 封装的json结果
     */
    public static JsonResult ok() {
        return ok(null);
    }

    /**
     * 请求失败时的返回结果
     *
     * @param returnCode 请求返回码的枚举值
     * @return 封装的json结果
     */
    public static JsonResult error(ReturnCode returnCode) {
        return new JsonResult(returnCode);
    }

}
