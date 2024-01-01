package controller.test;

import com.projet.projetojava.ProjetojavaApplication;
import com.projet.projetojava.controller.AirplaneController;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.service.AirlineService;
import com.projet.projetojava.service.AirplaneService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProjetojavaApplication.class)
public class AirplaneControllerTest {

    @InjectMocks
    AirplaneController airplaneController;

    @Mock
    AirplaneService airplaneService;

    @Mock
    AirlineService airlineService;

    @Test
    public void testCreateAirplane() {
        Airplane airplane = new Airplane();
        airplane.setModel("Model Test");
        airplane.setMaxCapacity(200);

        Airline airline = new Airline();
        airline.setName("Airline Test");

        airplane.setAirline(airline); // Adicione esta linha

        when(airlineService.findByName(airplane.getAirline().getName())).thenReturn(airline);
        when(airplaneService.createAirplane(airplane.getModel(), airplane.getMaxCapacity(), airline)).thenReturn(airplane);

        Airplane result = airplaneController.createAirplane(airplane);

        assertEquals(airplane.getModel(), result.getModel());
        assertEquals(airplane.getMaxCapacity(), result.getMaxCapacity());
        assertEquals(airline.getName(), result.getAirline().getName());
    }

    @Test
    public void testGetTotalCapacity() {
        String airlineName = "Airline Test";
        int totalCapacity = 1000;

        Airline airline = new Airline();
        airline.setName(airlineName);

        when(airlineService.findByName(airlineName)).thenReturn(airline);
        when(airplaneService.getTotalCapacity(airline)).thenReturn(totalCapacity);

        int result = airplaneController.getTotalCapacity(airlineName);

        assertEquals(totalCapacity, result);
    }
}
