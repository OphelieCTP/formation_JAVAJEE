package fr.formation.spring.modele;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import fr.formation.spring.dao.IInstrument;
import fr.formation.spring.dao.IMusicien;

@Component
public class Guitariste implements IMusicien {
	@Autowired
	@Qualifier("ukulele")
	private IInstrument instrument = new Guitare();

	public IInstrument getInstrument() {
		return instrument;
	}

	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}
	
	public void jouer() {
		System.out.println("Le guitariste joue : " + this.instrument);
	}

}
