package cn.com.demo4;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;

import javax.inject.Inject;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class StaticMultinteraceServiceDemo {

    @Inject
    @Www
    private static Service wwwService;

    @Inject
    @Home
    private static Service homeService;

    public static void main(String[] args) {
        Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(Service.class).annotatedWith(Www.class).to(WwwService.class);
                binder.bind(Service.class).annotatedWith(Home.class).to(HomeService.class);
                binder.requestStaticInjection(StaticMultinteraceServiceDemo.class);
            }
        });
        StaticMultinteraceServiceDemo.homeService.execute();
        StaticMultinteraceServiceDemo.wwwService.execute();
    }
}
