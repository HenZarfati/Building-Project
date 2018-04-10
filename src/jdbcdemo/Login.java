package jdbcdemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Login {

	private JFrame frmLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 966, 880);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel label1 = new JLabel("Username:");
		label1.setFont(new Font("Tahoma", Font.BOLD, 28));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(50, 184, 208, 75);
		frmLogin.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Password:");
		label2.setFont(new Font("Tahoma", Font.BOLD, 28));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(50, 281, 208, 75);
		frmLogin.getContentPane().add(label2);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 28));
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		txtUsername.setBounds(271, 202, 264, 39);
		frmLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 28));
		txtPassword.setBounds(271, 299, 264, 39);
		frmLogin.getContentPane().add(txtPassword);
		
		lblNewLabel = new JLabel("Login Building System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(106, 28, 720, 96);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 152, 853, 6);
		frmLogin.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(26, 439, 867, 2);
		frmLogin.getContentPane().add(separator_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				if (password.contains("123456") && username.contains("Hen")||username.contains("Hai")||username.contains("Efi")) {
					txtUsername.setText(null);	
					txtPassword.setText(null);
					Table obj =new Table();
					JOptionPane.showMessageDialog(null, "you Loged in! Welcome!");
					frmLogin.setVisible(false);
					obj.frmBuildingMenu.setVisible(true);
				}
				else
				{
//					JOptionPane.setFont(new Font("Tahoma", Font.BOLD, 30));
					JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					txtUsername.setText(null);	
					txtPassword.setText(null);	
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogin.setBounds(58, 469, 171, 60);
		frmLogin.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);	
				txtPassword.setText(null);	
				}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnReset.setBounds(271, 469, 171, 60);
		frmLogin.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnExit.setBounds(480, 469, 171, 60);
		frmLogin.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\\u05DC\u05D9\u05DE\u05D5\u05D3\u05D9\u05DD \u05DE\u05D3\u05DE\u05D7\\\u05E4\u05D9\u05EA\u05D5\u05D7 \u05D9\u05D9\u05E9\u05D5\u05DE\u05D9\u05DD \u05DC\u05D8\u05DC\u05E4\u05D5\u05E0\u05D9\u05DD \u05E0\u05D9\u05D9\u05D3\u05D9\u05DD\\Icons\\PassUser.png"));
		lblNewLabel_1.setBounds(611, 184, 200, 212);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\\u05DC\u05D9\u05DE\u05D5\u05D3\u05D9\u05DD \u05DE\u05D3\u05DE\u05D7\\\u05E4\u05D9\u05EA\u05D5\u05D7 \u05D9\u05D9\u05E9\u05D5\u05DE\u05D9\u05DD \u05DC\u05D8\u05DC\u05E4\u05D5\u05E0\u05D9\u05DD \u05E0\u05D9\u05D9\u05D3\u05D9\u05DD\\Icons\\build7.jpg"));
		lblNewLabel_2.setBounds(677, 463, 257, 234);
		frmLogin.getContentPane().add(lblNewLabel_2);
	}
}
