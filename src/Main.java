import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main {

    public Main() {
        JFrame jFrame = new JFrame("MC:EE TC Launcher");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("El. paštas");
        label.setBounds(20, 20, 80,20);
        jFrame.add(label);

        JTextField email = new JTextField();
        email.setBounds(100,20,200,20);
        jFrame.add(email);

        JLabel label_password = new JLabel("Slaptažodis");
        label_password.setBounds(20, 45, 80,20);
        jFrame.add(label_password);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100,45,200,20);
        jFrame.add(passwordField);

        JButton loginButton = new JButton("Prisijungti");
        loginButton.setBounds(305,20,100,45);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Labas ");
                LauncherTask launcherTask = new LauncherTask(email.getText(), String.valueOf(passwordField.getPassword()));
                launcherTask.start();
            }
        });
        jFrame.add(loginButton);

        jFrame.setSize(450,140);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }


    public static void main(String[] args) {
        new Main();
    }

}
