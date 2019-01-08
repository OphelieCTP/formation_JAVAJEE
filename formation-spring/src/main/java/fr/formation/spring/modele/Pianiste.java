package fr.formation.spring.modele;

import java.util.Random;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import fr.formation.annotation.Transactionnal;
import fr.formation.spring.dao.*;
import fr.formation.spring.exception.*;

@Component
public class Pianiste implements IMusicien {
	@Autowired
	@Qualifier("piano")
	private IInstrument instrument = new Piano();

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
			// catch (FausseNoteException e) { return("Le pianiste joue : une fausse note"); }
		}
		return("Le pianiste joue : " + this.instrument);		
	}

}
