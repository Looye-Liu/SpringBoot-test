package com.looye;

import com.looye.servlet.MyServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by looye on 2017/11/12.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.looye"})
@MapperScan("com.looye.mapper")
@ServletComponentScan
public class TestApp {

    @Bean
    public ServletRegistrationBean myServerlet() {
        return new ServletRegistrationBean(new MyServlet(), "/myServlet");
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
    }

}
