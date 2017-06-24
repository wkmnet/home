/**
 * 代码有编辑器 IntelliJ IDEA 完成
 * Project name : openshift
 * Package name : xin.wukm.controller
 * Author : Wukunmeng
 * User : wukm
 * Date : 17-6-18
 * Time : 下午3:09
 * -------------------------------
 */
package xin.wukm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码有编辑器 IntelliJ IDEA 完成
 * Project name : openshift
 * Package name : xin.wukm.controller
 * Author : Wukunmeng
 * User : wukm
 * Date : 17-6-18
 * Time : 下午3:09
 * ---------------------------------
 * To change this template use File | Settings | File and Code Templates.
 */
@RestController
@RequestMapping(value = "/api")
public class SystemController extends BaseController {

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ResponseBody
    public Object info(){
        Map<String,Object> detail = new HashMap();
        detail.put("time", System.currentTimeMillis());
        return detail;
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public Object hello(){
        Map<String,Object> detail = new HashMap();
        detail.put("time", System.currentTimeMillis());
        return detail;
    }
}
