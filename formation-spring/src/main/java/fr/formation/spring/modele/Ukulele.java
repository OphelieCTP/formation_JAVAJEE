package fr.formation.spring.modele;

import org.springframework.stereotype.Component;

import fr.formation.spring.dao.IInstrument;

@Component
public class Ukulele implements IInstrument {
	
	public String toString() {
		return "Ukulele : ALLOHA BLING BLING BLING";
		}

}
