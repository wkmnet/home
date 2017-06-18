/**
 * 代码有编辑器 IntelliJ IDEA 完成
 * Project name : openshift
 * Package name : xin.wukm
 * Author : Wukunmeng
 * User : wukm
 * Date : 17-6-18
 * Time : 下午2:55
 * -------------------------------
 */
package xin.wukm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 代码有编辑器 IntelliJ IDEA 完成
 * Project name : openshift
 * Package name : xin.wukm
 * Author : Wukunmeng
 * User : wukm
 * Date : 17-6-18m
 * Time : 下午2:55
 * ---------------------------------
 * To change this template use File | Settings | File and Code Templates.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    //日志
    private static Logger LOG = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args){
        LOG.info("start project : " + Application.class.getName());
        try {
            SpringApplication application = new SpringApplication(Application.class);
            application.run(args);
        } catch (Exception e){
            LOG.error("start application error : ", e);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
