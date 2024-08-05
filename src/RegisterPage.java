import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterPage {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    Frame frame;
    RegisterPage(){
        //frame
        frame = new Frame("REGISTER PAGE");
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
