package cn.com.boot;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.Set;

/**
 * Created by xiaxuan on 16/8/20.
 */
public class BindJerseyResourcesModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bindResources();
        setBoundResources();
    }

    private void bindResources() {
        for (Class<?> resource : lookupResources()) {
            bind(resource);
        }
    }

    private Set<Class<?>> lookupResources() {
        PackagesResourceConfig resourceConfig = new PackagesResourceConfig("cn.com.service");
        return resourceConfig.getClasses();
    }

    private void setBoundResources() {
        serve("/*").with(GuiceContainer.class);
    }
}
