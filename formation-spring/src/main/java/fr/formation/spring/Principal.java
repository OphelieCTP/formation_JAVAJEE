package fr.formation.spring;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;

import fr.formation.spring.dao.*;
import fr.formation.spring.exception.FausseNoteException;
import fr.formation.spring.config.*;

public class Principal {

	@Autowired
	@Qualifier("pianiste")
	private IMusicien musicien1;
	
	@Autowired
	private IMusicien guitariste;
	
	@Autowired
	private ApplicationContext myContext;
	
//	public void run(String[] args) {
//		
//		System.out.println("Qui voulez-vous voir jouer ? [1-pianiste/2-guitariste]");
//		IMusicien myMusicien = null;
//		switch(lireEntier()) {
//		case 1 : //myMusicien = this.musicien1;
//			myMusicien = this.myContext.getBean("pianiste", IMusicien.class);
//			break;
//		case 2 :// myMusicien = this.guitariste;
//			myMusicien = this.myContext.getBean("guitariste", IMusicien.class);
//			break;
//		}
//		myMusicien.jouer();
//		}
	
	

	public IMusicien getMusicien1() {
		return musicien1;
	}



	public void setMusicien1(IMusicien musicien1) {
		this.musicien1 = musicien1;
	}



	public IMusicien getGuitariste() {
		return guitariste;
	}



	public void setGuitariste(IMusicien guitariste) {
		this.guitariste = guitariste;
	}



	public ApplicationContext getMyContext() {
		return myContext;
	}



	public void setMyContext(ApplicationContext myContext) {
		this.myContext = myContext;
	}



	public static String lireChaine() {
		Scanner myScanner = new Scanner(System.in);
		try { return myScanner.nextLine(); }
		catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}
	
	public static int lireEntier() {
		Scanner myScanner = new Scanner(System.in);
		
		try { return myScanner.nextInt(); }
		catch (Exception ex) {
			return 0;
		}
	}
	

//	public static void main(String[] args) {
//		// IMusicien myGuitariste = new Guitariste();
//		// IInstrument myGuitare = new Guitare();
//		// sans spring = plusieurs lignes
//		
////		ClassPathXmlApplicationContext myContext = 
////				new ClassPathXmlApplicationContext("classpath:application-context.xml");
//		
//		AnnotationConfigApplicationContext myContext = 
//				new AnnotationConfigApplicationContext(AppConfig.class);
//		System.out.println("Qui voulez-vous voir jouer ? [guitariste/pianiste]");
//		
//		IMusicien myMusicien = myContext.getBean(lireChaine(), IMusicien.class);
//		// IMusicien myGuitariste = myContext.getBean(IMusicien.class);
//		myMusicien.jouer();
//		myContext.close();
//	}
	
	public static void main(String[] args) {
		//ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("classpath:aop-context.xml");
		AnnotationConfigApplicationContext myContext =  new AnnotationConfigApplicationContext(AppConfigAOP.class); 
		System.out.println("Qui voulez-vous voir jouer ? [guitariste/pianiste]");
		IMusicien myMusicien = myContext.getBean(lireChaine(), IMusicien.class);
		myMusicien.jouer();
//		try {
//			System.out.println(myMusicien.jouer());
//		}
//		catch (Exception e) {
//			//
//		}
		
		myContext.close();
	}
	
}
