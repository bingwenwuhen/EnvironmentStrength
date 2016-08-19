package cn.com.demo5;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class ProviderServiceDemo2 {

    @Inject
    private Provider<Service> provider;

    public static void main(String[] args) {
        ProviderServiceDemo2 providerServiceDemo2 = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(Service.class).toProvider(WwwServiceProvider.class);
            }
        }).getInstance(ProviderServiceDemo2.class);
        providerServiceDemo2.provider.get().execute();
    }
}
