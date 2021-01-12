/**
 * 
 */
package listener;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

import nesti.Check;

/**
 * @author ahmed
 *
 */
public class ConfirmPaswordListener implements KeyListener{

	JPasswordField psw;
	JPasswordField Confirmpsw;
	
	public ConfirmPaswordListener(JPasswordField psw,JPasswordField Confirmpsw) {
		
		this.psw = psw;
		this.Confirmpsw = Confirmpsw;
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
		
		
		Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
		
		if (String.valueOf(psw.getPassword()).equals(String.valueOf(Confirmpsw.getPassword()))) {
			labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green);
		}
		Confirmpsw.setBorder(labelBorder);
		
	}
}
