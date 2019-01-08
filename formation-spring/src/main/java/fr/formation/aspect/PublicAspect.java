package fr.formation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import fr.formation.spring.exception.*;

@Aspect
@Component
@ComponentScan("fr.formation.aspect")
public class PublicAspect {
	
	@Pointcut("execution(* fr.formation.spring.modele.*.jouer())")
	public void intercept() {
		//
	}
	
	
//	@Before("intercept()")
//	public void beforeJouer() {
//		System.out.println("Le public encourage");
//	}
//	
//	@AfterReturning(pointcut = "intercept()", returning = "result")
//	public void afterJouer(String result) {
//		System.out.println("Le public applaudit"); 
////		if(result == "Le guitariste joue : une fausse note" || result == "Le pianiste joue : une fausse note") {
////			System.out.println(result);
////			System.out.println("Le public hue le musicien");
////		}
////		else {
////			System.out.println(result);
////			System.out.println("Le public applaudit"); 
////			}
//	}
//	
//	@AfterThrowing(pointcut = "execution(* fr.formation.spring.modele.*.jouer())", throwing="ex")
//	public void afterJouerFausseNote(){
//		System.out.println("Le public hue le musicien");
//    }
	
	@Around("execution(* fr.formation.spring.modele.*.jouer())")
	public void remplacement(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Le public encourage"); 
		
		//Exécuter la méthode
		//Donc ne pas indiquer cette ligne n'exécutera pas la méthode
		try {
			String result = (String)proceedingJoinPoint.proceed();
			System.out.println(result.toString());
			System.out.println("Le public applaudit le musicien");
		}
		catch(FausseNoteException ex) {
			System.out.println(" FAUSSE NOTE !!!! ");
			System.out.println("Le public hue le musicien");
		}
		System.out.println("Le public se barre"); 
	}
	
	
	
	
	@Before("@annotation(fr.formation.annotation.Transactionnal)")
	public void beginTx() {
		System.out.println("Début de la transaction");
	}
	
	@AfterReturning("@annotation(fr.formation.annotation.Transactionnal)")
	public void afterTx() {
		System.out.println("Fin de la transaction");
	}

}
