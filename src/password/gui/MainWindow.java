package password.gui;

import password.gui.DialogNewAcc;
import password.Password;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private LinkedList<Password> passwordList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setResizable(false);
		setTitle("Password Vault");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 323);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem menuItem = new JMenuItem("Save");
		mnFile.add(menuItem);
		
		JMenuItem mntmSignOut = new JMenuItem("Sign out");
		mnFile.add(mntmSignOut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnEdit.add(mntmDelete);
		
		JMenuItem mntmClearAll = new JMenuItem("Clear all");
		mnEdit.add(mntmClearAll);
		
		JMenuItem mntmEditEntry = new JMenuItem("Edit entry");
		mnEdit.add(mntmEditEntry);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 50, 424, 20);
		contentPane.add(comboBox);
		
		final JLabel lblYouHaveAlready = new JLabel("You have already saved this entry.");
		lblYouHaveAlready.setVisible(false);
		lblYouHaveAlready.setBounds(91, 19, 182, 20);
		contentPane.add(lblYouHaveAlready);
		
		final JButton btnOk = new JButton("OK");
		btnOk.setVisible(false);
		btnOk.setBounds(272, 18, 124, 23);
		contentPane.add(btnOk);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 76, 68, 23);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 110, 68, 23);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(88, 76, 200, 23);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(88, 110, 196, 23);
		contentPane.add(label);
		
		JCheckBox chckbxShow = new JCheckBox("Show");
		chckbxShow.setBounds(6, 140, 105, 23);
		contentPane.add(chckbxShow);
		
		JButton btnNewButton = new JButton("Delete entry");
		btnNewButton.setBounds(10, 170, 152, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear all entries");
		btnNewButton_1.setBounds(10, 204, 152, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnAddNewEntry = new JButton("Add new entry");
		btnAddNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblYouHaveAlready.setVisible(false);
				btnOk.setVisible(false);
				DialogNewAcc newAccount = new DialogNewAcc();
				newAccount.setVisible(true);
				Password pass = newAccount.returnPassword();
				if (pass.getAccount() != null && pass.getPassword() != null
						&& pass.getUsername() != null) {
					if (passwordList == null) {
						passwordList = new LinkedList<Password>();
					}
					if (passwordList.contains(pass)) {
						lblYouHaveAlready.setVisible(true);
						btnOk.setVisible(true);
					} else {
						passwordList.add(pass);
						comboBox.addItem(pass.getAccount());
						comboBox.setSelectedItem(pass.getAccount());
					}
				}
			}
		});
		btnAddNewEntry.setBounds(172, 170, 152, 23);
		contentPane.add(btnAddNewEntry);
		
		JButton btnNewButton_2 = new JButton("Edit ");
		btnNewButton_2.setBounds(172, 204, 152, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblYouAreLogged = new JLabel("You are logged in as:");
		lblYouAreLogged.setBounds(10, 238, 424, 25);
		contentPane.add(lblYouAreLogged);
		lblYouAreLogged.setText(lblYouAreLogged.getText() +" "+WelcomeScreen.proslediKorisnika());
	}
}
