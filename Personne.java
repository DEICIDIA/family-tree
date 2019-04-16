import java.util.ArrayList;
import java.util.List;

public abstract class Personne {

  private String prenom;
  private String nom;
  private Personne pere;
  private Personne mere;
  private String dateN;
  public List<Personne> enfants = new ArrayList<>();

  public static int nbPers = 0;

   {
     nbPers++;
   }

  public Personne(String prenom, String nom) {
    this.prenom = prenom;
    this.nom = nom;
  }
  public String nom(){
    return this.nom;
  }
  public String prenom() {
    return this.prenom;
  }
  public boolean estRacine() {
    return (this.pere == null || this.mere == null);
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
  

}
