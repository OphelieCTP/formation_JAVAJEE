package fr.formation.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;

@Aspect
@Component
@ComponentScan("fr.formation.aspect")
public class PublicAspect {
	
	@Pointcut("execution(* fr.formation.spring.modele.*.jouer())")
	public void intercept() {
		//
	}
	
	
	@Before("intercept()")
	public void beforeJouer() {
		System.out.println("Le public encourage");
	}
	
	@AfterReturning(pointcut = "intercept()", returning = "result")
	public void interceptorToStringReturning(String result) {
		System.out.println("Retourn string intercepté");
	}

}
