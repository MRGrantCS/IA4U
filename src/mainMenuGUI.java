import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenuGUI implements ActionListener{
    private static JButton menuButton1;
    private static JButton menuButton2;
    private static JButton menuButton3;

    public mainMenuGUI(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        menuButton1 = new JButton("Menu Option1");
        menuButton1.addActionListener(this);

        menuButton2 = new JButton("Menu Option2");
        menuButton3 = new JButton("Menu Option3");

        panel.add(menuButton1);
        panel.add(menuButton2);
        panel.add(menuButton3);

        frame.setSize(400,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        new JTableExamples();
    }

    }
