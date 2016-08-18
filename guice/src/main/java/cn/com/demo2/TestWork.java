package cn.com.demo2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class TestWork {

    public static void main(String[] args) {
        RunWorkClass workClass = new RunWorkClass();
        Module myModule = new MyModule();
        //把module给guice
        Injector injector = Guice.createInjector(myModule);
        injector.injectMembers(workClass);
        workClass.runWork();
    }

}
