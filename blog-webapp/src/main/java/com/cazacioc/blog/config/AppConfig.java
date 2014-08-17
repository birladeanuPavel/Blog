package com.cazacioc.blog.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by scorpion on 12.08.14.
 */
@Configuration
@ComponentScan("")
public class AppConfig {
    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(
                new Resource[]{
                        new ClassPathResource("persistence.properties")
                }
        );
        propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        return propertyPlaceholderConfigurer;
    }
}
