package repository.test;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.repository.AirlineRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AirlineRepositoryTest {

    private AirlineRepository airlineRepository = Mockito.mock(AirlineRepository.class);

    // Teste para verificar se o método findByName funciona corretamente
    @Test
    public void testFindByName() {
        Airline airline = new Airline();
        airline.setName("Test Airline");
        Mockito.when(airlineRepository.findByName("Test Airline")).thenReturn(airline);

        Airline foundAirline = airlineRepository.findByName("Test Airline");

        Assertions.assertNotNull(foundAirline);
        Assertions.assertEquals("Test Airline", foundAirline.getName());
    }
}
