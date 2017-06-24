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

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;

import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;
import java.util.Calendar;
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
@RequestMapping(value = "/")
public class SystemController extends BaseController {

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ResponseBody
    public Object info(){
        Map<String,Object> detail = new HashMap<String,Object>();
        Runtime runtime = Runtime.getRuntime();
        detail.put("totalMemory", runtime.totalMemory());
        detail.put("maxMemory", runtime.maxMemory());
        detail.put("freeMemory",runtime.freeMemory());
        detail.put("availableProcessors", runtime.availableProcessors());
        OperatingSystemMXBean osmb = ManagementFactory.getOperatingSystemMXBean();
        detail.put("systemLoadAverage", osmb.getSystemLoadAverage());
        detail.put("osName", osmb.getName());
        detail.put("version", osmb.getVersion());
        ThreadMXBean tmb = ManagementFactory.getThreadMXBean();
        detail.put("threadCount", tmb.getThreadCount());
        Calendar c = Calendar.getInstance();
        detail.put("time", c.getTimeInMillis());
        detail.put("dateTime", DateFormatUtils.ISO_DATETIME_FORMAT.format(c));
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
