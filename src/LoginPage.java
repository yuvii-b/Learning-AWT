import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginPage {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    Frame frame;
    LoginPage(){
        //frame
        frame = new Frame("LOGIN PAGE");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //frame features
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
