package cn.com.boot;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.annotation.WebFilter;

/**
 * Created by xiaxuan on 16/8/21.
 */
@WebFilter("/*")
public class GuiceWebFilter extends GuiceFilter {
}
