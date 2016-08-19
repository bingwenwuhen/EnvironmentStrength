package cn.com.aop1;

import static java.lang.System.in;
import static java.lang.System.out;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class LoggerMethodInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();
        long startTime = System.nanoTime();
        out.println(String.format("before method [%s] at %s", methodName, startTime));
        Object ret = null;
        try {
            ret = invocation.proceed();
        } finally {
            long endTime = System.nanoTime();
            out.println(String.format("after method [%s] at %s", methodName, endTime));
        }
        return ret;
    }
}
