package com.mid.takefresh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement//启用事务管理
@EnableFeignClients(basePackages= {"com.mid.api"})
public class TakefreshApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakefreshApplication.class, args);
    }

}
