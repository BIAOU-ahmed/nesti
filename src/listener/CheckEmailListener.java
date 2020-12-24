/**
 * 
 */
package listener;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

import nesti.Check;


/**
 * @author ahmed
 *
 */
public class CheckEmailListener implements KeyListener{
	JTextField textField;
	
	public CheckEmailListener(JTextField textField) {
		// TODO Auto-generated constructor stub
		this.textField = textField;
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
		if (Check.isValidEmail(textField.getText())) {
			labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green);
		}
		textField.setBorder(labelBorder);
	}
	



}
