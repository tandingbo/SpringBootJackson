package cn.hy.springbootjackson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringBootJacksonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJacksonApplication.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(SpringBootJacksonApplication.class, args);
//
//		UserDTO dto = new UserDTO();
//
//		dto.setDate(new Date());
//
//		System.out.println(dto.toString());
//
//		context.close();
    }
}
