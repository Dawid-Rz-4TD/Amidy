public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.btnOblicz.addActionListener(e -> oblicz());
    }

    private void oblicz() {
        String aText = view.poleA.getText().trim();
        String bText = view.poleB.getText().trim();

        if (!aText.matches("-?\\d+") || !bText.matches("-?\\d+")) {
            view.pokazBlad("Wprowadź poprawne liczby całkowite");
            return;
        }

        int a = Integer.parseInt(aText);
        int b = Integer.parseInt(bText);

        int wynik = model.dodaj(a, b);
        view.ustawWynik(wynik);
    }
}
