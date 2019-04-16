public class Homme extends Personne {

  public Homme(String prenom,String nom) {
    super(prenom ,nom);
  }
  
  public void ajouterEnfant(Personne p) {
  	enfants.add(p);
	p.setPere(this);
  }
}
