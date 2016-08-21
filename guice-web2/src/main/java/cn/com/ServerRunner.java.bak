package cn.com;

import cn.com.boot.BootServletContextListener;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Created by xiaxuan on 16/8/21.
 */
public class ServerRunner {

    private static Server server;

    public static void main(String[] args) throws Exception {
        new ServerRunner().run();
    }

    private void run() throws Exception {
        createServer();
        bindGuiceContextToServer();
        startServer();
        waitForServerToFinish();
    }

    private void bindGuiceContextToServer() {
        ServletContextHandler context = createRootContext();
        serverGuiceContext(context);
    }

    private void serverGuiceContext(ServletContextHandler context) {
        bindGuiceContextAndFilter(context);
        addDefaultServletToContext(context);
    }

    private void addDefaultServletToContext(ServletContextHandler context) {
        context.addServlet(DefaultServlet.class, "/");
    }

    private void bindGuiceContextAndFilter(ServletContextHandler context) {
        context.addEventListener(new BootServletContextListener());
        context.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
    }

    private ServletContextHandler createRootContext() {
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("");
        server.setHandler(servletContextHandler);
        return servletContextHandler;
    }

    private void startServer() throws Exception {
        server.start();
    }

    private void waitForServerToFinish() throws InterruptedException {
        server.join();
    }

    private void createServer() {
        server = new Server(8080);
    }
}
