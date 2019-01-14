//alert("Hello !");
//
//console.log("Debugage ...");

var getTypeClient = function(nbCli){
	// ou alors faire directement return chaine 
	if (nbCli<=200) { 
		affichage("Petit client...", console.log); 
		return "Petit client...";
		}
		else if (nbCli>200 && nbCli<=2000) { 
			affichage("Client...", console.log);
			return "Client...";
			}
		else if (nbCli>2000 && nbCli<=10000) { 
			affichage("Client a potentiel...", console.log); 
			return "Client a potentiel...";
		}
		else { 
			affichage("Grand client compte...", console.log);
			return "Grand client compte...";}
}


var affichage = function(chaine, fonctionAffichage){
	fonctionAffichage(chaine);
	//alert(chaine);
}

var tablesChiffres = [15000,10,100,254,4502,1420,1500,100,16500,2574]

//
//affichage("Method 1",alert);
//for (let i in tablesChiffres){ getTypeClient(tablesChiffres[i]); }
//
//affichage("Method 2",alert);
//for (var i = 0; i < tablesChiffres.length; i++)
//{ getTypeClient(tablesChiffres[i]); }
//
//affichage("Method 3",alert);
////tablesChiffres.forEach(getTypeClient(el,index));
//
//tablesChiffres.forEach(function(el, index) {
//	affichage(getTypeClient(el),console.log);
//	});

var dernierClient = {
	nom: "Dreamsand",
	prenom: "Anjali",
	ca: 1500,
	getType: function() { 
		return getTypeClient(this.ca);
		},
}


//console.log("le dernier de nos clients était "+dernierClient.prenom+" "+dernierClient.nom+
//		" avec un CA de "+dernierClient.ca+" c'est donc : "+dernierClient.getType()
//		)
//
//function Personne(nom, prenom) {
//	this.nom = nom;
//	this.prenom = prenom;
//	this.getNom = function() {
//	return this.prenom + " " + this.nom;
//	}
//}
//
//var myPersonne = new Personne("PERROUAULT", "Jérémy");
//
//function Client(nom, prenom){
//	Personne.call(this, nom, prenom);
//	this.ca = 0;
//	this.getType = function(){return getTypeClient(this.ca);}
//}


class Personne {
	constructor(nom, prenom){
		this.nom = nom;
		this.prenom = prenom;
	}
	
	getNom() { return this.nom + " " + this.prenom; }
}

class Client extends Personne{
	constructor(nom, prenom, ca){
		super(nom,prenom);
		this.ca = ca;
	}
	getType() {return getTypeClient(this.ca);}
}


var clientele = [];



clientele.push()
//for (var i = 0; i < 5; i++){
//	clientele.push(new Client(prompt("Give me your first name please","First Name"),
//			prompt("Give me your last name please","Last Name"),
//			prompt("Enter the associated ca please", "CA")));
//	}

//for (let i in clientele){
//	console.log(clientele[i].getNom()+" "+clientele[i].getType());
//}

// essaie closure

var closeDemo = function(){ 
	var mavariable = 0;
	return function(){ 
		return myVariable++
		}
	}

// document.querySelector('input[name="nom"]').value //lire valeur nom saisie a l'interieur 

// creer 3 TD 1 TR ajouter TD aux TR puis select tbl et ajouter tr


var envoyerProduitJS = function(){
//	class nouveauProduit {
//		constructor(){
//			this.nom = document.querySelector('input[id="inputProduit"]').value;
//			this.description = " ";
//			this.prix = document.querySelector('input[id="inputPrix"]').value;
//			this.fournisseur = document.querySelector('select[class="custom-select" ]').value;
//		}
//	}
//	
//	var nouveauProduit = {
//			nom: document.querySelector('input[id="inputProduit"]').value;
//			description: " ";
//			prix: document.querySelector('input[id="inputPrix"]').value;
//			fournisseur: document.querySelector('select[class="custom-select" ]').value;
//		}
//	}
	
	var element = nouveauProduit;
	

	var newTr = document.createElement("tr");
	var col1 = document.createElement("td");
	var col2 = document.createElement("td");
	var col3 = document.createElement("td");
	var col4 = document.createElement("td");
	
	col1.innerHTML = element.nom;
	col2.innerHTML = element.description;
	col3.innerHTML = element.prix;
	col4.innerHTML = element.fournisseur;
	
	newTr.append(col1);
	newTr.append(col2);
	newTr.append(col3);
	newTr.append(col4);
	
	document.querySelector('table').append(newTr);

}
