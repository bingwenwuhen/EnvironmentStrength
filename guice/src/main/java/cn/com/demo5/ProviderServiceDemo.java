package cn.com.demo5;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import javax.inject.Inject;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class ProviderServiceDemo {

    @Inject
    private Service service;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(Service.class).toProvider(WwwServiceProvider.class);
            }
        });
        ProviderServiceDemo serviceDemo = injector.getInstance(ProviderServiceDemo.class);
        serviceDemo.service.execute();
    }
}
