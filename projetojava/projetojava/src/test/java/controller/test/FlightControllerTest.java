package controller.test;

import com.projet.projetojava.ProjetojavaApplication;
import com.projet.projetojava.controller.FlightController;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.service.AirlineService;
import com.projet.projetojava.service.FlightService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProjetojavaApplication.class)
public class FlightControllerTest {

    @InjectMocks
    FlightController flightController;

    @Mock
    FlightService flightService;

    @Mock
    AirlineService airlineService;

    @Test
    public void testCreateFlight() {
        // Cria um mock de Airline
        Airline airline = new Airline();
        airline.setName("Airline Test");

        // Cria um mock de Flight
        Flight flight = new Flight();
        flight.setModel("Model Test");
        flight.setMaxCapacity(200);
        flight.setAirline(airline);  // Adiciona a companhia aérea ao voo

        // Configura os mocks para retornar os objetos esperados
        when(airlineService.findByName(airline.getName())).thenReturn(airline);
        when(flightService.createFlight(flight)).thenReturn(flight);

        // Chama o método que está sendo testado
        Flight result = flightController.createFlight(flight);

        // Verifica se o resultado é o esperado
        assertEquals(flight.getModel(), result.getModel());
        assertEquals(flight.getMaxCapacity(), result.getMaxCapacity());
        assertEquals(airline.getName(), result.getAirline().getName());
    }
}
