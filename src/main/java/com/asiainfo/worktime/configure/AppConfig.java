package com.asiainfo.worktime.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.asiainfo.worktime")
@Import(JpaConfiguration.class)
public class AppConfig  extends WebMvcConfigurerAdapter{
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//		registry.addResourceHandler("/WEB-INF/**").addResourceLocations("/WEB-INF/");
//		registry.addResourceHandler("/app/**").addResourceLocations("/app/");
	}
	
//	@Bean
//	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
//		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
//		resolver.addStatusCode("/error.html", 404);
//		
//		return resolver;
//	}
	
}
