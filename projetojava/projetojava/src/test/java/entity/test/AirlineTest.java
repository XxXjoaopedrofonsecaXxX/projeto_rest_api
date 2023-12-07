package entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;

public class AirlineTest {
    // Este teste verifica se o construtor da classe Airline está definindo o nome corretamente.
    @Test
    public void testConstructorSetsNameCorrectly() {
        // Arrange
        String expectedName = "Test Airline";

        // Act
        Airline airline = new Airline(expectedName);

        // Assert
        assertEquals(expectedName, airline.getName());
    }

    // Este teste verifica se os métodos getter e setter da classe Airline estão funcionando corretamente.
    @Test
    public void testGettersAndSetters() {
        // Arrange
        Airline airline = new Airline();
        String expectedName = "Test Airline";
        Long expectedId = 1L;
        List<Airplane> expectedAirplanes = new ArrayList<>();

        // Act
        airline.setName(expectedName);
        airline.setId(expectedId);
        airline.setAirplanes(expectedAirplanes);

        // Assert
        assertEquals(expectedName, airline.getName());
        assertEquals(expectedId, airline.getId());
        assertEquals(expectedAirplanes, airline.getAirplanes());
    }

    // Este teste verifica se o método addAirplane da classe Airline está adicionando um avião à lista de aviões.
    @Test
    public void testAddAirplaneAddsAirplaneToList() {
        // Arrange
        Airline airline = new Airline("Test Airline");
        Airplane airplane = new Airplane("Test Airplane");

        // Act
        airline.addAirplane(airplane);

        // Assert
        assertEquals(1, airline.getAirplanes().size());
        assertEquals(airplane, airline.getAirplanes().get(0));
    }

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
