package BankingSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {
    protected Bank bank;
    private JTextField customerIdField, nameField, addressField, phoneNumberField, emailField;
    private JTextField accountIdField, initialBalanceField, transactionAmountField;
    private JList<String> customerLists, accountList;
    private DefaultListModel<String> customerListModel, accountListModel;
    private JButton addCustomerButton, removeCustomerButton, addAccountButton, removeAccountButton, transactionButton, viewAccountsButton;
    private JLabel headingLabel;
    private JLabel customerDetails, customerIdLabel, customerNameLabel, customerAddressLabel, customerPhoneNoLabel, customerEmailLabel;
    private JLabel accountDetails, accountIdLabel, initialBalanceLabel;
    private JLabel transactionDetails, transactionAmountLabel;
    private JLabel registeredAccountsLabel;
    private ImageIcon backgroundImage;
    private JButton dataSaveButton;
    

    public MainFrame() {
        this.bank = new Bank();
        initialize();

        // Set the background image
        String imagePath = "C:/Users/Lenovo/Desktop/image5.jpg";
        backgroundImage = new ImageIcon(imagePath);

        // Set the custom panel with the background image as the content pane
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        setContentPane(backgroundPanel);
        
        // Initialize and add components
        initializeComponents();
        
        addCustomerButton.addActionListener(this);
        viewAccountsButton.addActionListener(this);
        removeCustomerButton.addActionListener(this);
        
        addAccountButton.addActionListener(this);
        removeAccountButton.addActionListener(this);
        transactionButton.addActionListener(this);
        dataSaveButton.addActionListener(this);  
    }

    public void initialize() {
        this.setTitle("Online Banking System");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        this.setLayout(null);

        headingLabel = new JLabel("<_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_> Online Banking System _><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_><_> ");
        headingLabel.setBounds(15, 00, 1280, 20);

        customerDetails = new JLabel("<=><=><=><=><=><=><=><=><=><=> Customer Details <=><=><=><=><=><=><=><=><=><=>");
        customerDetails.setBounds(340, 60, 550, 20);

        customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(450, 100, 100, 20);
        customerIdField = new JTextField();
        customerIdField.setBounds(560, 100, 140, 20);

        customerNameLabel = new JLabel("Name: ");
        customerNameLabel.setBounds(465, 130, 80, 20);
        nameField = new JTextField();
        nameField.setBounds(560, 130, 140, 20);

        customerAddressLabel = new JLabel("Address: ");
        customerAddressLabel.setBounds(460, 160, 80, 20);
        addressField = new JTextField();
        addressField.setBounds(560, 160, 140, 20);

        customerPhoneNoLabel = new JLabel("Phone Number: ");
        customerPhoneNoLabel.setBounds(445, 200, 140, 20);
        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(560, 200, 140, 20);

        // For First Three Buttons
        addCustomerButton = new JButton("Add Customer");
        addCustomerButton.setBounds(350, 240, 150, 30);
        viewAccountsButton = new JButton("View Accounts");
        viewAccountsButton.setBounds(530, 240, 150, 30);
        removeCustomerButton = new JButton("Remove Customer");
        removeCustomerButton.setBounds(710, 240, 150, 30);

        // Accounts Details
        accountDetails = new JLabel("<=><=><=><=><=><=><=><=><=><=> Account Details <=><=><=><=><=><=><=><=><=><=>");
        accountDetails.setBounds(10, 300, 550, 20);
        accountIdLabel = new JLabel("Account No: ");
        accountIdLabel.setBounds(120, 350, 140, 20);
        accountIdField = new JTextField();
        accountIdField.setBounds(220, 350, 140, 20);
        initialBalanceLabel = new JLabel("Initial Balance: ");
        initialBalanceLabel.setBounds(115, 380, 140, 20);
        initialBalanceField = new JTextField();
        initialBalanceField.setBounds(220, 380, 140, 20);

        // For Second Two Buttons (Add Accounts, Remove Account)
        addAccountButton = new JButton("Add Account");
        addAccountButton.setBounds(75, 420, 150, 30);
        removeAccountButton = new JButton("Remove Account");
        removeAccountButton.setBounds(280, 420, 150, 30);

        // Lists Side
        registeredAccountsLabel = new JLabel("Registered Accounts in Bank");
        registeredAccountsLabel.setBounds(880, 300, 250, 20);

        customerListModel = new DefaultListModel<>();
        customerLists = new JList<>(customerListModel);
        JScrollPane customerScrollPane = new JScrollPane(customerLists);
        customerScrollPane.setBounds(800, 320, 150, 130);

        accountListModel = new DefaultListModel<>();
        accountList = new JList<>(accountListModel);
        JScrollPane accountScrollPane = new JScrollPane(accountList);
        accountScrollPane.setBounds(950, 320, 150, 130);
        
        
        transactionDetails=new JLabel("<=><=><=><=><=><=><=><=><=><=> Transaction Details <=><=><=><=><=><=><=><=><=><=>");
        transactionDetails.setBounds(340, 480, 560, 20);
        transactionAmountLabel = new JLabel("Transaction Amount: ");
        transactionAmountLabel.setBounds(450, 510, 200, 20);
        transactionAmountField=new JTextField();
        transactionAmountField.setBounds(580, 510, 140, 20);
        transactionButton = new JButton("Process Transaction");
        transactionButton.setBounds(495, 545, 180, 30);
        
        dataSaveButton=new JButton("Save");
        dataSaveButton.setBounds(1080, 560, 100, 30);
        dataSaveButton.setBackground(Color.YELLOW);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 50, 1280, 720);
        panel.setOpaque(false);
        
        //Adding data to the panel
        panel.add(headingLabel);
        panel.add(customerDetails);
        panel.add(customerIdLabel);
        panel.add(customerIdField);
        panel.add(customerNameLabel);
        panel.add(nameField);
        panel.add(customerAddressLabel);
        panel.add(addressField);
        panel.add(customerPhoneNoLabel);
        panel.add(phoneNumberField);

        panel.add(addCustomerButton);
        panel.add(viewAccountsButton);
        panel.add(removeCustomerButton);

        panel.add(accountDetails);
        panel.add(accountIdLabel);
        panel.add(accountIdField);
        panel.add(initialBalanceLabel);
        panel.add(initialBalanceField);

        panel.add(addAccountButton);
        panel.add(removeAccountButton);
        panel.add(registeredAccountsLabel);

        panel.add(accountScrollPane);
        panel.add(customerScrollPane);

        panel.add(transactionDetails);
        panel.add(transactionAmountLabel);
        panel.add(transactionAmountField);
        panel.add(transactionButton);
        panel.add(dataSaveButton);
        
        accountList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    String selectedAccount = accountList.getSelectedValue();
                    if (selectedAccount != null) {
                        String accountId = selectedAccount.split(" - ")[0];
                        accountIdField.setText(accountId);
                    }
                }
            }
        });
     
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == addCustomerButton) {
                String customerId = customerIdField.getText();
                String customerName = nameField.getText();
                String customerAddress = addressField.getText();
                String phoneNumber = phoneNumberField.getText();

                if (customerId.isEmpty() || customerName.isEmpty() || customerAddress.isEmpty() || phoneNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in the required fields first");
                    return;
                }
                Customer customer = new Customer(customerId, customerName, customerAddress, phoneNumber);
                bank.addCustomer(customer);
                customerListModel.addElement(customerId + " - " + customerName);
                JOptionPane.showMessageDialog(this, "Customer added successfully!");
            } else if (ae.getSource() == viewAccountsButton) {
                String selectedCustomer = customerLists.getSelectedValue();
                if (selectedCustomer != null) {
                    String customerId = selectedCustomer.split(" - ")[0];
                    Customer customer = bank.getCustomer(customerId);
                    if (customer != null) {
//                        accountListModel.clear();
                        for (Account account : customer.getAccounts()) {
                            accountListModel.addElement(account.getAccountId() + " - " + account.getBalance());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No customer selected");
                }
            } else if (ae.getSource() == removeCustomerButton) {
                String selectedCustomer = customerLists.getSelectedValue();
                if (selectedCustomer != null) {
                    String customerId = selectedCustomer.split(" - ")[0];
                    bank.removeCustomer(customerId);
                    customerListModel.removeElement(selectedCustomer);

                    // Clear the account list only if the removed customer was selected
                    if (customerIdField.getText().equals(customerId)) {
                        accountListModel.removeElement(selectedCustomer);
                        accountListModel.removeElement(customerId);
                    }

                    JOptionPane.showMessageDialog(this, "Customer removed successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "No customer selected");
                }
            } else if (ae.getSource() == addAccountButton) {
                String selectedCustomer = customerLists.getSelectedValue();
                if (selectedCustomer != null) {
                    String customerId = selectedCustomer.split(" - ")[0];
                    Customer customer = bank.getCustomer(customerId);
                    if (customer != null) {
                        String accountId = accountIdField.getText();
                        double initialBalance = Double.parseDouble(initialBalanceField.getText());
                        String accountType = "Savings"; // Example type
                        Account account = new Account(accountId, initialBalance, accountType);
                        customer.addAccount(account);
                        accountListModel.addElement(accountId + " - " + initialBalance);
                        JOptionPane.showMessageDialog(this, "Account added successfully");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No customer selected");
                }
            } else if (ae.getSource() == removeAccountButton) {
                String selectedCustomer = customerLists.getSelectedValue();
                String selectedAccount = accountList.getSelectedValue();
                if (selectedCustomer != null && selectedAccount != null) {
                    String customerId = selectedCustomer.split(" - ")[0];
                    String accountId = selectedAccount.split(" - ")[0];
                    Customer customer = bank.getCustomer(customerId);
                    if (customer != null) {
                        customer.removeAccount(accountId);
                        accountListModel.removeElement(selectedAccount);
                        JOptionPane.showMessageDialog(this, "Account removed successfully");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No customer or account selected");
                }
            } else if (ae.getSource() == transactionButton) {
                // Transaction code
                String fromAccountId = accountIdField.getText();
                Account fromAccount = bank.getAccount(fromAccountId);
                String toAccountId = JOptionPane.showInputDialog("Enter Destination Account ID: ");
                Account toAccount = bank.getAccount(toAccountId);

                System.out.println("From Account ID: " + fromAccountId);
                System.out.println("To Account ID: " + toAccountId);

                if (fromAccountId.equals(toAccountId)) {
                    JOptionPane.showMessageDialog(this, "Cannot transfer to the same account.");
                } else if (fromAccount != null && toAccount != null) {
                    double amount = Double.parseDouble(transactionAmountField.getText());
                    TransactionThread transaction = new TransactionThread(fromAccount, toAccount, amount);
                    bank.processTransaction(transaction);
                    JOptionPane.showMessageDialog(this, "Transaction processed successfully");
                    saveDataToFile(); // Save data after processing transaction
                } else {
                    JOptionPane.showMessageDialog(this, "Error! Account not Found.");
                }
            } else if (ae.getSource() == dataSaveButton) {
                saveDataToFile();
                JOptionPane.showMessageDialog(this, "Data saved in File on Desktop Location in (Bank Data) Folder!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
        }
    }

    private void saveDataToFile() {
        String path = "C://Users//lenovo//Desktop//Bank_Data.txt";
        StringBuilder data = new StringBuilder();

        data.append("\n\t\t\t\t\t\t\t\tCustomer Details\n\n");
    
        // Adding customer details
        for (int i = 0; i < customerListModel.getSize(); i++) {
            String customerInfo = customerListModel.getElementAt(i);
            String[] customerDetails = customerInfo.split(" - ");
            Customer customer = bank.getCustomer(customerDetails[0]);
            data.append("Customer ID: "+customer.getCustomerId()).append("\t|\t")
                .append("Customer Name: "+customer.getCustomerName()).append("\t|\t")
                .append("Phone Number: "+customer.getPhoneNumber()).append("\t|\t")
                .append("Adress: "+customer.getCustomerAddress())
                .append("\n");
        }
        data.append("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        data.append("\n\t\t\t\t\t\t\t\tAccount Details\n");
        for (int i = 0; i < accountListModel.getSize(); i++) {
            String accountInfo = accountListModel.getElementAt(i);
            String[] accountDetails = accountInfo.split(" - ");
            Account account = bank.getAccount(accountDetails[0]);
            data.append("\t\t\t\t\t\tAccount ID: "+account.getAccountId()).append("\t|\t")
                .append("Balance: "+account.getBalance())
                .append("\n");
        }
        data.append("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------");
        data.append("\n\t\t\t\t\t\t\t\tTransaction Details\n\n");
        for (TransactionThread transaction : bank.getTransactions()) {
    	data.append("Transaction Amount: ").append(transaction.getAmount()).append("\t|\t")
            .append("From Account No: ").append(transaction.getFromAccount().getAccountId()).append("\t|\t")
            .append("To Account No: ").append(transaction.getToAccount().getAccountId()).append("\t|\t")
            .append("Date and Time: (").append(transaction.getFormattedDate()).append(")\n");
        }
        File file = new File(path);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}