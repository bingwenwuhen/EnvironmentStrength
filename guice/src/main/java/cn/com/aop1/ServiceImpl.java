package cn.com.aop1;

import com.google.inject.name.Named;

import javax.inject.Singleton;

/**
 * Created by xiaxuan on 16/8/19.
 */
@Singleton
public class ServiceImpl implements Service {

    @Named("log")
    public void sayHello() {
        System.out.println(String.format("[%s#%s] execute %s", this.getClass().getSimpleName(),hashCode(), System.nanoTime()));
    }
}
