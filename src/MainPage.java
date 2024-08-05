import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MainForm implements ActionListener {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    Frame frame;
    Label heading;
    Label registerMessage;
    Label loginMessage;
    Button register;
    Button login;
    MainForm(){
        //frame
        frame = new Frame("REGISTRATION FORM");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //labels
        heading = new Label("HOME PAGE");
        heading.setBounds(145, 100, 200, 30);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        registerMessage = new Label("New User? Register Here!  ");
        registerMessage.setBounds(100, 200, 300, 30);
        registerMessage.setFont(new Font("Brush Script MT", Font.BOLD, 24));
        loginMessage = new Label("Already an User? Login Here!  ");
        loginMessage.setBounds(90, 310, 400, 30);
        loginMessage.setFont(new Font("Brush Script MT", Font.BOLD, 24));

        //buttons
        register = new Button("REGISTER");
        register.setBounds(190, 250, 100, 30);
        register.setFocusable(false);
        register.addActionListener(this);
        register.setFont(new Font("Brush Script MT", Font.PLAIN, 15));
        login = new Button("LOGIN");
        login.setBounds(190, 350, 100, 30);
        login.setFocusable(false);
        login.addActionListener(this);
        login.setFont(new Font("Brush Script MT", Font.PLAIN, 15));

        //adding components to the frame
        frame.add(heading);
        frame.add(registerMessage);
        frame.add(loginMessage);
        frame.add(register);
        frame.add(login);

        //frame features
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == register){
            frame.dispose();
            new RegisterPage();
        }
        if(e.getSource() == login){
            frame.dispose();
            new LoginPage();
        }
    }
}

public class MainPage {
    public static void main(String[] args) {
        new MainForm();
    }
}
