import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class Invoice extends JFrame {
    // INITIALIZE PANELS
    JPanel mainPnl;
    JPanel addressPnl;
    JPanel userChoicePnl;
    JPanel controlPnl;
    JPanel invoicePnl;

    // INITIALIZE TEXT AREA FOR CHOICE PANEL
    JPanel userItemChoicePnl;
    JComboBox itemSelector;
    JLabel labelForItemSelector;

    JPanel userQuantityChoicePnl;
    JComboBox quantitySelector;
    JLabel labelForQuantitySelector;

    int itemIndex;
    String item;
    double itemPrice;
    int quantity;
    LineItem lineItem;
    String alignedItem;
    ArrayList<LineItem> lineItems = new ArrayList<>();

    JButton saveItemBtn;

    Product one = new Product("Blender", 39.99);
    Product two = new Product("Car Vacuum", 49.99);
    Product three = new Product("Digital Food Scale", 19.99);
    Product four = new Product("Hair Dryer", 21.99);
    Product five = new Product("Hand Mixer", 22.99);
    Product six = new Product("Ice Cream Maker", 35.99);
    Product seven = new Product("Toaster", 34.99);

    // INITIALIZE VARIABLES FOR ADDRESS PANEL
    Address address;
    Product product;

    JLabel nameLbl;
    JTextArea nameTA;
    JPanel namePnl;
    String name;

    JPanel streetPnl;
    JLabel streetLbl;
    JTextArea streetTA;
    String street;

    JPanel cityPnl;
    JLabel cityLbl;
    JTextArea cityTA;
    String city;

    JPanel statePnl;
    JLabel stateLbl;
    JTextArea stateTA;
    String state;

    JPanel zipCodePnl;
    JLabel zipCodeLbl;
    JTextArea zipCodeTA;
    String zipCode;

    // INITIALIZE QUIT AND DISPLAY CHOICES BUTTON
    JButton getInvoiceBtn;
    JButton clearChoicesBtn;
    JButton quitBtn;

    // VARIABLES FOR CALCULATING AND PRINTING RECEIPT
    JTextArea invoiceTA;
    JScrollPane scrollbar;
    double totalCost = 0.0;
    String invoice;



    public Invoice() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(4,1));

        createUserChoicePnl();
        mainPnl.add(userChoicePnl);

        createAddressPnl();
        mainPnl.add(addressPnl);

        createControlPnl();
        mainPnl.add(controlPnl);

        createInvoicePnl();
        mainPnl.add(invoicePnl);

        add(mainPnl);
        {
            // CENTER FRAME IN SCREEN...CODE ADAPTED FROM CAY HORSTMANN
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int screenHeight = screenSize.height;
            int screenWidth = screenSize.width;

            setSize(screenWidth / 5, screenHeight / 2);
            double twoPointFive = 2.5;
            setLocation((int) (screenWidth / twoPointFive), screenHeight / 4);


            setTitle("Create an Invoice");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame invoiceFrame = new Invoice();
            }
        });
    }

    private void createAddressPnl() {
        addressPnl = new JPanel();
        addressPnl.setBorder(new TitledBorder(new EtchedBorder(), "Address"));
        addressPnl.setLayout(new GridLayout(5, 1));

        nameTA = new JTextArea(1, 22);
        nameLbl = new JLabel("Name:");
        namePnl = new JPanel();
        namePnl.add(nameLbl);
        namePnl.add(nameTA);

        streetTA = new JTextArea(1, 22);
        streetLbl = new JLabel("Street:");
        streetPnl = new JPanel();
        streetPnl.add(streetLbl);
        streetPnl.add(streetTA);

        cityTA = new JTextArea(1, 23);
        cityLbl = new JLabel("City:");
        cityPnl = new JPanel();
        cityPnl.add(cityLbl);
        cityPnl.add(cityTA);

        stateTA = new JTextArea(1, 22);
        stateLbl = new JLabel("State:");
        statePnl = new JPanel();
        statePnl.add(stateLbl);
        statePnl.add(stateTA);

        zipCodeTA = new JTextArea(1, 20);
        zipCodeLbl = new JLabel("ZIP Code:");
        zipCodePnl = new JPanel();
        zipCodePnl.add(zipCodeLbl);
        zipCodePnl.add(zipCodeTA);

        addressPnl.add(namePnl);
        addressPnl.add(streetPnl);
        addressPnl.add(cityPnl);
        addressPnl.add(statePnl);
        addressPnl.add(zipCodePnl);
    }

    private void createUserChoicePnl() {
        userChoicePnl = new JPanel();
        userChoicePnl.setBorder(new TitledBorder(new EtchedBorder(),"Order"));
        userChoicePnl.setLayout(new GridLayout(3, 1));

        userItemChoicePnl = new JPanel();
        userItemChoicePnl.setLayout(new GridLayout(1, 2));

        labelForItemSelector = new JLabel("Select Item:");
        itemSelector = new JComboBox();

        itemSelector.addItem("--Select--");
        itemSelector.addItem(one.getName() + "\t\t\t" + one.getUnitPrice());
        itemSelector.addItem(two.getName() + "\t\t\t" + two.getUnitPrice());
        itemSelector.addItem(three.getName() + "\t" + three.getUnitPrice());
        itemSelector.addItem(four.getName() + "\t\t" + four.getUnitPrice());
        itemSelector.addItem(five.getName() + "\t\t" + five.getUnitPrice());
        itemSelector.addItem(six.getName() + "\t" + six.getUnitPrice());
        itemSelector.addItem(seven.getName() + "\t\t\t" + seven.getUnitPrice());


        userItemChoicePnl.add(labelForItemSelector);
        userItemChoicePnl.add(itemSelector);

        userQuantityChoicePnl = new JPanel();
        userQuantityChoicePnl.setLayout(new GridLayout(1, 2));

        labelForQuantitySelector = new JLabel("Select Quantity:");
        quantitySelector = new JComboBox();
        quantitySelector.addItem("--Select--");
        for (int index = 1; index <= 100; index++) {
            quantitySelector.addItem(index);
        }

        userQuantityChoicePnl.add(labelForQuantitySelector);
        userQuantityChoicePnl.add(quantitySelector);

        saveItemBtn = new JButton("Save Current Item to List");
        saveItemBtn.addActionListener((ActionEvent ae) -> {
            if (itemSelector.getSelectedIndex() > 0 && quantitySelector.getSelectedIndex() > 0) {
                saveLineItem();
                clearItemAndQuantityChoices();
            }
            else {
                JOptionPane.showMessageDialog(null, "Please select both item and quantity.");
            }
        });

        userChoicePnl.add(userItemChoicePnl);
        userChoicePnl.add(userQuantityChoicePnl);
        userChoicePnl.add(saveItemBtn);
    }

    private void createControlPnl() {
        controlPnl = new JPanel();
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(),"Next Steps"));

        getInvoiceBtn = new JButton("Get Invoice");
        getInvoiceBtn.addActionListener(
                (ActionEvent ae) -> {
                    if (nameTA.getText().isEmpty() || streetTA.getText().isEmpty() || cityTA.getText().isEmpty() || stateTA.getText().isEmpty() || zipCodeTA.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all the address fields.");
                    }
                    else {
                        if (lineItems.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please save items to your\nlist to get an invoice.");
                        }
                        else {
                            formulateAddress();
                            calculateCostAndDisplayInvoice();
                            clearItemAndQuantityChoices();
                            lineItems.clear();
                        }
                    }
                });

        clearChoicesBtn = new JButton("Clear Choices");
        clearChoicesBtn.addActionListener((ActionEvent ae) -> {
            clearAddressChoices();
            clearItemAndQuantityChoices();
            lineItems.clear();
        });

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> {
            int userOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "CONFIRM QUIT", JOptionPane.YES_NO_OPTION);
            if (userOption == YES_OPTION) {
                System.exit(0);
            }
            if (userOption == NO_OPTION) {
            }
        });

        controlPnl.add(getInvoiceBtn);
        controlPnl.add(clearChoicesBtn);
        controlPnl.add(quitBtn);
    }

    private void calculateCostAndDisplayInvoice() {
        // Generate a result string and then display it with a Message Dialog
        invoice = "==================    INVOICE    ===================\n";
        invoice += address.formatAddress() + "\n";
        invoice += "================================================\n";
        invoice += "Item\t\tQty\tPrice\tTotal\n";
        totalCost = 0.0;
        for (int i = 0; i < lineItems.size(); i++) {
            lineItem = lineItems.get(i);
            alignedItem = lineItem.lineItemToTabularAlignment();
            invoice += alignedItem + "\n";
            totalCost += lineItem.getCalculatedTotal();
        }
        invoice += "================================================\n";
        invoice += "AMOUNT DUE: " + totalCost;

        invoiceTA.append(invoice);
    }

    private void createInvoicePnl() {
        invoicePnl = new JPanel();
        invoicePnl.setLayout(new BorderLayout());
        invoicePnl.setBorder(new TitledBorder(new EtchedBorder(),"Invoice"));
        invoiceTA = new JTextArea(3, 28);
        invoiceTA.setEditable(false);
        invoiceTA.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        scrollbar = new JScrollPane(invoiceTA);
        invoicePnl.add(scrollbar, BorderLayout.CENTER);
    }

    private void clearAddressChoices() {
        nameTA.setText("");
        streetTA.setText("");
        cityTA.setText("");
        stateTA.setText("");
        zipCodeTA.setText("");
    }

    private void clearItemAndQuantityChoices() {
        itemSelector.setSelectedIndex(0);
        quantitySelector.setSelectedIndex(0);
    }

    private void formulateAddress() {
        name = nameTA.getText();
        street = streetTA.getText();
        city = cityTA.getText();
        state = stateTA.getText();
        zipCode = zipCodeTA.getText();

        address = new Address(name, street, city, state, zipCode);
    }

    private void saveLineItem() {
        itemIndex = itemSelector.getSelectedIndex();
        if (itemIndex == 1) {
            product = one;
        }
        else if (itemIndex == 2) {
            product = two;
        }
        else if (itemIndex == 3) {
            product = three;
        }
        else if (itemIndex == 4) {
            product = four;
        }
        else if (itemIndex == 5) {
            product = five;
        }
        else if (itemIndex == 6) {
            product = six;
        }
        else if (itemIndex == 7) {
            product = seven;
        }
        quantity = quantitySelector.getSelectedIndex();
        lineItem = new LineItem(product, quantity);
        lineItems.add(lineItem);
    }
}