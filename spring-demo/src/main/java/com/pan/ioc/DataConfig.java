package com.pan.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component("config")
public class DataConfig {

    @Value("localhost:3306/dbname")
    private String url;
    @Value("Driver")
    private String driverName;
    @Value("root")
    private String userName;
    @Value("root")
    private String password;

}
