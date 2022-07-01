package ls.inas.controller;


import ls.comm.constants.ErrorCode;
import ls.comm.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @author dlins
 */
@RestController
@RequestMapping("/img")
public class ImageController {
    @CrossOrigin
    @GetMapping("/{id}")
    public String get(@PathVariable("id") String id) {
        Assert.error(ErrorCode.ENUM_VALUE_EXISTS);
        return "xxxx";
    }
}
