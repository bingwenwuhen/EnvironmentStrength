package cn.com.aop2;

import cn.com.aop1.Service;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

import javax.inject.Inject;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class AopDemo2 {

    @Inject
    private Service service;

    public static void main(final String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(BeforeService.class).to(BeforeServiceImpl.class);
                AfterMethodInterceptor interceptor = new AfterMethodInterceptor();
                binder.requestInjection(interceptor);
                binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Names.named("log")), interceptor);
            }
        });
        AopDemo2 demo2 = injector.getInstance(AopDemo2.class);
        demo2.service.sayHello();
    }
}
