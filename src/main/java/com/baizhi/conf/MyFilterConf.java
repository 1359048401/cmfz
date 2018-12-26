/*
package com.baizhi.conf;

import com.baizhi.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyFilterConf {
    @Bean
    public FilterRegistrationBean myFilter() {
        //新建过滤器注册类
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //添加我们写好的过滤器
        filterRegistrationBean.setFilter(new MyFilter());
        //设置过滤器的URL
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
*/
