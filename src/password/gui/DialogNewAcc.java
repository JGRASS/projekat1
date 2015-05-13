package password.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import password.Password;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class DialogNewAcc extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldAccount;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private Password pw;
	private JLabel lblErrorAccount;
	private JLabel lblErrorUsername;
	private JLabel lblErrorPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogNewAcc dialog = new DialogNewAcc();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogNewAcc() {
		setTitle("New account");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAccountName = new JLabel("Account name");
		lblAccountName.setBounds(10, 52, 82, 14);
		contentPanel.add(lblAccountName);
		
		textFieldAccount = new JTextField();
		textFieldAccount.setBounds(102, 49, 116, 20);
		contentPanel.add(textFieldAccount);
		textFieldAccount.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 80, 82, 14);
		contentPanel.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(102, 77, 116, 20);
		contentPanel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 108, 82, 14);
		contentPanel.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(102, 105, 116, 20);
		contentPanel.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		lblErrorAccount = new JLabel("You must enter account name.");
		lblErrorAccount.setForeground(Color.RED);
		lblErrorAccount.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		lblErrorAccount.setVisible(false);
		lblErrorAccount.setBounds(228, 52, 206, 14);
		contentPanel.add(lblErrorAccount);
		
		lblErrorUsername = new JLabel("You must enter a username.");
		lblErrorUsername.setForeground(Color.RED);
		lblErrorUsername.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		lblErrorUsername.setVisible(false);
		lblErrorUsername.setBounds(228, 80, 206, 14);
		contentPanel.add(lblErrorUsername);
		
		lblErrorPassword = new JLabel("You must enter a password.");
		lblErrorPassword.setForeground(Color.RED);
		lblErrorPassword.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		lblErrorPassword.setVisible(false);
		lblErrorPassword.setBounds(228, 108, 206, 14);
		contentPanel.add(lblErrorPassword);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						lblErrorAccount.setVisible(false);
						lblErrorPassword.setVisible(false);
						lblErrorUsername.setVisible(false);
						boolean okay = false;
						while (!okay) {
							pw = new Password();
							try {
								pw.setAccount(textFieldAccount.getText());
							} catch (Exception e1) {
								lblErrorAccount.setVisible(true);
							}
							try {
								pw.setPassword(textFieldPassword.getText());
							} catch (Exception e1) {
								lblErrorPassword.setVisible(true);
							}
							try {
								pw.setUsername(textFieldUsername.getText());
							} catch (Exception e1) {
								lblErrorUsername.setVisible(true);
							}
							if (pw.getAccount() != null && pw.getPassword() != null && pw.getUsername() != null) {
								okay = true;
							}
						}
						if(okay)
							setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public Password returnPassword(){
		setVisible(true);
		dispose();
		return pw;
	}
}
