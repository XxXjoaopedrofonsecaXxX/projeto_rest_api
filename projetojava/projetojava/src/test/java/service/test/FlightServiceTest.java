package service.test;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.repository.FlightRepository;
import com.projet.projetojava.service.FlightService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    @Test
    public void testCreateFlight() {
        // Cria um voo com propriedades específicas
        Flight flight = new Flight("FL123", new Airline());
        // set flight properties...
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);

        Flight createdFlight = flightService.createFlight(flight);

        assertNotNull(createdFlight);
        assertEquals(flight.getFlightNumber(), createdFlight.getFlightNumber());
        // assert other properties...
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        // Cria um voo com propriedades específicas
        Flight flight = new Flight("FL123", new Airline());
        // set flight properties...
        when(flightRepository.findById(id)).thenReturn(java.util.Optional.of(flight));

        Flight foundFlight = flightService.findById(id);

        assertNotNull(foundFlight);
        assertEquals(flight.getFlightNumber(), foundFlight.getFlightNumber());
        // assert other properties...
    }
}
