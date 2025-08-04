package com.pan.configuration;

import com.pan.ioc.DataConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean(name = "config")
    public DataConfig dataConfig() {

        DataConfig dataConfig = new DataConfig();
        dataConfig.setDriverName("Driver");
        dataConfig.setUrl("localhost:3306/dbname");
        dataConfig.setDriverName("root");
        dataConfig.setPassword("root");
        return dataConfig;

    }

}
