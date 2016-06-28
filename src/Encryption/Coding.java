package Encryption;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class Coding {

	private JFrame frame;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coding window = new Coding();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Coding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea InputTextArea = new JTextArea();
		InputTextArea.setWrapStyleWord(true);
		InputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		InputTextArea.setLineWrap(true);
		InputTextArea.setBounds(41, 85, 489, 112);
		frame.getContentPane().add(InputTextArea);

		JTextArea OutputTextArea = new JTextArea();
		OutputTextArea.setWrapStyleWord(true);
		OutputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		OutputTextArea.setLineWrap(true);
		OutputTextArea.setBounds(41, 264, 489, 143);
		frame.getContentPane().add(OutputTextArea);

		JLabel lblEnterMessage = new JLabel("Input text");
		lblEnterMessage.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblEnterMessage.setBounds(31, 66, 111, 16);
		frame.getContentPane().add(lblEnterMessage);

		JLabel lblEncryptedMessage = new JLabel("Output Text");
		lblEncryptedMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEncryptedMessage.setBounds(31, 214, 111, 16);
		frame.getContentPane().add(lblEncryptedMessage);

		JLabel lblEnterPassword = new JLabel("Enter Key");
		lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterPassword.setBounds(40, 24, 111, 16);
		frame.getContentPane().add(lblEnterPassword);

		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setBounds(192, 21, 116, 38);
		frame.getContentPane().add(password);
		password.setColumns(10);
		// Encrypt button
		JButton btnNewButton = new JButton("Encrypt");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Where action is
															// performed on
															// button
				String password1 = password.getText(); // Gets the Password
				String input1 = InputTextArea.getText(); // gets the text
				String pP = EncryptionMain.firstString(password1); // use
																	// password
																	// plus
																	// alphabet
				String inputCode = EncryptionMain.createInputCode(pP);
				String outputCode = EncryptionMain.createOutputCode(pP);

				String encrypted = EncryptionMain.encrypt(input1, inputCode, outputCode);
				OutputTextArea.setText(encrypted);
			}
		});
		btnNewButton.setBounds(211, 210, 97, 25);
		frame.getContentPane().add(btnNewButton);
		// decrypt button
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDecrypt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String password2 = password.getText();
				String input2 = InputTextArea.getText();
				String pP2 = EncryptionMain.firstString(password2); // use
																	// password
																	// plus
																	// alphabet
				String inputCodeD = EncryptionMain.createInputCodeD(pP2);
				String outputCodeD = EncryptionMain.createOutputCodeD(pP2);
				String decrypted = EncryptionMain.encrypt(input2, inputCodeD, outputCodeD);
				OutputTextArea.setText(decrypted);

			}
		});
		btnDecrypt.setBounds(348, 210, 97, 25);
		frame.getContentPane().add(btnDecrypt);

	}
}
