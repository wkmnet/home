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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
@Controller
@RequestMapping(value = "/")
public class HomeController extends BaseController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(ModelMap modelMap){
        modelMap.put("title","家园-Home");
        modelMap.put("code","success");
        modelMap.put("message","地球核心");
        logger.info("model : {}", modelMap);
        return new ModelAndView("hello");
    }
}
