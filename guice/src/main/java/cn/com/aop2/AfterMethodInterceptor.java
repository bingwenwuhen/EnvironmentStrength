package cn.com.aop2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.inject.Inject;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class AfterMethodInterceptor implements MethodInterceptor {

    @Inject
    private BeforeService service;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        service.before(invocation);
        Object ret = null;
        try {
            ret = invocation.proceed();
        } finally {
            System.out.println("after " + invocation.getMethod().getName());
        }
        return ret;
    }
}
