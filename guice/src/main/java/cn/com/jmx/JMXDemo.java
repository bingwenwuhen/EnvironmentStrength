package cn.com.jmx;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;

/**
 * Created by xiaxuan on 16/8/20.
 */
public class JMXDemo {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(MBeanServer.class).toInstance(ManagementFactory.getPlatformMBeanServer());
                binder.bind(HelloWorldMBean.class).to(HelloWorld.class);
            }
        });

    }
}
