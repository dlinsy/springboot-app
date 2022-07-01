package ls.comm.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ls.comm.constants.BaseErrorCode;

/**
 * @author dlins
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AppException extends RuntimeException {
    private static final String ERR_500 = "500";
    private final String code;
    private final String message;

    public AppException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public AppException(BaseErrorCode appErrorCode) {
        this.code = appErrorCode.getCode();
        this.message = appErrorCode.getText();
    }

    public AppException(BaseErrorCode appErrorCode, Throwable cause) {
        super(appErrorCode.getText(), cause);
        this.code = appErrorCode.getCode();
        this.message = appErrorCode.getText();
    }

    protected AppException(BaseErrorCode appErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(appErrorCode.getText(), cause, enableSuppression, writableStackTrace);
        this.code = appErrorCode.getCode();
        this.message = appErrorCode.getText();
    }
}
