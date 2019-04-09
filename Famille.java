import java.util.ArrayList;
import java.util.List;

public class Famille {
  private ArrayList<Personne> famille = new ArrayList<Personne>();

  public void Famille() {

  }

  public void addPersonne(Personne pers) {
    famille.add(pers);
  }
  public List<Personne> membre() {
    return famille;
  }
}
