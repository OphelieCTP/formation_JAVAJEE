package fr.formation.spring.config;

import org.springframework.context.annotation.*;
import fr.formation.spring.modele.*;
import fr.formation.spring.dao.*;

@Configuration
@ImportResource("classpath:application-context.xml")
@ComponentScan("fr.formation")
public class AppConfig {
	@Bean
	public IInstrument guitare() {
		return new Guitare();
		}
	
	@Bean
	public IMusicien guitariste() {
		return new Guitariste();
		}
}