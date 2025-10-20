import java.awt.EventQueue;

public class PaneleRun {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MyFrame2();
            }
        });
    }
}
