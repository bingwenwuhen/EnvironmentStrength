package cn.com.aop1;

import com.google.inject.ImplementedBy;

/**
 * Created by xiaxuan on 16/8/19.
 */
@ImplementedBy(ServiceImpl.class)
public interface Service {

    void sayHello();

}
