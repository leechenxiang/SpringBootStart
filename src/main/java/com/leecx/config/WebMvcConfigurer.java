package com.leecx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.leecx.controller.interceptor.OneInterceptor;
import com.leecx.controller.interceptor.TwoInterceptor;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/one/**")
		 											 .addPathPatterns("/two/**");
		super.addInterceptors(registry);
	}

}
