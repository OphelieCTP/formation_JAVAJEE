package fr.formation.spring.modele;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import fr.formation.spring.dao.IInstrument;

@Component
public class Guitare implements IInstrument {
	
	public String toString() {
		return "Guitare : GLINK GLINK GLINK";
		}
}
