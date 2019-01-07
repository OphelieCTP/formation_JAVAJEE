package fr.formation.spring.modele;

import org.springframework.stereotype.Component;

import fr.formation.spring.dao.IInstrument;

@Component
public class Synthe implements IInstrument {
	public String toString() {
		return "Synthe : BING BING BING";
		}

}
