import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
		this.setLayout(null);
		this.add(graphComponent);
		this.setVisible(true);
	}

	public void updatePers() {

		try {
			graph.getModel().beginUpdate();

			if (listePers.get(listePers.size() - 1) instanceof Homme) {
				listeObjet
						.add(graph.insertVertex(parent, null,
								listePers.get(listePers.size() - 1).prenom() + "\n"
										+ listePers.get(listePers.size() - 1).dateNaissance(),
								0, 0, 100, 50, couleurHomme));
			} else {
				listeObjet
						.add(graph.insertVertex(parent, null,
								listePers.get(listePers.size() - 1).prenom() + "\n"
										+ listePers.get(listePers.size() - 1).dateNaissance(),
								0, 0, 100, 50, couleurFemme));

			}

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

			if (listePers.get(index).aPere() && !(listePers.get(index).isConnectPere())) {
				graph.insertEdge(parent, null, "", listeObjet.get(listePers.indexOf(listePers.get(index).pere())),
						listeObjet.get(listePers.indexOf(listePers.get(index))), edgeStyle);
				listePers.get(index).connectedToPere(true);
			}
			if (listePers.get(index).aMere() && !(listePers.get(index).isConnectMere())) {
				graph.insertEdge(parent, null, "", listeObjet.get(listePers.indexOf(listePers.get(index).mere())),
						listeObjet.get(listePers.indexOf(listePers.get(index))), edgeStyle);
				listePers.get(index).connectedToMere(true);
			}
			
			
			
			mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
			layout.setUseBoundingBox(false);
			layout.execute(parent);
		} finally {
			graph.getModel().endUpdate();
		}
	}



}
