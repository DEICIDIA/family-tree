import java.util.ArrayList;
import javax.swing.JPanel;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

public class drawTree extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9136486046369835553L;
	private ArrayList<Personne> listePers;
	private ArrayList<Object> listeObjet = new ArrayList<Object>();
	private String couleurHomme = mxConstants.STYLE_FILLCOLOR + "=#87CEEB";
	private String couleurFemme = mxConstants.STYLE_FILLCOLOR + "=#FFB6C1";
	private String edgeStyle = mxConstants.STYLE_ROUNDED + "=1";
	private mxGraph graph;
	private Object parent;

	public drawTree(ArrayList<Personne> listePersonne) {

		listePers = listePersonne;
		graph = new mxGraph();
		parent = graph.getDefaultParent();
		graph.setCellsEditable(false);
		graph.setCellsMovable(false);
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		graphComponent.setBounds(412, 5, 4, 4);
		graphComponent.setEnabled(true);
		this.setLayout(null);
		this.add(graphComponent);
		this.setVisible(true);
	}

	public void updatePers() {

		/*
		 * ajoute les personne dans le graph
		 */
		try {
			graph.getModel().beginUpdate();

			if (listePers.get(listePers.size() - 1) instanceof Homme) {
				listeObjet.add(graph.insertVertex(parent, null,
						listePers.get(listePers.size() - 1).prenom() + " " + listePers.get(listePers.size() - 1).nom()
								+ "\n" + listePers.get(listePers.size() - 1).dateNaissance(),
						0, 0, 100, 50, couleurHomme));
			} else {
				listeObjet.add(graph.insertVertex(parent, null,
						listePers.get(listePers.size() - 1).prenom() + " " + listePers.get(listePers.size() - 1).nom()
								+ "\n" + listePers.get(listePers.size() - 1).dateNaissance(),
						0, 0, 100, 50, couleurFemme));

			}
			
			


			System.out.println(graph.getSelectionCells());

			
			

			mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
			layout.setUseBoundingBox(false);
			layout.execute(parent);

		} finally {
			graph.getModel().endUpdate();
		}
	}

	public void updateLiens(int index) {
		try {
			graph.getModel().beginUpdate();

			/*
			 * liens entre la personne selectionné dans la comboBox1 et son père / mère
			 */
			Personne persSelec = listePers.get(index);

			if (persSelec.aPere() && !(persSelec.isConnectedToPere())) {
				graph.insertEdge(parent, null, "", listeObjet.get(listePers.indexOf(persSelec.pere())),
						listeObjet.get(listePers.indexOf(persSelec)), edgeStyle);
				persSelec.connectedToPere(true);
			}
			if (persSelec.aMere() && !(persSelec.isConnectedToMere())) {
				graph.insertEdge(parent, null, "", listeObjet.get(listePers.indexOf(persSelec.mere())),
						listeObjet.get(listePers.indexOf(persSelec)), edgeStyle);
				persSelec.connectedToMere(true);
			}

			mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
			layout.setUseBoundingBox(false);
			layout.execute(parent);
		} finally {
			graph.getModel().endUpdate();
		}
	}
	
	public void supprimerFeuille(Personne pers) {
		if(pers.aMere()) {
			pers.mere().enfants.remove(pers.mere().enfants.indexOf(pers));
		} else if (pers.aPere()) {
			pers.pere().enfants.remove(pers.pere().enfants.indexOf(pers));

		}		
		listeObjet.remove(listePers.indexOf(pers));
		listePers.remove(listePers.indexOf(pers));

	}
	

}
