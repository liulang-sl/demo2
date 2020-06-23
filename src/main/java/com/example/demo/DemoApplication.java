package com.example.demo;

import com.example.adminClient.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAdminServer
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DemoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/path", method = RequestMethod.GET)
	public String requestMethodName() {
		return "。。。。。。。。。。。。。。。。。。。。8933的方法";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String requestMethodName(@RequestParam String name) {
		return restTemplate().getForObject("http://ADMIN-CLIENT/hello?name=" + name, String.class);
	}

	@RequestMapping(value = "/getServer", method = RequestMethod.GET)
	public String getServer(@RequestParam String name) {
		return "测试带参Feign调用8933" + name;
	}

	@RequestMapping(value = "/getUser")
	public String getUser(@RequestBody User user) {
		return "测试对象Feign调用8933" + user.getUsername();
	}
}
