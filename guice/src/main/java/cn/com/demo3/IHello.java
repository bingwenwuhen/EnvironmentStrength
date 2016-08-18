package cn.com.demo3;

import com.google.inject.ImplementedBy;

/**
 * Created by xiaxuan on 16/8/18.
 */
@ImplementedBy(Hello.class)
public interface IHello {

    void sayHello(String userName);
}
