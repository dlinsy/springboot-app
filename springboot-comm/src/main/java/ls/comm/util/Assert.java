package ls.comm.util;

import ls.comm.constants.BaseErrorCode;
import ls.comm.exceptions.AppException;

/**
 * @author dlins
 */
public class Assert {

    public static void isTrue(boolean cond, BaseErrorCode errorCode, Object... params) {
        if (!cond) {
            error(errorCode, params);
        }
    }

    public static void isFalse(boolean cond, BaseErrorCode errorCode, Object... params) {
        if (cond) {
            error(errorCode, params);
        }
    }

    public static void isEmpty(String str, BaseErrorCode errorCode, Object... params) {
        if (Strings.isNotEmpty(str)) {
            error(errorCode, params);
        }
    }

    public static void isNotEmpty(String str, BaseErrorCode errorCode, Object... params) {
        if (Strings.isEmpty(str)) {
            error(errorCode, params);
        }
    }

    public static void isBlank(String str, BaseErrorCode errorCode, Object... params) {
        if (Strings.isNotBlank(str)) {
            error(errorCode, params);
        }
    }

    public static void isNotBlank(String str, BaseErrorCode errorCode, Object... params) {
        if (Strings.isBlank(str)) {
            error(errorCode, params);
        }
    }

    public static void isNull(Object obj, BaseErrorCode errorCode, Object... params) {
        if (null != obj) {
            error(errorCode, params);
        }
    }

    public static void isNotNull(Object obj, BaseErrorCode errorCode, Object... params) {
        if (null == obj) {
            error(errorCode, params);
        }
    }

    public static void error(BaseErrorCode errorCode, Object... params) {
        if (Objects.isNotEmpty(params)) {
            throw new AppException(errorCode.getCode(), String.format(errorCode.getMessage(), params));
        } else {
            throw new AppException(errorCode);
        }
    }
}
