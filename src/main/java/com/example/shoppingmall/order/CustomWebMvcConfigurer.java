package com.example.shoppingmall.order;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CustomWebMvcConfigurer extends WebMvcConfigurationSupport {

   @Override
   protected void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new MyInterceptor())
            .addPathPatterns("/**");
   }
}
