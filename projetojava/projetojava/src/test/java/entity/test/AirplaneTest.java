package entity.test;

import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.entity.Airline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirplaneTest {
    private Airplane airplane;

    // Este método é executado antes de cada teste. Ele configura o ambiente de teste.
    @BeforeEach
    public void setUp() {
        // Cria um novo objeto Airplane com um modelo, capacidade máxima e uma nova companhia aérea.
        airplane = new Airplane("Boeing 747", 366, new Airline());
    }

    // Testa o método getModel da classe Airplane.
    @Test
    public void testGetModel() {
        // Verifica se o modelo do avião é "Boeing 747".
        assertEquals("Boeing 747", airplane.getModel());
    }

    // Testa o método setModel da classe Airplane.
    @Test
    public void testSetModel() {
        // Define o modelo do avião como "Airbus A380".
        airplane.setModel("Airbus A380");
        // Verifica se o modelo do avião é agora "Airbus A380".
        assertEquals("Airbus A380", airplane.getModel());
    }

    // Testa o método getMaxCapacity da classe Airplane.
    @Test
    public void testGetMaxCapacity() {
        // Verifica se a capacidade máxima do avião é 366.
        assertEquals(366, airplane.getMaxCapacity());
    }

    // Testa o método setMaxCapacity da classe Airplane.
    @Test
    public void testSetMaxCapacity() {
        // Define a capacidade máxima do avião como 853.
        airplane.setMaxCapacity(853);
        // Verifica se a capacidade máxima do avião é agora 853.
        assertEquals(853, airplane.getMaxCapacity());
    }

    // Testa o método getAirline da classe Airplane.
    @Test
    public void testGetAirline() {
        // Verifica se a companhia aérea do avião é uma nova companhia aérea.
        assertEquals(new Airline(), airplane.getAirline());
    }

    // Testa o método setAirline da classe Airplane.
    @Test
    public void testSetAirline() {
        // Cria uma nova companhia aérea.
        Airline airline = new Airline();
        // Define a companhia aérea do avião como a nova companhia aérea.
        airplane.setAirline(airline);
        // Verifica se a companhia aérea do avião é agora a nova companhia aérea.
        assertEquals(airline, airplane.getAirline());
    }
}
