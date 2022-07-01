package ls.comm.constants;

import ls.comm.Option;
import ls.comm.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dlins
 */
public interface BaseErrorCode extends Option<String, String> {
    Map<String, BaseErrorCode> CACHE = new HashMap<>();

    /**
     * 放入缓存
     *
     * @param appErrorCode AppErrorCode
     */
    static void cache(BaseErrorCode appErrorCode) {
        String key = appErrorCode.getCode();
        Assert.isFalse(CACHE.containsKey(key), ErrorCode.ENUM_VALUE_EXISTS);
        CACHE.put(key, appErrorCode);
    }

    /**
     * Message
     *
     * @param code String
     * @return Message
     */
    static String getMessage(String code) {
        BaseErrorCode errorCode = CACHE.get(code);
        return errorCode == null ? null : errorCode.getText();
    }

    /**
     * Message
     *
     * @return Message
     */
    default String getMessage() {
        return getText();
    }
}
