package password.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WelcomeScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername1;
	private JLabel lblPassword;
	private JPasswordField passwordField1;
	private JTextField textFieldUsername2;
	private JPasswordField passwordField2;
	private JPasswordField passwordFieldConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen frame = new WelcomeScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomeScreen() {
		setTitle("Password Vault");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUsername1 = new JTextField();
		textFieldUsername1.setBounds(166, 53, 136, 20);
		contentPane.add(textFieldUsername1);
		textFieldUsername1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(97, 53, 59, 20);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(97, 84, 59, 20);
		contentPane.add(lblPassword);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(166, 84, 136, 20);
		contentPane.add(passwordField1);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(166, 115, 89, 23);
		contentPane.add(btnSignIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSignUp.setBounds(312, 254, 89, 23);
		contentPane.add(btnSignUp);
		
		JLabel lblSingIn = new JLabel("Sign in");
		lblSingIn.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblSingIn.setBounds(49, 11, 89, 31);
		contentPane.add(lblSingIn);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account? Sign up!");
		lblDontHaveAn.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblDontHaveAn.setBounds(49, 151, 345, 31);
		contentPane.add(lblDontHaveAn);
		
		JLabel label = new JLabel("Username");
		label.setBounds(56, 193, 100, 20);
		contentPane.add(label);
		
		textFieldUsername2 = new JTextField();
		textFieldUsername2.setColumns(10);
		textFieldUsername2.setBounds(166, 193, 136, 20);
		contentPane.add(textFieldUsername2);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(56, 224, 100, 20);
		contentPane.add(label_1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(166, 224, 136, 20);
		contentPane.add(passwordField2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setBounds(56, 255, 100, 20);
		contentPane.add(lblConfirmPassword);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(166, 255, 136, 20);
		contentPane.add(passwordFieldConfirm);
		
		JLabel lblPasswordsDontMatch = new JLabel("Passwords don't match!");
		lblPasswordsDontMatch.setVisible(false);
		lblPasswordsDontMatch.setFont(new Font("Trebuchet MS", Font.ITALIC, 13));
		lblPasswordsDontMatch.setForeground(Color.RED);
		lblPasswordsDontMatch.setBounds(166, 288, 174, 23);
		contentPane.add(lblPasswordsDontMatch);
	}
}
