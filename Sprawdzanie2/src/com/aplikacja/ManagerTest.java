package com.aplikacja;
import com.aplikacja.ManagerListy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {


    private ManagerListy managerListy;

    @BeforeEach
    void setup(){
        managerListy = new ManagerListy();
    }

    @Test
    void testPustaListaNaPoczatku(){
        int rozmiar = managerListy.pobierzRozmiar();

        assertEquals(0,rozmiar,"Lista na początku powinna mieć rozmiar 0.");
    }


@Test
    void testDodajElementPoprawnie(){
managerListy.dodajElement("A");
        managerListy.dodajElement("B");

        managerListy.dodajElement("C");

        int rozmiar = managerListy.pobierzRozmiar();
        assertEquals(3,rozmiar, "Po dodanie 3 elementów listy rozmiar powinien wynosić 3." );

    }

}
