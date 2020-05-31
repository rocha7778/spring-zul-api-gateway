package com.spring.zul.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpringZulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZulApiGatewayApplication.class, args);
	}

}
