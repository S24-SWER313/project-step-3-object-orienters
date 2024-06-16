package object_orienters.techspot.messages_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("object_orienters.techspot.messages_service")
public class MessagesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagesServiceApplication.class, args);
	}

}
