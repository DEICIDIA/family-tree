public class Femme extends Personne {


  public Femme(String prenom,String nom) {
    super(prenom ,nom);
  }
  public void ajouterEnfant(Personne p) {
	  enfants.add(p);
	  p.setMere(this);
  }
}
