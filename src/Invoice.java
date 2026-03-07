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
    String lineItemString;
    String alignedItem;

    ArrayList<String> lineItems = new ArrayList<>();

    JButton addAnotherItemBtn;

    ArrayList<Product> products = new ArrayList<Product>();
    Product one = new Product("Blender", 39.99);
    Product two = new Product("Car Vacuum", 49.99);
    Product three = new Product("Digital Food Scale", 19.99);
    Product four = new Product("Hair Dryer", 21.99);
    Product five = new Product("Hand Mixer", 22.99);
    Product six = new Product("Ice Cream Maker", 35.99);
    Product seven = new Product("Toaster", 34.99);

    // INITIALIZE VARIABLES FOR ADDRESS PANEL
    String address;

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
    double sizeCost;
    double toppingCost;
    double pizzaCost;
    double pizzaTax;
    double totalCost;
    String invoice;



    public Invoice() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(4,1));

        createUserChoicePanel();
        mainPnl.add(userChoicePnl);

        createAddressPnl();
        mainPnl.add(addressPnl);

        createControlPanel();
        mainPnl.add(controlPnl);

        createInvoicePanel();
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
        streetTA.setEditable(false);
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

    private void createUserChoicePanel() {
        userChoicePnl = new JPanel();
        userChoicePnl.setBorder(new TitledBorder(new EtchedBorder(),"Order"));
        userChoicePnl.setLayout(new GridLayout(3, 1));

        userItemChoicePnl = new JPanel();
        userItemChoicePnl.setLayout(new GridLayout(1, 2));

        labelForItemSelector = new JLabel("Select Item:");
        itemSelector = new JComboBox();

        itemSelector.addItem("--Select--");
        itemSelector.addItem(one.getName() + "\t\t\t" + one.getCost());
        itemSelector.addItem(two.getName() + "\t\t\t" + two.getCost());
        itemSelector.addItem(three.getName() + "\t" + three.getCost());
        itemSelector.addItem(four.getName() + "\t\t" + four.getCost());
        itemSelector.addItem(five.getName() + "\t\t" + five.getCost());
        itemSelector.addItem(six.getName() + "\t" + six.getCost());
        itemSelector.addItem(seven.getName() + "\t\t\t" + seven.getCost());


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

        addAnotherItemBtn = new JButton("Save Current Item and Add Another");
        addAnotherItemBtn.addActionListener((ActionEvent ae) -> {
            saveLineItem();
            clearItemAndQuantityChoices();
            printLineItem();
        });

        userChoicePnl.add(userItemChoicePnl);
        userChoicePnl.add(userQuantityChoicePnl);
        userChoicePnl.add(addAnotherItemBtn);
    }

    private void createControlPanel() {
        controlPnl = new JPanel();
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(),"Next Steps"));

        getInvoiceBtn = new JButton("Get Invoice");
        getInvoiceBtn.addActionListener(
                (ActionEvent ae) -> {
                    formulateAddress();
                    calculateCostAndDisplayInvoice();
                });

        clearChoicesBtn = new JButton("Clear Choices");
        clearChoicesBtn.addActionListener((ActionEvent ae) -> {
            clearItemAndQuantityChoices();
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
        invoice = "======================================\n";
        invoice += address;
        invoice += "======================================\n";
        invoice += "Item\t\tQty\tPrice\tTotal\n";
        for (int i = 0; i < lineItems.size(); i++) {
            lineItemString = lineItems.get(i);
            alignedItem = lineItem.toTabularAlignment();
        }


        // SIZE CHOICE
        // item = itemSelector.getText();
        if (quantitySelector.getSelectedIndex() == 0) { // small
            invoice += "Small Pizza, ";
            sizeCost = 8.0;
        }
        else if (quantitySelector.getSelectedIndex() == 1) { // medium
            invoice += "Medium Pizza, ";
            sizeCost = 12.0;
        }
        else if (quantitySelector.getSelectedIndex() == 2) { // large
            invoice += "Large Pizza, ";
            sizeCost = 16.0;
        }
        else if (quantitySelector.getSelectedIndex() == 3) { // super
            invoice += "Super Pizza, ";
            sizeCost = 20.0;
        }

        pizzaCost = sizeCost + toppingCost;

        invoice += "\n";
        invoice += "\n";
        invoice += "Sub-total:\t\t\t$" + pizzaCost + "\n";
        pizzaTax = pizzaCost * 0.07;
        invoice += "Tax:\t\t\t$" + pizzaTax + "\n";
        invoice += "-------------------------------------------------------------\n";
        totalCost = pizzaCost + pizzaTax;
        invoice += "Total:\t\t\t$" + totalCost + "\n";
        invoice += "======================================";
        invoiceTA.append(invoice);
    }

    private void createInvoicePanel() {
        invoicePnl = new JPanel();
        invoicePnl.setLayout(new BorderLayout());
        invoicePnl.setBorder(new TitledBorder(new EtchedBorder(),"Invoice"));
        invoiceTA = new JTextArea(3, 28);
        invoiceTA.setEditable(false);
        invoiceTA.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        scrollbar = new JScrollPane(invoiceTA);
        invoicePnl.add(scrollbar, BorderLayout.CENTER);
    }

    private void clearItemAndQuantityChoices() {
        // itemSelector.setText("");
        quantitySelector.setSelectedIndex(0);
    }

    private void formulateAddress() {
        name = nameTA.getText();
        street = streetTA.getText();
        city = cityTA.getText();
        state = stateTA.getText();
        zipCode = zipCodeTA.getText();

        address = name + "\n" + street + "\n" + city + ", " + state + " " + zipCode;
    }

    private void printLineItem() {
        invoiceTA.append(lineItem.toTabularAlignment());
    }

    private void saveLineItem() {
        itemIndex = itemSelector.getSelectedIndex();
        if (itemIndex == 1) {
            item = one.getName();
            itemPrice = one.getCost();
        }
        else if (itemIndex == 2) {
            item = two.getName();
            itemPrice = two.getCost();
        }
        else if (itemIndex == 3) {
            item = three.getName();
            itemPrice = three.getCost();
        }
        else if (itemIndex == 4) {
            item = four.getName();
            itemPrice = four.getCost();
        }
        else if (itemIndex == 5) {
            item = five.getName();
            itemPrice = five.getCost();
        }
        else if (itemIndex == 6) {
            item = six.getName();
            itemPrice = six.getCost();
        }
        else if (itemIndex == 7) {
            item = seven.getName();
            itemPrice = seven.getCost();
        }
        quantity = quantitySelector.getSelectedIndex();
        totalCost = itemPrice * quantity;
        lineItem = new LineItem(item, quantity, itemPrice, totalCost);
        lineItems.add(lineItem.toTabularAlignment());
    }
}