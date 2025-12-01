import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KwadratController implements ActionListener {
    private KwadratModel model;
    private KwadratView view;

    public KwadratController(KwadratModel model, KwadratView view) {
        this.model = model;
        this.view = view;
        view.getPrzyciskOblicz().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String tekst = view.pobierzLiczbe().trim();
            if (tekst.isEmpty()) {
                view.ustawWynik("Podaj liczbę!");
                return;
            }
            int liczba = Integer.parseInt(tekst);
            int wynik = model.obliczKwadrat(liczba);
            view.ustawWynik(String.valueOf(wynik));
        } catch (NumberFormatException ex) {
            view.ustawWynik("Błąd: Wpisz poprawną liczbę!");
        }
    }
}
