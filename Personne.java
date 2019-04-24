import java.util.ArrayList;
import java.util.List;

public abstract class Personne {

	private String prenom;
	private String nom;
	private Personne pere = null;
	private Personne mere = null;
	private String dateN;
	public List<Personne> enfants = new ArrayList<>();

	public Personne(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public String nom() {
		return this.nom;
	}

	public String prenom() {
		return this.prenom;
	}



	public boolean estFeuille() {
		return (enfants.size() == 0);
	}

	public void setPere(Homme pers) {
		this.pere = pers;
		pers.enfants.add(this);
	}

	public void setMere(Femme pers) {
		this.mere = pers;
		pers.enfants.add(this);
	}

	public List<Personne> enfants() {
		return enfants;
	}

	public void retirerPere() {
		this.pere = null;
	}

	public void retirerMere() {
		this.mere = null;
	}

	public void SetDateNaissance(String d) {
		this.dateN = d;
	}

	public String dateNaissance() {
		return dateN;
	}

	public boolean aPere() {
		return !(this.pere == null);
	}

	public boolean aMere() {
		return !(this.mere == null);
	}

	public void remiseZero() {
		this.pere = null;
		this.mere = null;
		this.enfants = null;
	}

	public Personne pere() {
		return this.pere;
	}

	public Personne mere() {
		return this.mere;
	}
	
	public boolean estNoeud() {
		return ((pere != null || mere != null) && enfants.size() != 0);
	}
	public boolean estRacine() {
		return (pere == null && mere == null && enfants != null);
	}
}
