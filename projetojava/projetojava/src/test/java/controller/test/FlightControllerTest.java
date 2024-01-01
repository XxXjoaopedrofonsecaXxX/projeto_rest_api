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
        Flight flight = new Flight();
        flight.setModel("Model Test");
        flight.setMaxCapacity(200);

        Airline airline = new Airline();
        airline.setName("Airline Test");

        when(airlineService.findByName(flight.getAirline().getName())).thenReturn(airline);
        when(flightService.createFlight(flight)).thenReturn(flight);

        Flight result = flightController.createFlight(flight);

        assertEquals(flight.getModel(), result.getModel());
        assertEquals(flight.getMaxCapacity(), result.getMaxCapacity());
        assertEquals(airline.getName(), result.getAirline().getName());
    }
}
