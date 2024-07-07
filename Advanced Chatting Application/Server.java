package chattingApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Server implements ActionListener {
    JFrame loginFrame;
    JButton login;
    JTextField firstName, lastName, phoneNumber;
    JPasswordField password;
    JTextField text;
    static JPanel chatPanel;
    static DataOutputStream dout;
    static Box vertical = Box.createVerticalBox();
    static JFrame frame = new JFrame();
    static JLabel document;
    public String serverName;

    public Server() {
        loginSystem();
    }
    private void loginSystem() {
        loginFrame = new JFrame("Server Login");
        loginFrame.setLayout(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBackground(new Color(7, 94, 84));
        headerPanel.setBounds(0, 0, 450, 130);
        loginFrame.add(headerPanel);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/whatsapp.png"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel logo = new JLabel(i3);
        logo.setBounds(120, 2, 200, 100);
        headerPanel.add(logo);

        JLabel whatsapp = new JLabel("WhatsApp");
        whatsapp.setBounds(180, 90, 100, 18);
        whatsapp.setForeground(Color.white);
        whatsapp.setFont(new Font("SAN_SARIF", Font.BOLD, 18));
        headerPanel.add(whatsapp);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.white);
        loginPanel.setBounds(0, 130, 450, 320);
        loginFrame.add(loginPanel);

        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setBounds(100, 30, 100, 90);
        firstName = new JTextField();
        firstName.setBounds(180, 66, 130, 20);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setBounds(100, 63, 100, 90);
        lastName = new JTextField();
        lastName.setBounds(180, 100, 130, 20);

        JLabel phoneNumberLabel = new JLabel("Phone No: ");
        phoneNumberLabel.setBounds(103, 100, 100, 90);
        phoneNumber = new JTextField("+92");
        phoneNumber.setBounds(180, 137, 130, 20);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(100, 140, 100, 90);
        password = new JPasswordField();
        password.setBounds(180, 176, 130, 20);

        login = new JButton("Login");
        login.setBounds(135, 220, 140, 33);
        login.setBackground(new Color(7, 94, 84));
        login.setFont(new Font("SAN_SARIF", Font.BOLD, 25));
        login.setForeground(Color.white);
        login.addActionListener(this);

        loginPanel.add(firstNameLabel);
        loginPanel.add(firstName);
        loginPanel.add(lastNameLabel);
        loginPanel.add(lastName);
        loginPanel.add(phoneNumberLabel);
        loginPanel.add(phoneNumber);
        loginPanel.add(passwordLabel);
        loginPanel.add(password);
        loginPanel.add(login);

        loginFrame.setSize(450, 450);
        loginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String userFirstName = firstName.getText();

            // Assume login is always successful
            JOptionPane.showMessageDialog(loginFrame, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            serverName = userFirstName;

            // Start the client after successful login and then close the login frame
            loginFrame.dispose();
            chattingSystem(serverName);  // Pass the client's name to the chattingSystem method
        } else {
            sendMessage();
        }
    }
    private void chattingSystem(String serverName) {
        frame.setLayout(null);

        loginFrame = new JFrame();
        loginFrame.setLayout(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBackground(new Color(7, 94, 84));
        headerPanel.setBounds(0, 0, 450, 70);
        frame.add(headerPanel);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/back.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);
        headerPanel.add(back);

        ImageIcon i4 = new ImageIcon(getClass().getResource("/icons/profile1.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 10, 50, 50);
        headerPanel.add(profile);

        ImageIcon i7 = new ImageIcon(getClass().getResource("/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 28, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 30, 28);
        headerPanel.add(video);

        ImageIcon i10 = new ImageIcon(getClass().getResource("/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 38, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 20, 35, 28);
        headerPanel.add(phone);

        ImageIcon i13 = new ImageIcon(getClass().getResource("/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(420, 20, 6, 28);
        headerPanel.add(morevert);

        JLabel name = new JLabel(serverName);
        name.setBounds(110, 20, 100, 18);
        name.setForeground(Color.white);
        name.setFont(new Font("SAN_SARIF", Font.BOLD, 18));
        headerPanel.add(name);

        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 45, 100, 12);
        status.setForeground(Color.white);
        status.setFont(new Font("SAN_SARIF", Font.BOLD, 12));
        headerPanel.add(status);

        chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(chatPanel);
        scrollPane.setBounds(5, 75, 440, 480);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        text = new JTextField();
        text.setBounds(5, 560, 310, 40);
        frame.add(text);

        ImageIcon i16 = new ImageIcon(getClass().getResource("/icons/pictureImage.png"));
        Image i17 = i16.getImage().getScaledInstance(45, 33, Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        JLabel picture = new JLabel(i18);
        picture.setBounds(315, 562, 45, 33);
        frame.add(picture);

        ImageIcon i19 = new ImageIcon(getClass().getResource("/icons/document.png"));
        Image i20 = i19.getImage().getScaledInstance(33, 33, Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(i20);
        document = new JLabel(i21);
        document.setBounds(360, 562, 33, 33);
        document.setEnabled(false); // Initially disabled
        frame.add(document);

        // Add MouseListener to open the default camera app
        picture.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                openCamera();
            }
        });

        JButton send = new JButton(">");
        send.setBounds(396, 562, 49, 33);
        send.setBackground(new Color(7, 94, 84));
        send.setFont(new Font("SAN_SARIF", Font.BOLD, 25));
        send.setForeground(Color.white);
        send.addActionListener(this);
        frame.add(send);

        frame.setUndecorated(true);
        frame.setSize(450, 600);
        frame.setLocation(200, 50);
        frame.getContentPane().setBackground(Color.white);
        frame.setVisible(true);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.exit(0);
            }
        });

        document.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                selectAndSendDocument();
            }
        });
        // Start server socket thread
        new Thread(() -> {
            try {
                ServerSocket skt = new ServerSocket(6001);
                while (true) {
                    Socket s = skt.accept();
                    DataInputStream din = new DataInputStream(s.getInputStream());
                    dout = new DataOutputStream(s.getOutputStream());
                    document.setEnabled(true); // Enable the document icon once connected
                    while (true) {
                        String msg = din.readUTF();
                        if (msg.equals("DOCUMENT")) {
                            receiveDocument(din);
                        } else {
                            receiveMessage(msg);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    private void sendMessage() {
        try {
            String message = text.getText();
            JPanel p2 = formatLabel(message);

            JPanel rightPanel = new JPanel(new BorderLayout());
            rightPanel.add(p2, BorderLayout.LINE_END);
            vertical.add(rightPanel);
            vertical.add(Box.createVerticalStrut(10));

            chatPanel.add(vertical, BorderLayout.PAGE_START);

            if (dout != null) {
                dout.writeUTF(message);
            } else {
                System.out.println("DataOutputStream (dout) is not initialized.");
            }
            text.setText("");
            frame.repaint();
            frame.invalidate();
            frame.validate();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));

        panel.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;
    }
    private void selectAndSendDocument() {
        if (dout != null) {
            try {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    FileInputStream fileInputStream = new FileInputStream(selectedFile);
                    byte[] fileBytes = new byte[(int) selectedFile.length()];
                    fileInputStream.read(fileBytes);
                    fileInputStream.close();

                    dout.writeUTF("DOCUMENT");
                    dout.writeUTF(selectedFile.getName());
                    dout.writeInt(fileBytes.length);
                    dout.write(fileBytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void receiveDocument(DataInputStream din) throws IOException {
        String fileName = din.readUTF();
        int fileLength = din.readInt();
        byte[] fileBytes = new byte[fileLength];
        din.readFully(fileBytes);

        // Save the received document to a file
        File receivedFile = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(receivedFile);
        fileOutputStream.write(fileBytes);
        fileOutputStream.close();

        // Display the received document in the chat panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel fileLabel = new JLabel("Received document: " + fileName);
        fileLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(fileLabel);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);

        JPanel left = new JPanel(new BorderLayout());
        left.add(panel, BorderLayout.LINE_START);
        vertical.add(left);
        frame.validate();
    }
    private void receiveMessage(String msg) {
        JPanel panel = formatLabel(msg);
        JPanel left = new JPanel(new BorderLayout());
        left.add(panel, BorderLayout.LINE_START);
        vertical.add(left);
        vertical.add(Box.createVerticalStrut(15));
        chatPanel.add(vertical, BorderLayout.PAGE_START);
        frame.validate();
    }
    private void openCamera() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI("https://webcamtoy.com/"));
            } else {
                System.out.println("Desktop is not supported on this platform.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Server();
    }
}