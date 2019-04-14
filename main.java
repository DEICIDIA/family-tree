
public class main {
	
  public main(String[] args) {


    Femme camille = new Femme("camille","thoumine");
    Femme lea = new Femme("lea","thoumine");
    Homme nathan = new Homme("nathan","thoumine");
    Homme clement = new Homme("clement","thoumine");
    Homme evan = new Homme("evan","thoumine");
    Homme arnaud = new Homme("arnaud","thoumine");
    Femme nelly = new Femme("nelly","ygrie");
    Femme laetitia = new Femme("laetitia","th");
    Femme anne = new Femme("anne","thoumine");
    Homme evanbis = new Homme("evanbis","thoumine");

    anne.setPere(nathan);
    camille.setPere(evan);
    lea.setPere(nathan);
    nathan.setPere(arnaud);
    nathan.setMere(nelly);
    evan.setPere(arnaud);
    evan.setMere(nelly);
    clement.setMere(laetitia);
    clement.setPere(arnaud);
    evanbis.setMere(lea);


    afficherEnfants(arnaud);
    System.out.println("\n");
    
  }



  public static void afficherEnfants(Personne pers){
    int nbEnfants = pers.enfants.size();
    for(int i = 0; i < nbEnfants; i++){
          System.out.print(pers.enfants().get(i).prenom() + (i == nbEnfants-1 ? "" : "___"));
    }
    for(int i = 0; i < nbEnfants; i++) {
        if(!(pers.enfants().get(i).estFeuille())) {
          System.out.print("\n  |\n  |\n");
          afficherEnfants(pers.enfants().get(i));
        }
    }
    }

  }
