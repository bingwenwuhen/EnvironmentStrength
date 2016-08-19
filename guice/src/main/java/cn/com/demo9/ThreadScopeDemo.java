package cn.com.demo9;

import com.google.inject.*;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class ThreadScopeDemo {

    static class ThreadServiceScope implements Scope {

        static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

        public <T> Provider<T> scope(Key<T> key, final Provider<T> provider) {
            return new Provider<T>() {
                public T get() {
                    T instance = (T) threadLocal.get();
                    if (instance == null) {
                        instance = provider.get();
                        threadLocal.set(instance);
                    }
                    return instance;
                }
            };
        }

        @Override
        public String toString() {
            return "Scopes.ThreadServiceScope";
        }
    }

    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(Service.class).to(WwwService.class).in(new ThreadServiceScope());
            }
        });
        for (int i = 0; i < 3; i++) {
            new Thread("Thread-" + i) {
                @Override
                public void run() {
                    for (int m = 0; m < 3; m++) {
                        System.out.println(String.format("%s-%d:%d",getName(),m,injector.getInstance(Service.class).hashCode()));
                        try {
                            Thread.sleep(50L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }.start();
        }
    }
}
