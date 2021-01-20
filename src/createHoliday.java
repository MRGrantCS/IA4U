// Core Packages
import java.awt.*;
import java.awt.event.*;
// Java extension packages
import javax.swing.*;

public class createHoliday implements ActionListener{

    JList colorList;
    JButton copyButton;
    JList copyList;
    JTextField userText;

    public createHoliday() {

        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(600,450);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 450);

        JLabel userLabel = new JLabel("Holiday Name");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(180, 20, 200, 25);
        panel.add(userText);

        // Start - Multi Select to add Users to Holiday
        String colorNames[] = { "Black", "Blue", "Cyan",
                "Dark Gray", "Gray", "Green", "Light Gray",
                "Magenta", "Orange", "Pink", "Red", "White", "Yellow" };

        colorList = new JList( colorNames );
        colorList.setVisibleRowCount( 5 );
        colorList.setFixedCellHeight( 15 );
        colorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
        colorList.setBounds(10,80,150,250);
        panel.add(colorList);

        // create copy button and register its listener
        copyButton = new JButton( "Copy >>>" );
        copyButton.addActionListener(
                // anonymous inner class for button event
                new ActionListener() {
                    // handle button event
                    public void actionPerformed( ActionEvent event )
                    {
                        // place selected values in copyList
                        copyList.setListData(
                                colorList.getSelectedValues() );
                    }
                }  // end anonymous inner class
        ); // end call to addActionListener
        copyButton.setBounds(170,170,120,25);
        panel.add(copyButton);

        copyList = new JList( );
        copyList.setVisibleRowCount( 5 );
        copyList.setFixedCellWidth( 100 );
        copyList.setFixedCellHeight( 15 );
        copyList.setSelectionMode(
        ListSelectionModel.SINGLE_INTERVAL_SELECTION );
        copyList.setBounds(300,80,150,250);
        panel.add(copyList);

        // End Multi Select

        JButton button = new JButton("Create Holiday");
        button.setBounds(10,350,120,25);
        button.addActionListener((ActionListener) this);
        panel.add(button);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String s = e.getActionCommand();
        if (s == "Create Holiday"){
            System.out.println(userText.getText());
            for (int i = 0; i < copyList.getModel().getSize(); i++) {
                Object item = copyList.getModel().getElementAt(i);
                System.out.println("Item = " + item);
            }
            }
        }

    }

