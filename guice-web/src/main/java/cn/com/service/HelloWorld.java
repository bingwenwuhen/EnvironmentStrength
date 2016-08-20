package cn.com.service;

import com.google.inject.ImplementedBy;

import java.io.IOException;

/**
 * Created by xiaxuan on 16/8/20.
 */
@ImplementedBy(HelloWorldImpl.class)
public interface HelloWorld {

    void execute() throws IOException;
}
