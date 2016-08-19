package cn.com.demo11;


import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class OptionalInjectionDemo {

    @Inject(optional=true)
    private Service service = new WwwService();
    public static void main(String[] args) {
        Guice.createInjector(new Module() {
            public void configure(Binder binder) {

            }
        }).getInstance(OptionalInjectionDemo.class).service.execute();
    }
}
