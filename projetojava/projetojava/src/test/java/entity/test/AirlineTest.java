package entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;

public class AirlineTest {
    // Os testes existentes permanecem os mesmos...

    // Este teste verifica se o método addAirplane da classe Airline está definindo a companhia aérea do avião corretamente.
    @Test
    public void testAddAirplaneSetsAirlineOfAirplane() {
        // Arrange
        Airline airline = new Airline("Test Airline");
        Airplane airplane = new Airplane("Test Airplane");

        // Act
        airline.addAirplane(airplane);

        // Assert
        assertEquals(airline, airplane.getAirline());
    }
}
