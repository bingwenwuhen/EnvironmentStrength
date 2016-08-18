package cn.com.demo4;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;

import javax.inject.Inject;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class MultiInteraceServiceDemo {

    @Inject
    @Www
    private Service wwwService;

    @Inject
    @Home
    private Service homeService;

    public static void main(String[] args) {
        MultiInteraceServiceDemo multiInteraceServiceDemo = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(Service.class).annotatedWith(Www.class).to(WwwService.class);
                binder.bind(Service.class).annotatedWith(Home.class).to(HomeService.class);
            }
        }).getInstance(MultiInteraceServiceDemo.class);
        multiInteraceServiceDemo.homeService.execute();
        multiInteraceServiceDemo.wwwService.execute();
    }

}
