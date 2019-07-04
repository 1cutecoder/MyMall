package com.cskaoyan.malldemo.config;

import com.cskaoyan.malldemo.util.MyDateConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;

/**
 * Created by cute coder
 * 2019/6/16 17:47
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Autowired
  ConfigurableConversionService configurableConversionService;

  @Bean
  @Primary
  public ConfigurableConversionService configurableConversionService() {
    return configurableConversionService;
  }

  @PostConstruct
  public void addConverterToService() {
    configurableConversionService.addConverter(new MyDateConverter());
  }

}
