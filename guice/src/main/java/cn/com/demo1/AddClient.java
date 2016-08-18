package cn.com.demo1;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class AddClient {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AddModule());
        Add add = injector.getInstance(Add.class);
        System.out.println(add.add(3, 4));
    }
}
