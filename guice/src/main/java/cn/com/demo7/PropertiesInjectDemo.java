package cn.com.demo7;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import javax.inject.Inject;
import java.util.Properties;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class PropertiesInjectDemo {

    @Inject
    @Named("web")
    private String web;

    public static void main(String[] args) {
        PropertiesInjectDemo propertiesInjectDemo = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                Properties properties = new Properties();
                properties.setProperty("web", "xiaxuan.com");
                Names.bindProperties(binder, properties);
            }
        }).getInstance(PropertiesInjectDemo.class);
        System.out.println(propertiesInjectDemo.web);
    }
}
