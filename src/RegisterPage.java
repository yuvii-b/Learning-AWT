import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.sun.tools.javac.Main;
import db.JDBC;

import javax.swing.*;

public class RegisterPage implements ActionListener {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    Frame frame;
    Label heading;
    Label name;
    Label age;
    Label email;
    Label password;
    Label rePassword;
    Label result;
    TextField nameInput;
    TextField ageInput;
    TextField emailInput;
    TextField passwordInput;
    TextField rePassInput;
    Button submit;
    Button back;
    RegisterPage(){
        //frame
        frame = new Frame("SIGN UP");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //labels
        heading = new Label("REGISTER");
        heading.setBounds(145, 50, 200, 30);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        name = new Label("NAME: ");
        name.setBounds(40, 110, 100, 30);
        name.setFont(new Font("Brush Script MT", Font.BOLD, 24));
        email = new Label("E-MAIL ID: ");
        email.setBounds(40, 170, 200, 30);
        email.setFont(new Font("Brush Script MT", Font.BOLD, 24));
        age = new Label("AGE: ");
        age.setBounds(40, 230, 100, 30);
        age.setFont(new Font("Brush Script MT", Font.BOLD, 24));
        password = new Label("PASSWORD: ");
        password.setBounds(40, 290, 200, 30);
        password.setFont(new Font("Brush Script MT", Font.BOLD, 24));
        rePassword = new Label("PASSWORD(again): ");
        rePassword.setBounds(40, 350, 200, 30);
        rePassword.setFont(new Font("Brush Script MT", Font.BOLD, 20));
        result = new Label();
        result.setBounds(130, 460, 300, 30);
        result.setFont(new Font("Agency FB", Font.BOLD, 20));

        //TextFields
        nameInput = new TextField();
        nameInput.setBounds(250, 110, 240, 30);
        nameInput.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
        emailInput = new TextField();
        emailInput.setBounds(250, 170, 240, 30);
        emailInput.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
        ageInput = new TextField();
        ageInput.setBounds(250, 230, 240, 30);
        ageInput.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
        passwordInput = new TextField();
        passwordInput.setBounds(250, 290, 240, 30);
        passwordInput.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
        rePassInput = new TextField();
        rePassInput.setBounds(250, 350, 240, 30);
        rePassInput.setFont(new Font("Brush Script MT", Font.PLAIN, 20));


        //button
        submit = new Button("SUBMIT");
        submit.setBounds(200, 420, 100, 30);
        submit.setFocusable(false);
        submit.addActionListener(this);
        submit.setFont(new Font("Brush Script MT", Font.PLAIN, 15));
        back = new Button("BACK");
        back.setBounds(10, 35, 100, 30);
        back.setFont(new Font("Serif", Font.PLAIN, 15));
        back.addActionListener(this);
        back.setForeground(new Color(0, 100, 100));

        //adding components to the frame
        frame.add(heading);
        frame.add(name);
        frame.add(email);
        frame.add(age);
        frame.add(password);
        frame.add(rePassword);
        frame.add(nameInput);
        frame.add(emailInput);
        frame.add(ageInput);
        frame.add(passwordInput);
        frame.add(rePassInput);
        frame.add(submit);
        frame.add(result);
        frame.add(back);

        //frame features
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            int age = -1;
            String name = nameInput.getText();
            String checkAge = ageInput.getText();
            String email = emailInput.getText();
            String password = passwordInput.getText();
            String rePassword = rePassInput.getText();
            if(validate(name, checkAge, email, password, rePassword)){
                if(JDBC.registerUser(name, Integer.parseInt(checkAge), email, password)){
                    result.setForeground(new Color(0, 255, 0));
                    result.setText("SUCCESSFUL REGISTRATION");
                }else{
                    result.setForeground(new Color(255, 0, 0));
                    result.setText("USERNAME ALREADY EXISTS");
                }
            }else{
                JOptionPane.showMessageDialog(frame, """
                        Error: Username, email, password must be at least 4 characters\s
                        and/or Passwords must match\
                        \s
                        Check if all boxes are filled properly!""");
            }
        }

        if(e.getSource() == back){
            frame.dispose();
            new MainForm();
        }
    }

    private static boolean validate(String name, String age, String email, String password, String rePassword){
        String regex = "\\d+";
        if(name.isEmpty() || age.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) return false;
        if(name.length() < 3 || email.length() < 3 || password.length() < 3 || rePassword.length() < 3) return false;
        if(!age.matches(regex)) return false;
        if(!password.equals(rePassword)) return false;

        return true;
    }
}
