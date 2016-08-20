package cn.com.service;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by xiaxuan on 16/8/20.
 */
@RequestScoped
public class HelloWorldImpl implements HelloWorld {

    private HttpServletRequest request;

    private HttpServletResponse response;

    @Inject
    public HelloWorldImpl(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void execute() throws IOException {
        String name = request.getParameter("user");
        if (name == null || name.length() < 1)
            name = "Guest";
        response.getWriter().append(String.format("Hello, %s. %s -> sessionId=%s", name,new Date(), request.getRequestedSessionId()));
    }


}
