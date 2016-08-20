package cn.com.listener;

import cn.com.servlet.HelloWorldServlet;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * Created by xiaxuan on 16/8/20.
 */
public class MyGuiceServletContextListener extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                serve("/helloworld").with(HelloWorldServlet.class);
            }
        });
    }
}
