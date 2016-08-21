package cn.com.boot;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created by xiaxuan on 16/8/20.
 */
public class BootServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new BindJerseyResourcesModule());
    }
}
