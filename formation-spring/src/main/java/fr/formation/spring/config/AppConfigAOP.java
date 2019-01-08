package fr.formation.spring.config;

import org.springframework.context.annotation.*;
import fr.formation.spring.modele.*;
import fr.formation.spring.dao.*;

@Configuration
// @ImportResource("classpath:aop-context.xml")
@ComponentScan("fr.formation")
@EnableAspectJAutoProxy
public class AppConfigAOP {
	@Bean
	public IInstrument guitare() {
		return new Guitare();
		}
	
	@Bean
	public IMusicien guitariste() {
		return new Guitariste();
		}
}