import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawTree extends JPanel {
	public ArrayList<Rectangle> l = new ArrayList();

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public drawTree(ArrayList<Personne> s) {
		JFrame frame = new JFrame("Testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		setSize(400,400);
		frame.setVisible(true);

		Rectangle t = new Rectangle();
		for (int i = 0; i < s.size(); i++) {
			l.add(new Rectangle(i, i, 50, 50));
		}
		
		for(int i = 0; i < l.size(); i++) {
			frame.add(getParent(), l.get(i));
		}
		setVisible(true);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		for (Rectangle rect : l) {
			g2d.draw(rect);
		}
		g2d.dispose();
	}

}
