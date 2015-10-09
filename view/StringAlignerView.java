package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.StringAlignerController;

import javax.swing.JButton;
import javax.swing.JLabel;

public class StringAlignerView extends JPanel implements IStringAlignerView, ActionListener, KeyListener  {
	private MainFrame mainFrame;

	/** Controller */
	private StringAlignerController controller;
	private JTextField txtFirstWord;
	private JTextField txtSecondWord;
	private JButton btnAlign;
	
	/** Panel components */
        	
	public StringAlignerView(MainFrame mainFrame) {
		setLayout(null);
		controller = new StringAlignerController(this);
		
		JLabel lblSex = new JLabel("SEX");
		lblSex.setBounds(216, 5, 18, 14);
		add(lblSex);
		
		txtFirstWord = new JTextField();
		txtFirstWord.setText("First word");
		txtFirstWord.setBounds(61, 219, 86, 20);
		add(txtFirstWord);
		txtFirstWord.setColumns(10);
		
		txtSecondWord = new JTextField();
		txtSecondWord.setText("Second word");
		txtSecondWord.setBounds(157, 219, 86, 20);
		add(txtSecondWord);
		txtSecondWord.setColumns(10);
		
		btnAlign = new JButton("Align");
		btnAlign.setBounds(253, 218, 89, 23);
		add(btnAlign);
		btnAlign.addActionListener(this);

	}

	@Override
	public void keyPressed(KeyEvent ke) {
//		if(ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getSource() == chatInputTxtField)	{
//            
//		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnAlign) {
			String firstWord = txtFirstWord.getText();
			String secondWord = txtSecondWord.getText();
			System.out.println("SEX: " + firstWord);
			
			controller.storeUserInputs(firstWord, secondWord);
		}
		
	}
}
