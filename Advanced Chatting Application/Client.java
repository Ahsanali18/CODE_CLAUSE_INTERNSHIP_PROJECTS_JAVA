package chattingApplication;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Client implements ActionListener{
    JTextField text;
    static JPanel chatPanel;
    static DataOutputStream dout;
    static Box vertical = Box.createVerticalBox();
    static JFrame frame = new JFrame();
    static JLabel document;
    JFrame loginFrame;
    JButton login;
    JTextField firstName, lastName, phoneNumber;
    JPasswordField password;
    String clientName;
    
    public Client() {
        loginSystem();
    }
    
    private void loginSystem() {
        loginFrame = new JFrame("Client Login");
        loginFrame.setLayout(null);
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBackground(new Color(7, 94, 84));
        headerPanel.setBounds(0, 0, 450, 130);
        loginFrame.add(headerPanel);

        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("icons/whatsapp.png"));
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
            clientName = userFirstName;

            // Start the client after successful login and then close the login frame
            loginFrame.dispose();
            chattingSystem(clientName);  // Pass the client's name to the chattingSystem method
        } else {
            sendMessage();
        }
    }
    private void chattingSystem(String clientName) {
        frame.setLayout(null);
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBackground(new Color(7, 94, 84));
        headerPanel.setBounds(0, 0, 450, 70);
        frame.add(headerPanel);

        ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/back.png"));
        Image backImg = backIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon backImgIcon = new ImageIcon(backImg);
        JLabel back = new JLabel(backImgIcon);
        back.setBounds(5, 20, 25, 25);
        headerPanel.add(back);

        ImageIcon profileIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/profile2.png"));
        Image profileImg = profileIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon profileImgIcon = new ImageIcon(profileImg);
        JLabel profile = new JLabel(profileImgIcon);
        profile.setBounds(40, 10, 50, 50);
        headerPanel.add(profile);

        ImageIcon videoIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/video.png"));
        Image videoImg = videoIcon.getImage().getScaledInstance(30, 28, Image.SCALE_DEFAULT);
        ImageIcon videoImgIcon = new ImageIcon(videoImg);
        JLabel video = new JLabel(videoImgIcon);
        video.setBounds(300, 20, 30, 28);
        headerPanel.add(video);

        ImageIcon phoneIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/phone.png"));
        Image phoneImg = phoneIcon.getImage().getScaledInstance(35, 38, Image.SCALE_DEFAULT);
        ImageIcon phoneImgIcon = new ImageIcon(phoneImg);
        JLabel phone = new JLabel(phoneImgIcon);
        phone.setBounds(360, 20, 35, 28);
        headerPanel.add(phone);

        ImageIcon moreIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/3icon.png"));
        Image moreImg = moreIcon.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon moreImgIcon = new ImageIcon(moreImg);
        JLabel morevert = new JLabel(moreImgIcon);
        morevert.setBounds(420, 20, 6, 28);
        headerPanel.add(morevert);

        JLabel name = new JLabel(clientName);  // Use the client's name
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

        ImageIcon pictureIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/pictureImage.png"));
        Image pictureImg = pictureIcon.getImage().getScaledInstance(40, 33, Image.SCALE_DEFAULT);
        ImageIcon pictureImgIcon = new ImageIcon(pictureImg);
        JLabel picture = new JLabel(pictureImgIcon);
        picture.setBounds(315, 560, 40, 33);
        frame.add(picture);

        ImageIcon docIcon = new ImageIcon(getClass().getClassLoader().getResource("icons/document.png"));
        Image docImg = docIcon.getImage().getScaledInstance(40, 33, Image.SCALE_DEFAULT);
        ImageIcon docImgIcon = new ImageIcon(docImg);
        document = new JLabel(docImgIcon);
        document.setBounds(355, 560, 40, 33);
        document.setEnabled(false);
        frame.add(document);

        JButton send = new JButton(">");
        send.setBounds(397, 562, 50, 33);
        send.setBackground(new Color(7, 94, 84));
        send.setFont(new Font("SAN_SARIF", Font.BOLD, 25));
        send.setForeground(Color.white);
        send.addActionListener(this);
        frame.add(send);

        frame.setUndecorated(true);
        frame.setSize(450, 600);
        frame.setLocation(800, 50);
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
        connectToServer();
    }

    private void connectToServer() {
        new Thread(() -> {
            try {
                Socket s = new Socket("127.0.0.1", 6001);
                DataInputStream din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                document.setEnabled(true); // Enable the document icon once connected

                while (true) {
                    String msg = din.readUTF();
                    if (msg.equals("DOCUMENT")) {
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
                        vertical.add(Box.createVerticalStrut(15));

                        chatPanel.add(vertical, BorderLayout.PAGE_START);
                        frame.validate();
                    } else {
                        JPanel panel = formatLabel(msg);

                        JPanel left = new JPanel(new BorderLayout());
                        left.add(panel, BorderLayout.LINE_START);
                        vertical.add(left);
                        vertical.add(Box.createVerticalStrut(15));

                        chatPanel.add(vertical, BorderLayout.PAGE_START);
                        frame.validate();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void openCamera(){
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI("https://webcamtoy.com/"));
            } else {
                System.out.println("Desktop is not supported on this platform.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Client();
    }
}
