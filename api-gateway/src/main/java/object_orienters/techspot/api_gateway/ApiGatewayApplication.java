package object_orienters.techspot.api_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
	@Value("${techspot.objectOrienters.contentService}")
	private static String contentService;

	@Value("${techspot.objectOrienters.messagesService}")
	private static String messagesService;

	@Value("${techspot.objectOrienters.securityService}")
	private static String securityService;
	public static void main(String[] args) {

		System.out.print("************************************************************");
		System.out.println("http://" + securityService + ":8082");
		System.out.println("http://" + messagesService + ":8081");
		System.out.println("http://" + contentService + ":8080");

		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
