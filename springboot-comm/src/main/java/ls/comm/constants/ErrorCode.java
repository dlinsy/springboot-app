package ls.comm.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ls.comm.util.Assert;

/**
 * @author dlins
 */
@Getter

public enum ErrorCode implements BaseErrorCode {
    /**
     *
     */
    ENUM_VALUE_EXISTS("101000", Series.BIZ, "枚举值重复"),
    ENUM_NO_MATCH_CONSTANT("101001", Series.BIZ, "枚举值不包含%s"),
    ;
    private final String code;
    private final Series series;
    private final String text;

    ErrorCode(String code, Series series, String text) {
        this.code = code;
        this.series = series;
        this.text = text;
        BaseErrorCode.cache(this);
    }


    @Getter
    @RequiredArgsConstructor
    public enum Series {
        /**
         * 业务
         */
        BIZ(1),
        ;
        private final int value;

        public static Series valueOf(int statusCode) {
            Series series = resolve(statusCode);
            Assert.isNotNull(series, ENUM_NO_MATCH_CONSTANT, statusCode);
            return series;
        }

        public static Series resolve(int statusCode) {
            int seriesCode = statusCode / 100;
            for (Series series : values()) {
                if (series.value == seriesCode) {
                    return series;
                }
            }
            return null;
        }
    }
}
