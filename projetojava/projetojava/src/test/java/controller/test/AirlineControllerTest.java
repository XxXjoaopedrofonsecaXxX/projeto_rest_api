package controller.test;

import com.projet.projetojava.controller.AirlineController;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.service.AirlineService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {MockitoTestExecutionListener.class})
public class AirlineControllerTest {

    @InjectMocks
    AirlineController airlineController;

    @Mock
    AirlineService airlineService;

    @Test
    public void testCreateAirLine() {
        Map<String, String> body = new HashMap<>();
        body.put("name", "Test Airline");

        Airline airline = new Airline();
        airline.setName("Test Airline");

        when(airlineService.createAirLine(body.get("name"))).thenReturn(airline);

        Airline result = airlineController.createAirLine(body);

        assertEquals(airline.getName(), result.getName());
    }
}
