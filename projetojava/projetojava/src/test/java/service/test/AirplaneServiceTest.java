package service.test;


import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.repository.AirplaneRepository;
import com.projet.projetojava.service.AirplaneService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AirplaneServiceTest {

    @Mock
    private AirplaneRepository airplaneRepository;

    @InjectMocks
    private AirplaneService airplaneService;

    @Test
    public void testCreateAirplane() {
        String model = "Test Model";
        int maxCapacity = 100;
        Airline airline = new Airline("Test Airline");
        Airplane airplane = new Airplane(model, maxCapacity, airline);
        when(airplaneRepository.save(any(Airplane.class))).thenReturn(airplane);

        Airplane createdAirplane = airplaneService.createAirplane(model, maxCapacity, airline);

        assertNotNull(createdAirplane);
        assertEquals(model, createdAirplane.getModel());
        assertEquals(maxCapacity, createdAirplane.getMaxCapacity());
        assertEquals(airline, createdAirplane.getAirline());
    }

    @Test
    public void testGetTotalCapacity() {
        Airline airline = new Airline("Test Airline");
        Airplane airplane1 = new Airplane("Model 1", 100, airline);
        Airplane airplane2 = new Airplane("Model 2", 200, airline);
        when(airplaneRepository.findByAirline(airline)).thenReturn(Arrays.asList(airplane1, airplane2));

        int totalCapacity = airplaneService.getTotalCapacity(airline);

        assertEquals(300, totalCapacity);
    }
}
