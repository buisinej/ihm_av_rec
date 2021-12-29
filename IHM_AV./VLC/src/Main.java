import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame implements ComponentListener {
	JToggleButton liste = new JToggleButton("=");
	boolean afficherListe = false;
	JSplitPane sep;
	int m_largeur = 450;
	int m_hauteur = 150;
	JScrollPane scrollpane;
	JPanel l;

	Main() {
		// TODO Auto-generated method stub
		super("VLC");

		setMinimumSize(new Dimension(m_largeur, m_hauteur));
		

		//SizeListener s = new SizeListener(this, liste);
		addComponentListener(this);
		

		// Ligne du haut

		JPanel TopPane = new JPanel();
		TopPane.setLayout(new BoxLayout(TopPane, BoxLayout.LINE_AXIS));
		TopPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));


		JButton before = new JButton("<<");
		JButton pause = new JButton(">");
		pause.setPreferredSize(pause.getPreferredSize());
		JButton after = new JButton(">>");


		TopPane.add(Box.createRigidArea(new Dimension(5, 10)));
		TopPane.add(before);
		TopPane.add(Box.createRigidArea(new Dimension(5, 10)));
		TopPane.add(pause);
		TopPane.add(Box.createRigidArea(new Dimension(5, 10)));
		TopPane.add(after);

		JPanel lecteur = new JPanel(new BorderLayout());

		JLabel label1 = new JLabel("Lecteur multimédia VLC");
		JLabel label2 = new JLabel("12:12");
		lecteur.add(label1, BorderLayout.WEST);
		lecteur.add(label2, BorderLayout.EAST);

		JSlider sliderMusic = new JSlider(0, 100, 12);
		lecteur.add(sliderMusic, BorderLayout.SOUTH);

		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();

		Border compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);

		lecteur.setBorder(compound);

		TopPane.add(Box.createRigidArea(new Dimension(10, 10)));
		TopPane.add(lecteur);

		/*
		 * TopPane.add(button, BorderLayout.WEST);
		 * 
		 * JPanel lecteur = new JPanel(new BorderLayout());
		 * 
		 * TopPane.add(lecteur, BorderLayout.EAST);
		 */

		// Ligne du bas

		JPanel BottomPane = new JPanel();
		BottomPane.setLayout(new BoxLayout(BottomPane, BoxLayout.LINE_AXIS));
		BottomPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

		JButton precedent = new JButton("|<");
		JButton stop = new JButton("■");
		JButton suivant = new JButton(">|");


		JButton reglages = new JButton("#");
		JSlider slider = new JSlider(0, 100, 0);

		BottomPane.add(Box.createRigidArea(new Dimension(10, 10)));
		BottomPane.add(precedent);
		BottomPane.add(Box.createRigidArea(new Dimension(10, 10)));
		BottomPane.add(stop);
		BottomPane.add(Box.createRigidArea(new Dimension(10, 10)));
		BottomPane.add(suivant);
		BottomPane.add(Box.createRigidArea(new Dimension(10, 10)));
		BottomPane.add(slider);
		BottomPane.add(Box.createRigidArea(new Dimension(50, 0)));
		BottomPane.add(reglages);
		BottomPane.add(Box.createRigidArea(new Dimension(10, 10)));
		BottomPane.add(liste);
		BottomPane.add(Box.createRigidArea(new Dimension(10, 10)));

		/*
		 * sep = new JSplitPane(JSplitPane.VERTICAL_SPLIT); sep.setDividerSize(0);
		 * sep.add(TopPane, JSplitPane.TOP); sep.add(BottomPane, JSplitPane.BOTTOM);
		 */
		JPanel tmp = new JPanel(new BorderLayout());

		tmp.add(TopPane, BorderLayout.NORTH);
		tmp.add(BottomPane, BorderLayout.SOUTH);
		add(tmp, BorderLayout.NORTH);

		// Liste
		String[] columnNames = {"Nom", "Auteur", "Durée"};
			

		Object[][] data = { 
				
				{ "Jaune", "34Alain34", "12:12" }, 
				{ "Bande organisé", "JuL", "--:--" },
				{ "Vendetta", "Roland Cristal", "--:--" }, 
				{ "Rock 'N Roll Train", "AC/DC", "04:21" },
				{"Skies On Fire", "AC/DC", "--:--"},
				{"Big Jack", "AC/DC", "--:--"},
				{"Anything Goes", "AC/DC", "--:--"},
				{"War Machine", "AC/DC", "--:--"},
				{"Smash 'N Grad", "AC/DC", "--:--"},
				{"Spoilin' For A Fight", "AC/DC", "--:--"},
				{"Wheels", "AC/DC", "--:--"},
				{"Petit Papa Noel", "Francine Chantereau", "--:--"},
				{"Vive le vent", "Francine Chantereau", "--:--"},
				
		};

		//DefaultTableModel model = new DefaultTableModel(data, columnNames);
		//JTable table = new JTable(model);
		JTable table = new JTable(data, columnNames);
		
		
		
		//table.setPreferredScrollableViewportSize(new Dimension(450, 150));
		//table.setFillsViewportHeight(true); 

		scrollpane = new JScrollPane();
		scrollpane.setViewportView(table);
		scrollpane.setPreferredSize(new Dimension(150, 100));
		
		//table.setLayoutOrientation(JList.VERTICAL);
		//scrollpane.setVisible(true);
		
		
		l = new JPanel(new BorderLayout());
		

		liste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == liste) {
					if (liste.isSelected()) {
						
						afficherListe = true;
											
						l.add(scrollpane, BorderLayout.NORTH);
						

						JPanel extendButton = new JPanel();
						extendButton.setLayout(new BoxLayout(extendButton, BoxLayout.LINE_AXIS));
						

						JButton plus = new JButton("+");
						JButton fleche = new JButton("⤨");
						JButton alea = new JButton("⥁");

						extendButton.add(Box.createRigidArea(new Dimension(10, 10)));
						extendButton.add(plus);
						extendButton.add(Box.createRigidArea(new Dimension(10, 10)));
						extendButton.add(fleche);
						extendButton.add(Box.createRigidArea(new Dimension(10, 10)));
						extendButton.add(alea);
						
						int nbElement = data.length;
						JLabel nbMusic = new JLabel(nbElement + " éléments");
						extendButton.add(Box.createRigidArea(new Dimension(100, 10)));
						extendButton.add(nbMusic);
						
						JTextField recherche = new JTextField();
						recherche.setText("rechercher");
						extendButton.add(Box.createRigidArea(new Dimension(100, 10)));
						extendButton.add(recherche);

						l.add(extendButton, BorderLayout.SOUTH);
						
						setMinimumSize(l.getPreferredSize());
						
						
						add(l, BorderLayout.CENTER);
						
						pack();

						

					} else {

						afficherListe = false;

						remove(l);
						setMinimumSize(new Dimension(m_largeur, m_hauteur));
						
						pack();

					}
				}
			}
			
		});
		
		pack();

	}

	public static void main(String[] arg) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
				
			}
		});
	}
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub

		int longueur = getWidth();
		int hauteur = getHeight();
		
		
		if (1000 > hauteur && !afficherListe) {
			setSize(longueur, 150);
		} else if (1000 > hauteur && afficherListe){
			setSize(longueur, 256);
		}
		
		if(hauteur > 300 && !afficherListe) {
			if (!afficherListe) {
				
				afficherListe = true;
									
				l.add(scrollpane, BorderLayout.NORTH);
				

				JPanel extendButton = new JPanel();
				extendButton.setLayout(new BoxLayout(extendButton, BoxLayout.LINE_AXIS));
				

				JButton plus = new JButton("+");
				JButton fleche = new JButton("⤨");
				JButton alea = new JButton("⥁");

				extendButton.add(Box.createRigidArea(new Dimension(10, 10)));
				extendButton.add(plus);
				extendButton.add(Box.createRigidArea(new Dimension(10, 10)));
				extendButton.add(fleche);
				extendButton.add(Box.createRigidArea(new Dimension(10, 10)));
				extendButton.add(alea);
				
				//int nbElement = data.length;
				JLabel nbMusic = new JLabel("15 éléments");
				extendButton.add(Box.createRigidArea(new Dimension(100, 10)));
				extendButton.add(nbMusic);
				
				JTextField recherche = new JTextField();
				recherche.setText("rechercher");
				extendButton.add(Box.createRigidArea(new Dimension(100, 10)));
				extendButton.add(recherche);

				l.add(extendButton, BorderLayout.SOUTH);
				
				setMinimumSize(l.getPreferredSize());
				
				add(l, BorderLayout.CENTER);
				
				pack();

			}
		}
		
		revalidate();

	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	

}
