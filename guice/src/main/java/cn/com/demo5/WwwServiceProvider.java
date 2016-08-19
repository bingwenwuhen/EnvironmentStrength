package cn.com.demo5;

import javax.inject.Provider;

/**
 * Created by xiaxuan on 16/8/19.
 */
public class WwwServiceProvider implements Provider<Service> {

    public Service get() {
        return new WwwService();
    }
}
