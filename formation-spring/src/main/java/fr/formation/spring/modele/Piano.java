package fr.formation.spring.modele;

import org.springframework.stereotype.Component;

import fr.formation.spring.dao.IInstrument;

@Component
public class Piano implements IInstrument {
	
	public String toString() {
		return "Piano : PLING PLING PLING PLACK PLACK PLACK";
		}

}
