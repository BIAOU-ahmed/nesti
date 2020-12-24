/**
 * 
 */
package listener;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import nesti.Check;

/**
 * @author ahmed
 *
 */
public class CheckPasswordListener implements KeyListener{

	JPasswordField psw;
	
	public CheckPasswordListener(JPasswordField psw) {
		// TODO Auto-generated constructor stub
		this.psw = psw;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
		//
		if (Check.calculatePasswordStrength(String.valueOf(psw.getPassword())) >= 9) {
			labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green);
		}
		psw.setBorder(labelBorder);
		
	}

}
