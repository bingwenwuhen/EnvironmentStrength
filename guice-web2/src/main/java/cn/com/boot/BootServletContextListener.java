package cn.com.boot;

import cn.com.service.HelloService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import javax.servlet.annotation.WebListener;

/**
 * Created by xiaxuan on 16/8/20.
 */
@WebListener
public class BootServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new JerseyServletModule() {
            @Override
            protected void configureServlets() {
                bind(HelloService.class);
                serve("/*").with(GuiceContainer.class);
            }
        });
    }
}
