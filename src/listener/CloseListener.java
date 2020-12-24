/**
 * 
 */
package listener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * @author ahmed
 *
 */
public class CloseListener implements MouseListener{

	JLabel label;
	
	public CloseListener(JLabel label) {
		// TODO Auto-generated constructor stub
		this.label = label;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
		this.label.setBorder(labelBorder);
		this.label.setForeground(Color.white);
		this.label.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	@Override
	public void mouseExited(MouseEvent e) {
		Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		this.label.setBorder(labelBorder);
		this.label.setForeground(Color.black);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
