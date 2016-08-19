package cn.com.demo8;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class ScopeDemo {

    public static void main(String[] args) {
        Service service = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(Service.class).to(WwwService.class).in(Scopes.SINGLETON);
            }
        }).getInstance(Service.class);
        service.execute();
    }
}
