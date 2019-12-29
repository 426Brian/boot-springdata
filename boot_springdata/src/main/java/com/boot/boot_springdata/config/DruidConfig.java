package com.boot.boot_springdata.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brian in 3:45 2018/12/2
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource durid() {

        return new ;
    }

    // 配置Druid 的监控
    // 1. 配置一个监控后台的 servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, Object> initMap = new HashMap();
        initMap.put("loginUsername", "admin");
        initMap.put("loginPassword", "135642");
        initMap.put("allow", "");
        initMap.put("deny", "192.168.1.000");

        bean.setInitParameters(initMap);
        return bean;
    }

    // 2. 配置一个 filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, Object> initMap = new HashMap();
        initMap.put("exclusions", "*.html, *.js, *.css, /druid/*");
        bean.setInitParameters(initMap);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }


}
