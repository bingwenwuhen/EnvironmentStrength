package cn.com.jmx;

import com.google.inject.Inject;

import javax.management.*;

/**
 * Created by xiaxuan on 16/8/20.
 */
public class HelloWorld implements HelloWorldMBean {

    public String sayHello() {
        return "Hello, guice";
    }

    @Inject
    public void register(MBeanServer server) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        server.registerMBean(this, new ObjectName("xiaxuan guice demo:type=HelloWorld"));
    }
}
