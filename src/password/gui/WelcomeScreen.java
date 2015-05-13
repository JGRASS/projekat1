package password.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import password.User;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class WelcomeScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername1;
	private JLabel lblPassword;
	private JPasswordField passwordField1;
	private JTextField textFieldUsername2;
	private JPasswordField passwordField2;
	private JPasswordField passwordFieldConfirm;

	public LinkedList<User> users = new LinkedList<User>();
	public static String user;
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
		final JLabel lblPleaseSingIn = new JLabel(
				"Please sing in with an existing account. ");
		lblPleaseSingIn.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblPleaseSingIn.setVisible(false);
		lblPleaseSingIn.setBounds(312, 56, 247, 14);
		contentPane.add(lblPleaseSingIn);

		final JLabel lblIfYouDont = new JLabel(
				"If you don't have an account, sing up.");
		lblIfYouDont.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblIfYouDont.setVisible(false);
		lblIfYouDont.setBounds(312, 87, 247, 14);
		contentPane.add(lblIfYouDont);

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

		final JLabel lblPasswordsDontMatch = new JLabel(
				"Passwords don't match!");
		lblPasswordsDontMatch.setVisible(false);
		lblPasswordsDontMatch
				.setFont(new Font("Trebuchet MS", Font.ITALIC, 13));
		lblPasswordsDontMatch.setForeground(Color.RED);
		lblPasswordsDontMatch.setBounds(163, 285, 174, 23);
		contentPane.add(lblPasswordsDontMatch);

		final JLabel lblUserAlreadyExists = new JLabel("User already exists!");
		lblUserAlreadyExists.setVisible(false);
		lblUserAlreadyExists.setFont(new Font("Trebuchet MS", Font.ITALIC, 13));
		lblUserAlreadyExists.setForeground(Color.RED);
		lblUserAlreadyExists.setBounds(312, 223, 146, 20);
		contentPane.add(lblUserAlreadyExists);
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ispisiKorisnike();
				users = deserialize(Utility.getDir("resources\\fajl"));
				ispisiKorisnike();
				if (textFieldUsername1.getText() != null
						&& !(textFieldUsername1.getText().isEmpty())
						&& passwordField1.getText() != null
						&& !(passwordField1.getText().isEmpty())) {
					User singIn = new User();
					singIn.setName(textFieldUsername1.getText());
					singIn.setPassword(passwordField1.getText());
					if (users.contains(singIn)) {
						user = textFieldUsername1.getText();
						MainWindow mw = new MainWindow();
						mw.setVisible(true);
					} else {
						lblPleaseSingIn.setVisible(true);
						lblIfYouDont.setVisible(true);
					}
				}

			}
		});
		btnSignIn.setBounds(166, 115, 89, 23);
		contentPane.add(btnSignIn);
		final JLabel lblYouMustEnter = new JLabel(
				"You must enter a valid usrername.");
		lblYouMustEnter.setVisible(false);
		lblYouMustEnter.setForeground(Color.RED);
		lblYouMustEnter.setFont(new Font("Trebuchet MS", Font.ITALIC, 13));
		lblYouMustEnter.setBounds(312, 193, 247, 23);
		contentPane.add(lblYouMustEnter);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				lblYouMustEnter.setVisible(false);
				lblPasswordsDontMatch.setVisible(false);
				if (textFieldUsername2.getText() != null
						&& !textFieldUsername2.getText().isEmpty()
						&& !passwordField2.getText().isEmpty()
						&& passwordField2.getText().equals(
								passwordFieldConfirm.getText())) {
					User newUser = new User();
					newUser.setName(textFieldUsername2.getText());
					newUser.setPassword(passwordField2.getText());
					if (users.contains(newUser)) {
						lblUserAlreadyExists.setVisible(true);
						return;
					} else {
						users.add(newUser);
						user = newUser.getName();
						serialize(Utility.getDir("resources") + "\\fajl");
						ispisiKorisnike();
						MainWindow mw = new MainWindow();
						mw.setVisible(true);
					}
				}
				if (!passwordField2.getText().equals(
						passwordFieldConfirm.getText())) {
					lblPasswordsDontMatch.setVisible(true);
				}
				if (textFieldUsername2.getText() == null
						|| textFieldUsername2.getText().isEmpty()) {
					lblYouMustEnter.setVisible(true);
				}
			}
		});
		btnSignUp.setBounds(312, 254, 89, 23);
		contentPane.add(btnSignUp);

	}

	private void serialize(String filename) {
		File f = new File(filename);
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(f));
			out.writeObject(users);
		} catch (Exception e) {
		}
	}

	private void ispisiKorisnike() {
		if(users.isEmpty()){
			System.out.println("Lista je prazna");
			return;
		}
		for (int i = 0; i < users.size(); i++) {
			User korisnik = users.get(i);
			System.out.println(korisnik.getName() + "\n"
					+ korisnik.getPassword());
		}
	}

	@SuppressWarnings("unchecked")
	private LinkedList<User> deserialize(String filename) {
		File f = new File(filename);
		LinkedList<User> passwordList = new LinkedList<User>();
		try {
			@SuppressWarnings("resource")
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			passwordList = (LinkedList<User>) in.readObject();
		} catch (Exception e) {
		}
		return passwordList;
	}
	public static String proslediKorisnika(){
		return user;
	}
}
