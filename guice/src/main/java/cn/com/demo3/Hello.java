package cn.com.demo3;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class Hello implements IHello {

    public void sayHello(String userName) {
        System.out.println(">>>".concat(userName));
    }
}
