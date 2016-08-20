package cn.com.servlet;

import cn.com.service.HelloWorld;
import com.google.inject.Inject;
import com.google.inject.Injector;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by xiaxuan on 16/8/20.
 */
@Singleton
public class HelloWorldServlet extends HttpServlet{

    @Inject
    private Injector injector;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Hello guice!" + new Date());
        injector.getInstance(HelloWorld.class).execute();
        injector.getInstance(HelloWorld.class).execute();
    }
}
