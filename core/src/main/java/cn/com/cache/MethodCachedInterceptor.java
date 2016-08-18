package cn.com.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class MethodCachedInterceptor implements MethodInterceptor {

    private final ConcurrentMap<String, Cache<Object, Object>> caches;

    public MethodCachedInterceptor(ConcurrentMap<String, Cache<Object, Object>> caches) {
        this.caches = caches;
    }

    public Object invoke(final MethodInvocation invocation) throws Throwable {
        String key = getKey(invocation);
        Cached annotation = invocation.getStaticPart().getAnnotation(Cached.class);
        String method = invocation.getMethod().toString();
        caches.putIfAbsent(method, CacheBuilder.newBuilder().expireAfterWrite(annotation.timeToLive(), annotation.timeUnit()).build());
        Cache<Object, Object> cache = this.caches.get(method);
        return cache.get(key, new Callable<Object>() {
            public Object call() throws Exception {
                try {
                    return invocation.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    throw new RuntimeException(throwable);
                }
            }
        });
    }

    private String getKey(MethodInvocation invocation) {
        StringBuilder builder = new StringBuilder();
        builder.append(invocation.getThis().getClass().getSuperclass());
        builder.append("#");
        builder.append(invocation.getMethod().getName());
        builder.append("[");
        for (Object o : invocation.getArguments()) {
            if (o == null) {
                builder.append("null");
            } else {
                builder.append(o.hashCode());
            }
            builder.append(",");
        }
        builder.append("]");
        return builder.toString();
    }
}
