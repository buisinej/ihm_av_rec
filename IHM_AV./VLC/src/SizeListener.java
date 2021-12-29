import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

public class SizeListener implements ComponentListener {
	JFrame m_frame;
	JToggleButton m_b;

	SizeListener(JFrame f, JToggleButton b) {
		m_frame = f;
		m_b = b;
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

		int longueur = m_frame.getWidth();
		int hauteur = m_frame.getHeight();
		
		if (1000 > hauteur && !m_b.isSelected()) {
			m_frame.setSize(longueur, 150);
		} else if (1000 > hauteur && m_b.isSelected()){
			m_frame.setSize(longueur, 256);
		}
		
		if(hauteur > 256) {
			
		}
		m_frame.revalidate();

	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

}
