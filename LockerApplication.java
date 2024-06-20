
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication extends JFrame {
    private String savedPassword;
    private boolean isPasswordSet = false;
    private JPasswordField passwordField;
    private JButton enterButton;
    private JLabel statusLabel;

    public LockerApplication() {
        createUI();
    }
    private void createUI() {
        setTitle("Lock Class");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        passwordField = new JPasswordField(20);
        enterButton = new JButton("Enter");
        statusLabel = new JLabel("Enter Password ");

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePasswordEntry();
            }
        });
        add(passwordField);
        add(enterButton);
        add(statusLabel);

        setSize(450, 90);
        setLocationRelativeTo(null);
    }
    private void handlePasswordEntry() {
        char[] input = passwordField.getPassword();
        String inputPassword = new String(input);

        if (!isPasswordSet) {
            savedPassword = inputPassword;
            isPasswordSet = true;
            statusLabel.setText("Password Set");
        } else {
            if (savedPassword.equals(inputPassword)) {
                statusLabel.setText("Correct Password");
            } else {
                statusLabel.setText("Incorrect Password");
            }
        }
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LockerApplication().setVisible(true);
            }
        });
    }
}
