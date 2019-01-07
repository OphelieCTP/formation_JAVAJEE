package fr.formation.spring.config;

import fr.formation.spring.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		myContext.getBeanFactory().createBean(Principal.class).run(args);
		myContext.close();
		}
}
