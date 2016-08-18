package cn.com.demo2;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class MyModule implements Module {

    public void configure(Binder binder) {
        binder.bind(Work.class).to(WorkImpl.class).in(Scopes.SINGLETON);
    }
}
