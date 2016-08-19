package cn.com.aop2;

import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by xiaxuan on 16/8/19.
 */
public interface BeforeService {

    void before(MethodInvocation invocation);
}
