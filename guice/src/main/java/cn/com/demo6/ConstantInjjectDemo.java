package cn.com.demo6;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import javax.inject.Inject;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class ConstantInjjectDemo {

    @Inject
    @Named("v")
    private int v;

    public static void main(String[] args) {
        ConstantInjjectDemo injjectDemo = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bindConstant().annotatedWith(Names.named("v")).to(12);
            }
        }).getInstance(ConstantInjjectDemo.class);
        System.out.println(injjectDemo.v);
    }
}
