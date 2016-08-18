package cn.com.demo3;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class TestApp {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        IHello hello = injector.getInstance(IHello.class);
        hello.sayHello("xiaxuan");
    }
}
