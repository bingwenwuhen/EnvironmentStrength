package cn.com.demo10;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class EagerSingletonDemo {

    public EagerSingletonDemo() {
        System.out.println("constuctor:" + System.nanoTime());
    }

    void doit(){
        System.out.println("doit: " + System.nanoTime());
    }

    public static void main(String[] args) throws InterruptedException {
        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(EagerSingletonDemo.class).asEagerSingleton();
            }
        });
        System.out.println("before all: " + System.nanoTime());
        Thread.sleep(100L);
        injector.getInstance(EagerSingletonDemo.class).doit();
    }
}
