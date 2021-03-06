package com.sakura.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-05
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableHystrix
@EnableEurekaClient
@EnableCircuitBreaker
public class CloudUserConsumerHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudUserConsumerHystrixApplication.class, args);
    }
}
