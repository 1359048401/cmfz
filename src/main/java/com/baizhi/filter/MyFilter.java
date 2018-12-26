/*
package com.baizhi.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {

    String[] includeUrls = new String[]{"/cmfz","admin/login"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession(true);
        String uri = request.getRequestURI();
        System.out.println("filter url:"+uri);

        boolean needFilter = isNeedFilter(uri);
        if (!needFilter){
            chain.doFilter(request,response);
        }else {
            Object obj = session.getAttribute("admin");
            if (obj != null) {
                chain.doFilter(request, response);
            } else {
                response.sendRedirect("/cmfz/login.jsp");
            }
        }
    }

    public boolean isNeedFilter(String uri){
        for(String includeUrl : includeUrls){
            if(includeUrl.equals(uri)){
                return false;
            }
        }
        return true;
    }


    @Override
    public void destroy() {

    }
}
*/
