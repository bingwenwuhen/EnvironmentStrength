package cn.com.demo2;

import javax.inject.Inject;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class RunWorkClass {

    @Inject
    private Work work;

    public void runWork() {
        work.sayHello("xiaxuan");
    }
}
