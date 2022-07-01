package ls.comm.handler;

import lombok.extern.slf4j.Slf4j;
import ls.comm.exceptions.AppException;
import ls.comm.vo.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author dlins
 */
@Slf4j
@RestControllerAdvice
public class GlobalHandler {

    /**
     * 业务异常处理
     *
     * @param e 业务异常
     * @return Response
     */
    @ExceptionHandler(AppException.class)
    @ResponseBody
    public Response appExceptionHandler(HttpServletResponse response, AppException e) {
        log.error(e.getMessage(), e);
        response.setStatus(500);
        Response rsp = new Response();
        rsp.setCode(e.getCode());
        rsp.setMessage(e.getMessage());
        return rsp;
    }

    /**
     * 业务异常处理
     *
     * @param e 业务异常
     * @return Response
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response exceptionHandler(HttpServletResponse response, Exception e) {
        log.error(e.getMessage(), e);
        response.setStatus(500);
        Response rsp = new Response();
        rsp.setCode("500");
        rsp.setMessage(e.getMessage());
        return rsp;
    }
}
