/**
 * Create with IntelliJ IDEA
 * Project name : home
 * Package name : xin.wukm.controller
 * Author : Wukunmeng
 * User : wukm
 * Date : 17-6-24
 * Time : 下午6:33
 * ---------------------------------
 */
package xin.wukm.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with IntelliJ IDEA
 * Project name : home
 * Package name : xin.wukm.controller
 * Author : Wukunmeng
 * User : wukm
 * Date : 17-6-24
 * Time : 下午6:33
 * ---------------------------------
 * To change this template use File | Settings | File and Code Templates.
 */
@RestController
@RequestMapping(value = "/html")
public class HomeController extends BaseController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("code","success");
        modelMap.put("message","地球核心");
        logger.info("model : {}", modelMap);
        return "hello";
    }
}
