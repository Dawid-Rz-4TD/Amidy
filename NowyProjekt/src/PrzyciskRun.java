import java.awt.EventQueue;

class PrzyciskRun {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KlatkaAkcji();
            }
        });
    }
}
