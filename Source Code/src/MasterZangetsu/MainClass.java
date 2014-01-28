package MasterZangetsu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainClass extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel name;
	JLabel copiedName;
	
	JTextField nameInput;
	JTextField nameOutput;

	public static void main(String args[]) {

		new MainClass();

	}

	public MainClass() {

	
		name = new JLabel("Enter First Name");
		copiedName = new JLabel("Corrected Name");
		
		nameInput = new JTextField();
		nameOutput = new JTextField();
		
		nameInput.setColumns(15);
		nameOutput.setColumns(15);
		
		
		nameInput.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				editInput();
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				editInput();
				
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				editInput();
				
			}
			
			void editInput() {
				
				String inputName = nameInput.getText().replace(" ", "");
				String output = inputName.substring(0,1).toUpperCase(Locale.UK) + inputName.substring(1,inputName.length());
				nameOutput.setText(output);
				
			}
			
		});
			
		
		layoutElements();
		this.pack();
		this.setTitle("Training Module");
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layoutElements() {
		
		JPanel panel = new JPanel(new GridBagLayout());
		this.getContentPane().add(panel);

		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(name, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(copiedName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(nameInput, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(nameOutput, gbc);
		
	}

}

