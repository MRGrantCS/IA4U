import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
// Adapted from: https://zetcode.com/javaswing/draganddrop/
public class myDragAndDrop {

    String[] options = {"45", "22", "190", "12"};

    JList OptionsList;

    public myDragAndDrop() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(600, 450);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 450);

        JLabel DestinationLabel = new JLabel("Drag your Answers here");
        DestinationLabel.setBounds(10, 20, 200, 25);
        panel.add(DestinationLabel);

        JLabel OptionsLabel = new JLabel("Answer Options");
        OptionsLabel.setBounds(300, 20, 150, 25);
        panel.add(OptionsLabel);

        OptionsList = new JList(options);
        OptionsList.setVisibleRowCount(5);
        OptionsList.setFixedCellWidth(100);
        OptionsList.setFixedCellHeight(15);
        OptionsList.setDragEnabled(true);
        OptionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        OptionsList.setBounds(300, 80, 150, 100);
        panel.add(OptionsList);

        JButton Destination1 = new JButton();
        Destination1.setTransferHandler(new TransferHandler("text"));
        Destination1.setBounds(10, 55, 150, 25);
        panel.add(Destination1);
        JButton Destination2 = new JButton();
        Destination2.setTransferHandler(new TransferHandler("text"));
        Destination2.setBounds(10, 90, 150, 25);
        panel.add(Destination2);
        JButton Destination3 = new JButton();
        Destination3.setTransferHandler(new TransferHandler("text"));
        Destination3.setBounds(10, 125, 150, 25);
        panel.add(Destination3);
        JButton Destination4 = new JButton();
        Destination4.setTransferHandler(new TransferHandler("text"));
        Destination4.setBounds(10, 160, 150, 25);
        panel.add(Destination4);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
}