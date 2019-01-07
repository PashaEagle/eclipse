package package1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Learn0Application {

	public static void main(String[] args) {
		SpringApplication.run(Learn0Application.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("sss.xml");
	}
}
