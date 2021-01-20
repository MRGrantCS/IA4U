import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class panelGUI implements ActionListener {

    // Makes these objects accessible to @Override method
    private static JTextArea textArea;
    private static JTextArea textArea2;
    private static JTable table;
    private static DefaultTableModel model;

    public panelGUI() {
        // Create Frame and add title
        JFrame f = new JFrame("Panel Example");
        // Set initial size of frame
        f.setSize(400, 400);
        // Setting to null allows for exact positioning - This may cause issues when
        // resizing windows
        f.setLayout(null);
        // Create Panel to contain all other Panels
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 400, 400);
        // Setting to null allows for exact positioning - This may cause issues when
        // resizing windows
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(Color.white);

        // Create left panel and colour gray
        JPanel panel1 = new JPanel();
        panel1.setBounds(40, 80, 100, 200);
        panel1.setBackground(Color.gray);
        // Create middle panel and colour red
        JPanel panel2 = new JPanel();
        panel2.setBounds(150, 80, 100, 200);
        // Setting to null allows for exact positioning - This may cause issues when
        // resizing windows
        panel2.setLayout(null);
        panel2.setBackground(Color.red);
        // Create right panel and colour green
        JPanel panel3 = new JPanel();
        panel3.setBounds(260, 130, 100, 150);
        panel3.setBackground(Color.green);

        /*
         * Add Task 1 below
         */


        // Create yellow button, set size and add action listener - see @Override
        JButton b1 = new JButton("Button 1");
        b1.setPreferredSize(new Dimension(100, 50));
        b1.setBackground(Color.yellow);
        b1.addActionListener(this);
        // Create green button and add action listener - see @Override
        JButton b2 = new JButton("Button 2");
        b2.setBackground(Color.green);
        b2.addActionListener(this);
        // Create blue button and add action listener - see @Override
        JButton b3 = new JButton("Button 3");
        b3.setBackground(Color.blue);
        b3.addActionListener(this);
        // Create grey button and add action listener - see @Override
        JButton b4 = new JButton("Button 4");
        b4.setBackground(Color.gray);
        b4.addActionListener(this);

        /*
         * Add Task 3 below
         */


        // Creates a text area - this can be edited
        textArea = new JTextArea("You haven't pressed a button yet");
        // Set exact position and size of text area
        textArea.setLocation(5, 45);
        textArea.setSize(90, 50);
        // Allows text to wrap if wider than allowed space
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        // Allows text area to be edited
        textArea.setEditable(true);
        textArea.setBackground(Color.red);

        /*
         * Add Task 2 below
         */


        // Use the DefaultTableModel class to allow simplified manipulation of the table
        model = new DefaultTableModel();
        // Pass model to new table object
        table = new JTable(model);
        // Disables ability to edit the cells in the table
        table.setEnabled(false);

        // Sets initial values for the table using the DefaultTableModel object
        // Create a column on the table
        model.addColumn("Col1");
        // Append a row to the table
        model.addRow(new Object[] { "TEST" });

        // Use the JScrollPane class and pass it the table object to allow the table to
        // be scrolled through if it exceeds the space
        JScrollPane sp = new JScrollPane(table);
        // Activates vertical scrolling
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // Sets preferred size of the scrollable area
        sp.setPreferredSize(new Dimension(90, 90));

        // Add to panel1
        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);
        // Add to panel2
        panel2.add(textArea);
        // Add to panel3
        panel3.add(sp);
        panel3.add(b4);
        // Add other panesl to backgroundPanel
        backgroundPanel.add(panel1);
        backgroundPanel.add(panel2);
        backgroundPanel.add(panel3);
        // Add backgroundPanel to frame
        f.add(backgroundPanel);
        // Make frame visible - best practice is to do this last
        f.setVisible(true);

        System.out.println("Running");
    }

    public static void main(String args[]) {
        new panelGUI();
    }

    // This @Override checks which button is pressed to decide on what action to
    // take
    @Override
    public void actionPerformed(ActionEvent e) {
        // Gets name of action command - in this case it will return the name of the
        // button that was pressed
        String s = e.getActionCommand();
        // Test what action occurred
        System.out.println("You Pressed " + s);
        // If button 1, then add "Button 1" to the table on a new row and update
        // textArea
        if (s == "Button 1") {
            // Changes text in textArea
            textArea.setText(s);
            // addRow accepts an array object
            model.addRow(new Object[] { s });
        }
        // If button 2, then add "Button 2" to the table on a new row and update
        // textArea
        else if (s == "Button 2") {
            // Changes text in textArea
            textArea.setText(s);
            // addRow accepts an array object
            model.addRow(new Object[] { s });
        }
        // If button 3 then take whatever is currently in the textArea and add it to the
        // table
        else if (s == "Button 3") {
            model.addRow(new Object[] { textArea.getText() });
        }
        // If button 4 then print to console the current contents of the table
        else if (s == "Button 4") {
            // Gets current number of rows in table
            int rowCount = model.getRowCount();
            System.out.println("Contents of the table:");
            // loops through the current rows in the table and prints to console
            for (int i = 0; i < rowCount; i++) {
                System.out.println(model.getValueAt(i, 0));
            }

        }
    }
}