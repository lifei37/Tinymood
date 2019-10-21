package com.lifei.mood.config;

import com.lifei.mood.common.Constant;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//这是系统默认配置
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        //这是添加的配置，表示将/picture/..映射到E:/picture/目录
        String os = System.getProperty("os.name");

        if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
            registry.addResourceHandler("/picture/**").addResourceLocations("file:"+ Constant.WINDOWS_PATH+"picture/");

        } else {  //linux 和mac
            registry.addResourceHandler("/picture/**").addResourceLocations("file:"+Constant.LINUX_PATH+"picture/");
        }
    }
}
