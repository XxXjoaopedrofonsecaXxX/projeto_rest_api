package repository.test;

import com.projet.projetojava.ProjetojavaApplication;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.repository.AirplaneRepository;
import com.projet.projetojava.repository.AirlineRepository; // Importe o repositório da companhia aérea

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ContextConfiguration(classes = ProjetojavaApplication.class)
public class AirplaneRepositoryTest {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private AirlineRepository airlineRepository; // Injete o repositório da companhia aérea

    @Test
    public void testFindByAirline() {
        String airlineName = "LATAM";
        String airplaneModel1 = "Boeing 737-800";
        String airplaneModel2 = "Airbus A320";

        // Create airline and save it
        Airline airline = new Airline(airlineName);
        airlineRepository.save(airline); // Salve a companhia aérea antes de salvar os aviões

        // Create airplanes
        Airplane airplane1 = new Airplane(airplaneModel1, airline);
        Airplane airplane2 = new Airplane(airplaneModel2, airline);

        // Save airplanes
        airplaneRepository.saveAll(List.of(airplane1, airplane2));

        // Use the method findByAirline to fetch airplanes by airline
        List<Airplane> airplanes = airplaneRepository.findByAirline(airline);

        // Verify the size of the list of airplanes is 2
        assertEquals(2, airplanes.size());

        // Verify the list of airplanes contains the two saved airplanes
        assertTrue(airplanes.contains(airplane1));
        assertTrue(airplanes.contains(airplane2));
    }
}
