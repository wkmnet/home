/**
 * 代码有编辑器 IntelliJ IDEA 完成
 * Project name : home
 * Package name : xin.wukm.servlet
 * Author : Wukunmeng
 * User : wukm
 * Date : 17-6-18
 * Time : 下午7:51
 * -------------------------------
 */
package xin.wukm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 代码有编辑器 IntelliJ IDEA 完成
 * Project name : home
 * Package name : xin.wukm.servlet
 * Author : Wukunmeng
 * User : wukm
 * Date : 17-6-18
 * Time : 下午7:51
 * ---------------------------------
 * To change this template use File | Settings | File and Code Templates.
 */
public class MessageServlet extends HttpServlet {

    public static final String MESSAGE = "message";

    private String message;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        message = config.getInitParameter(MESSAGE);
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write(message);
        writer.close();
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
