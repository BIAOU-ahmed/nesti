/**
 * 
 */
package listener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import nesti.Login;

/**
 * @author ahmed
 *
 */
public class RegisterLabelListener implements MouseListener{
	JLabel label;
	JFrame frame;
	 JFrame nextFrame;
	 String nextFrameName;
	public RegisterLabelListener(JLabel label,JFrame frame,String nextFrame ) {
		
		this.label = label;
		this.frame = frame;
		this.nextFrameName = nextFrame;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		if(nextFrameName=="login") {
			nextFrame= new Login();
		}else {
			nextFrame= new nesti.Register();
		}
		nextFrame.setVisible(true);
		this.frame.setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		this.label.setForeground(Color.GRAY);
		this.label.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		this.label.setForeground(Color.LIGHT_GRAY);
	}

}
