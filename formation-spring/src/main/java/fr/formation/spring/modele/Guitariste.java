package fr.formation.spring.modele;

import java.util.Random;
import java.util.Random.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import fr.formation.annotation.Transactionnal;
import fr.formation.spring.dao.*;
import fr.formation.spring.exception.*;

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
	
	@Transactionnal
	public String jouer() {
		// Boolean falseNote = new Random.nextBoolean();
		if(new Random().nextBoolean() == true) {
			try { throw new FausseNoteException();}
			finally {
				//
			}
			// catch (FausseNoteException e) { return("Le guitariste joue : une fausse note"); }
		}
		return("Le guitariste joue : " + this.instrument);		
	}

}
