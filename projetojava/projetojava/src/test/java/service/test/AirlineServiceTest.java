package service.test;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.repository.AirlineRepository;
import com.projet.projetojava.service.AirlineService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AirlineServiceTest {

    @Mock
    private AirlineRepository airlineRepository;

    @InjectMocks
    private AirlineService airlineService;

    @Test
    public void testCreateAirline() {
        String name = "Test Airline";
        Airline airline = new Airline(name);
        when(airlineRepository.save(any(Airline.class))).thenReturn(airline);

        Airline createdAirline = airlineService.createAirLine(name);

        assertNotNull(createdAirline);
        assertEquals(name, createdAirline.getName());
    }

    @Test
    public void testFindByName() {
        String name = "Test Airline";
        Airline airline = new Airline(name);
        when(airlineRepository.findByName(name)).thenReturn(airline);

        Airline foundAirline = airlineService.findByName(name);

        assertNotNull(foundAirline);
        assertEquals(name, foundAirline.getName());
    }
}
