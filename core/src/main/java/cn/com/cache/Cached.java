package cn.com.cache;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaxuan on 16/8/18.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cached {

    /**
     *The total time how long the return value of this method should be cached
     * @return
     */
    long timeToLive();

    /**
     * The {@link java.util.concurrent.TimeUnit} for the timeToLive. Defaults to Milliseconds
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;


}
