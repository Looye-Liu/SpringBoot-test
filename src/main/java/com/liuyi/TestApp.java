package com.liuyi;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.liuyi.job.TestJob;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by looye on 2017/11/12.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.liuyi"})
@MapperScan("com.liuyi.mapper.*")
public class TestApp extends WebMvcConfigurerAdapter {

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }


    /**
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        //1、需要定一个convert 转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2、添加fastJson的配置信息，比如：是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //3、在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //4、将convert添加到converts当作
        converters.add(fastConverter);
    }


//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        //1、需要定一个convert 转换消息的对象
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        //2、添加fastJson的配置信息，比如：是否要格式化返回的json数据
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        //3、在convert中添加配置信息
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        //4、将convert添加到converts当作
//        return new HttpMessageConverters(fastConverter);
//    }

    public static void main(String[] args) {
        //quarzTest();
        SpringApplication.run(TestApp.class, args);
    }

    /**
     * 1、获取Scheduler实例,并且启动任务调度器
     * 2、创建具体的任务jobDetail
     * 3、创建触发时间点trigger
     * 4、将jobDetail和trigger交给scheduler安排触发
     * 5、睡眠20秒，关闭定时调度任务
     */
    public static void quarzTest() {
        System.out.println("-------start------" + new Date());
        try {
            //1、获取Scheduler实例
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            System.out.println("----getSchedulerName----" + scheduler.getSchedulerName());
            //2、创建具体的任务jobDetail
            JobDetail jobDetail = JobBuilder.newJob(TestJob.class).withIdentity("job1", "group1").build();

            //3创建触发时间点trigger
            ScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                    .startNow().withSchedule(scheduleBuilder).build();

            //4、将jobDetail和trigger交给scheduler安排触发
            scheduler.scheduleJob(jobDetail, trigger);

            //5、睡眠20秒，关闭定时调度任务
            TimeUnit.SECONDS.sleep(20);
            scheduler.shutdown();
            System.out.println("-------stop------" + new Date());

        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
