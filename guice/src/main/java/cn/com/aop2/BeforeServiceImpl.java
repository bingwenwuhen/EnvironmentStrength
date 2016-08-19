package cn.com.aop2;

import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class BeforeServiceImpl implements BeforeService {

    public void before(MethodInvocation invocation) {
        System.out.println("before method " + invocation.getMethod().getName());
    }
}
