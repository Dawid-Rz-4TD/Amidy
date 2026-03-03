import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

public class Main extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelTabeli;

    public Main() {
        setTitle("RAPORT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);


        String[] kolumny = {"ID", "Nazwa Produktu", "Ilość", "Cena"};
        Object[][] dane = {
                {1, "Laptop", 15, 4500.00},
                {2, "Mysz", 120, 89.99},
                {3, "Klawiatura", 45, 299.00},
                {4, "Monitor", 8, 1299.00},
                {5, "Kabel HDMI", 200, 25.50}
        };
dane.se
        modelTabeli = new DefaultTableModel(dane, kolumny);
        tabela = new JTable(modelTabeli);

        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);


        JButton btnGenerujPDF = new JButton("Generuj Raport PDF");
        btnGenerujPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generujRaportPDF();
            }
        });

        JPanel panelPrzyciskow = new JPanel();
        panelPrzyciskow.add(btnGenerujPDF);
        add(panelPrzyciskow, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void generujRaportPDF() {
        try {
            Document dokument = new Document(PageSize.A4);
            PdfWriter.getInstance(dokument, new FileOutputStream("Raport_Magazynowy.pdf"));
            dokument.open();


            Paragraph tytul = new Paragraph("SYSTEM RAPORTOWANIA MAGAZYNOWEGO");
            tytul.setAlignment(Element.ALIGN_CENTER);
            dokument.add(tytul);
            dokument.add(new Paragraph(" "));


            PdfPTable tabelaPdf = new PdfPTable(4);
            tabelaPdf.setWidthPercentage(100);


            tabelaPdf.addCell("ID");
            tabelaPdf.addCell("Nazwa Produktu");
            tabelaPdf.addCell("Ilość");
            tabelaPdf.addCell("Cena");


            for (int i = 0; i < modelTabeli.getRowCount(); i++) {
                for (int j = 0; j < modelTabeli.getColumnCount(); j++) {
                    tabelaPdf.addCell(modelTabeli.getValueAt(i, j).toString());
                }
            }

            dokument.add(tabelaPdf);
            dokument.close();

            JOptionPane.showMessageDialog(this,
                    "Raport PDF został wygenerowany!\nPlik: Raport_Magazynowy.pdf",
                    "Sukces", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
