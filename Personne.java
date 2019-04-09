import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Personne {

  private String prenom;
  private String nom;
  private Personne pere;
  private Personne mere;
  public List<Personne> enfants = new ArrayList<>();

  public static int nbPers = 0;

   {
     nbPers++;
   }

  public Personne(String prenom, String nom, Famille f) {
    f.addPersonne(this);
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

}
