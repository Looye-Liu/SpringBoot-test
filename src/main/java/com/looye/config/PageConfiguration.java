package com.looye.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by looye on 2017/11/17.
 */
@Configuration
public class PageConfiguration {

    @Bean
    public PageHelper pageHelper() {
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        PageHelper pageHelper = new PageHelper();
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
