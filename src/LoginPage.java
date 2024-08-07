import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import db.JDBC;

public class LoginPage implements ActionListener {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    Frame frame;
    Label heading;
    Label name;
    Label email;
    Label password;
    TextField nameInput;
    TextField emailInput;
    TextField passwordInput;
    Button login;
    Label result;
    LoginPage(){
        //frame
        frame = new Frame("LOGIN");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //labels
        heading = new Label("LOGIN");
        heading.setBounds(145, 50, 200, 30);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        name = new Label("NAME: ");
        name.setBounds(40, 110, 100, 30);
        name.setFont(new Font("Brush Script MT", Font.BOLD, 24));
        email = new Label("E-MAIL ID: ");
        email.setBounds(40, 200, 200, 30);
        email.setFont(new Font("Brush Script MT", Font.BOLD, 24));
        password = new Label("PASSWORD: ");
        password.setBounds(40, 290, 200, 30);
        password.setFont(new Font("Brush Script MT", Font.BOLD, 24));
        result = new Label();
        result.setBounds(130, 360, 300, 30);
        result.setFont(new Font("Agency FB", Font.BOLD, 20));

        //TextFields
        nameInput = new TextField();
        nameInput.setBounds(250, 110, 240, 30);
        nameInput.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
        emailInput = new TextField();
        emailInput.setBounds(250, 200, 240, 30);
        emailInput.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
        passwordInput = new TextField();
        passwordInput.setBounds(250, 290, 240, 30);
        passwordInput.setFont(new Font("Brush Script MT", Font.PLAIN, 20));

        //button
        login = new Button("LOGIN");
        login.setBounds(185, 420, 100, 30);
        login.setFocusable(false);
        login.addActionListener(this);
        login.setFont(new Font("Brush Script MT", Font.PLAIN, 15));

        //adding components to the frame
        frame.add(heading);
        frame.add(name);
        frame.add(email);
        frame.add(password);
        frame.add(nameInput);
        frame.add(emailInput);
        frame.add(passwordInput);
        frame.add(login);
        frame.add(result);

        //frame features
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String name = nameInput.getText();
            String email = emailInput.getText();
            String password = passwordInput.getText();
            if(JDBC.loginUser(name, email, password)){
                result.setText("LOGIN SUCCESSFUL");
                result.setForeground(new Color(0, 255, 0));
            }else{
                result.setText("LOGIN FAILED");
                result.setForeground(new Color(255, 0, 0));
            }
        }
    }
}
