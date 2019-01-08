package fr.formation.spring.config;

import fr.formation.spring.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = 
				// new AnnotationConfigApplicationContext(AppConfig.class);
				new AnnotationConfigApplicationContext(AppConfigAOP.class);
		myContext.getBeanFactory().createBean(Principal.class).main(args);
		myContext.close();
		}
}
