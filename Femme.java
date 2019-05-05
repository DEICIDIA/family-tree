public class Femme extends Personne {
	private double salaire;
	public Femme(String prenom, String nom) {
		super(prenom, nom);
	}

	public void ajouterEnfant(Personne p) {
		enfants.add(p);
		p.setMere(this);
	}
	public void wageGap(int salaire) {
		this.salaire = salaire * 0.75;	
	}
}