package com.temel.inventory.configuration;

import com.temelt.provider.TimeProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeProviderConfig {

    @Bean
    public TimeProvider timeProvider() {
        return new TimeProvider();
    }
}
