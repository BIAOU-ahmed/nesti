/**
 * 
 */
package listener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * @author ahmed
 *
 */
public class MinimizeListener implements MouseListener {
	JLabel label;
	JFrame frame;

	public MinimizeListener(JLabel label, JFrame frame) {
		
		this.label = label;
		this.frame = frame;
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
		frame.setState(JFrame.ICONIFIED);
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
