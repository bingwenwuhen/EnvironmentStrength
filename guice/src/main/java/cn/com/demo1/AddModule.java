package cn.com.demo1;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Created by xiaxuan on 16/8/18.
 */
public class AddModule implements Module{

    public void configure(Binder binder) {
        binder.bind(Add.class).to(SimpleAdd.class);
    }
}
