package cn.gsein.system.utils;

/**
 * 前后端交互的返回码
 *
 * @author G.Seinfeld
 * @date 2018/12/25
 */
public enum ReturnCode {
    /**
     * 请求返回码枚举列表
     */
    SUCCESS("200", "请求成功"),
    WRONG_PASSWORD("5001", "用户名或密码不正确"),
    NO_ACCOUNT("5002", "用户名或密码不正确"),
    LOCKED_ACCOUNT("5003", "账户已被锁定，请联系管理员"),
    USERNAME_EXISTED("5004", "用户名已存在"),
    EMPTY_USERNAME_OR_PASSWORD("5005", "用户名或密码为空"),
    WRONG_CAPTHA("5006", "图形验证码错误"),
    CAPTHA_GENERATION_ERROR("5007", "生成图形验证码失败"),
    NEED_NOT_TO_GENERATE_CAPTCHA("5008", "不需要生成图形验证码"),
    NOT_LOGGING_IN("5009", "用户未登录"),
    WRONG_OLD_PASSWORD("5010", "旧密码错误"),
    PASSWORD_UPDATE_FAIL("5097", "修改密码失败"),
    USER_SAVE_FAIL("5098", "保存用户失败"),
    AUTHENTICATION_FAIL("5099", "账户验证失败"),
    REQUEST_FAIL("5999", "请求失败");

    private String code;
    private String message;

    ReturnCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return message;
    }}
