package com.mine.docdemo.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterB implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("dofilter b");
    }
}
