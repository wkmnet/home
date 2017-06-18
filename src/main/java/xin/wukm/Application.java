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
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import static io.undertow.servlet.Servlets.defaultContainer;
import static io.undertow.servlet.Servlets.deployment;
import static io.undertow.servlet.Servlets.servlet;

import xin.wukm.servlet.MessageServlet;

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
public class Application {

    //日志
    private static Logger LOG = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args){
        try {

            DeploymentInfo servletBuilder = deployment()
                    .setClassLoader(ServletServer.class.getClassLoader())
                    .setContextPath(MYAPP)
                    .setDeploymentName("test.war")
                    .addServlets(
                            servlet("MessageServlet", MessageServlet.class)
                                    .addInitParam("message", "Hello World")
                                    .addMapping("/*"),
                            servlet("MyServlet", MessageServlet.class)
                                    .addInitParam("message", "MyServlet")
                                    .addMapping("/myservlet"));

            DeploymentManager manager = defaultContainer().addDeployment(servletBuilder);
            manager.deploy();

            HttpHandler servletHandler = manager.start();
            PathHandler path = Handlers.path(Handlers.redirect(MYAPP))
                    .addPrefixPath(MYAPP, servletHandler);
            Undertow server = Undertow.builder()
                    .addHttpListener(8080, "0.0.0.0")
                    .setHandler(path)
                    .build();
            server.start();
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
