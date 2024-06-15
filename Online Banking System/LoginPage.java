package BankingSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

 						//Defining LoginPage Class for Displaying the first login page to the end-user!
public class LoginPage extends JFrame implements ActionListener{
		private JLabel userNameLabel, passwordLabel , emailLabel;
		private JTextField userNameTextField, emailTextField;
		public JButton login;
		private JPasswordField password;
		private ImageIcon backgroundImage1;
		public BackgroundPanel backgroundPanel;
		private MainFrame nextFrame;
							// No argument constructor of LoginPage class
		public LoginPage() {
			this.setTitle("Login Page");
			this.setSize(1280,720);
	        this.setLayout(null);
			backgroundImage1=new ImageIcon();
			String imagePath="C:/Users/Lenovo/Desktop/image6.jpg";
	        backgroundImage1=new ImageIcon(imagePath);

	        backgroundPanel = new BackgroundPanel(backgroundImage1);
	        setContentPane(backgroundPanel);
	        initializeComponents();
		}
		
		public void initializeComponents() {	
			userNameLabel=new JLabel("User Name: ");
			userNameLabel.setBounds(180, 280, 100, 20);
			userNameTextField=new JTextField();
			userNameTextField.setBounds(280, 280, 150, 25);
			
			emailLabel=new JLabel("Email: ");
			emailLabel.setBounds(190, 320, 100, 20);
			emailTextField=new JTextField();
			emailTextField.setBounds(280, 320, 150, 25);
			
			passwordLabel=new JLabel("Password: ");
			passwordLabel.setBounds(180, 360, 100, 20);
			
			password=new JPasswordField();
			password.setBounds(280, 360, 150, 25);
			
			login=new JButton("Login");
			login.setBounds(450, 315, 150, 35);
			login.addActionListener(this);
			
			
			backgroundPanel.add(userNameLabel);
			backgroundPanel.add(userNameTextField);
			backgroundPanel.add(emailLabel);
			backgroundPanel.add(emailTextField);
			backgroundPanel.add(passwordLabel);
			backgroundPanel.add(password);
			backgroundPanel.add(login);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String path="C://Users//lenovo//Desktop//Login_System.txt";
			char[] pas=password.getPassword();
			String converter=new String(pas);
			String data= "User Name: "+userNameTextField.getText()+"\nEmail Adress: "+emailTextField.getText()
						+"\nPassword: "+converter+"\n-----------------------------------------\n\n";
			
			File f=new File(path);
			FileOutputStream fos=null;
			byte[] getdata=data.getBytes();
			try {
				if(converter.equals("New User")) {
					JOptionPane.showMessageDialog(this, "Login Successfull! Please press (Ok).","Sucess",JOptionPane.INFORMATION_MESSAGE);
					nextFrame=new MainFrame();
					nextFrame.setVisible(true);
					this.dispose();
					fos=new FileOutputStream(path,true);
					fos.write(getdata);
				}else
					JOptionPane.showMessageDialog(this, "Login unsucessfull please Enter valid password.","Error",JOptionPane.INFORMATION_MESSAGE);	
			}catch(IOException ie) {
				ie.printStackTrace();
			}
		}
}


