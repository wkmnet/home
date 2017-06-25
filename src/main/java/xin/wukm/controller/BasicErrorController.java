/**
 * Create with IntelliJ IDEA
 * Project name : home
 * Package name : xin.wukm.controller
 * Author : Wukunmeng
 * User : wukm
 * Date : 17-6-25
 * Time : 下午5:21
 * ---------------------------------
 */
package xin.wukm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Create with IntelliJ IDEA
 * Project name : home
 * Package name : xin.wukm.controller
 * Author : Wukunmeng
 * User : wukm
 * Date : 17-6-25
 * Time : 下午5:21
 * ---------------------------------
 * To change this template use File | Settings | File and Code Templates.
 */
@RestController
public class BasicErrorController extends BaseController implements ErrorController {
    @Value("${error.path:/error}")
    String errorPath = "/error";

    private final ErrorAttributes errorAttributes;

    @Autowired
    public BasicErrorController(ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return errorPath;
    }

    @RequestMapping(value = {"${error.path:/error}", "/error"})
    @ResponseBody
    public Object error(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> body = getErrorAttributes(request, getTraceParameter(request));
        HttpStatus status = getStatus(request);
        response.setStatus(status.value());
        String msg = (String) body.get("message");
        List errors = (List) body.get("errors");
        if (errors != null && errors.size() > 0) {
            Object firstError = errors.get(0);
            if (firstError instanceof FieldError) {
                msg = ((FieldError) firstError).getDefaultMessage();
            }
        }
        return new ResponseEntity(body, status);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            } catch (Exception ex) {
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }
}
