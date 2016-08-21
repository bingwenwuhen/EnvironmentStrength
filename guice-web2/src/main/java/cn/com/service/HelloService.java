package cn.com.service;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by xiaxuan on 16/8/20.
 */
@Path("/hello")
@Singleton
public class HelloService {

    @GET
    @Path("/world/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(@PathParam("name") String name) {
        return "hello" + name;
    }
}
