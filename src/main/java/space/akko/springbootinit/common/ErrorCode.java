package space.akko.springbootinit.common;

/**
 * 自定义错误码
 */
public enum ErrorCode {

    // 一切 OK
    SUCCESS(20000, "ok"),

    // 用户端错误 - 一级宏观错误码
    CLIENT_ERROR(10001, "用户端异常"),

    // 用户注册错误 - 二级宏观错误码
    REGISTER_ERROR(10100, "用户注册异常"),

    // 用户登录错误 - 二级宏观错误码
    LOGIN_ERROR(10200, "用户登录异常"),

    // 用户账户不存在
    NOT_EXIST(10201, "用户账户不存在"),

    // 用户账户被冻结
    ACCOUNT_FROZEN(10202, "用户账户被冻结"),

    // 用户账户已作废
    ACCOUNT_INVALID(10203, "用户账户已作废"),

    // 用户密码错误
    PASSWORD_ERROR(10204, "用户密码错误"),

    // 用户输入密码错误次数超限
    ACCOUNT_PASSWORD_ERROR_LIMIT(10205, "用户输入密码错误次数超限"),

    // 用户登录已过期
    LOGIN_EXPIRED(10230, "用户登录已过期"),

    // 用户未登录
    NOT_LOGIN(10231, "用户未登录"),

    // 用户验证码错误
    VERIFY_ERROR(10240, "用户验证码错误"),

    // 用户验证码尝试次数超限
    VERIFY_ERROR_LIMIT(10241, "用户验证码尝试次数超限"),

    // 访问权限异常 - 二级宏观错误码
    PERMISSION_ERROR(10300, "访问权限异常"),

    // 访问未授权
    NO_AUTH_ERROR(10301, "访问未授权"),

    // 访问无权限
    NO_PERMISSION_ERROR(10302, "访问无权限"),

    // 访问权限不足
    PERMISSION_DENIED_ERROR(10303, "访问权限不足"),

    // 用户请求参数错误 - 二级宏观错误码
    PARAMS_ERROR(10400, "用户请求参数异常"),

    // 请求参数为空
    PARAMS_IS_NULL(10401, "请求参数为空"),

    // 请求数据不存在
    NOT_FOUND_ERROR(10404, "请求数据不存在"),

    // 用户请求服务异常 - 二级宏观错误码
    SERVICE_ERROR(10500, "用户请求服务异常"),

    // 系统执行出错 - 一级宏观错误码
    SYSTEM_ERROR(20001, "系统内部异常"),

    // 系统执行超时 - 二级宏观错误码
    TIMEOUT_ERROR(20100, "系统执行超时"),

    // 系统执行失败 - 二级宏观错误码
    OPERATION_ERROR(20200, "系统执行失败"),

    // 调用第三方服务出错 - 一级宏观错误码
    THIRD_PARTY_ERROR(30001, "调用第三方服务出错"),

    // 中间件服务出错 - 二级宏观错误码
    MIDDLEWARE_ERROR(30100, "中间件服务出错"),

    // 第三方系统执行超时 - 二级宏观错误码
    THIRD_PARTY_TIMEOUT_ERROR(30200, "第三方系统执行超时"),

    // 数据库服务出错 - 二级宏观错误码
    DATABASE_ERROR(30300, "数据库服务出错");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
