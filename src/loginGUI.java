import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class loginGUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JLabel passwordLabel;
    private static JButton button;
    private static JLabel successLabel;
    private static JFrame frame;

    public loginGUI(){
        frame = new JFrame();
        JPanel panel = new JPanel();

        userLabel = new JLabel("User");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100,20,165,25);
        panel.add(passwordText);

        passwordLabel = new JLabel("Password");
        userLabel.setBounds(10,20,80,25);
        panel.add(passwordLabel);

        button = new JButton("Sign In");
        button.setBounds(10,80,80,25);
        button.addActionListener(this);
        panel.add(button);

        successLabel = new JLabel("");
        successLabel.setBounds(10,110,300,25);
        panel.add(successLabel);

        frame.setSize(400,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        passwordValidation validate = new passwordValidation();

        String user = userText.getText();
        String password = passwordText.getText();

        System.out.println(user + "," + password);

        if (validate.passwordValidationMethod(user,password) == true){
            successLabel.setText("Login Successful");
            new mainMenuGUI();
            frame.dispose();
        }
        else{
            successLabel.setText("Login Fail");
        }

    }

}
