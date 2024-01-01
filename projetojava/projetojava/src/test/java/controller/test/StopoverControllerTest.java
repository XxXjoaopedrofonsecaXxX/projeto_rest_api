package controller.test;

import com.projet.projetojava.ProjetojavaApplication;
import com.projet.projetojava.controller.StopoverController;
import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.entity.Stopover;
import com.projet.projetojava.service.FlightService;
import com.projet.projetojava.service.StopoverService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProjetojavaApplication.class)
public class StopoverControllerTest {

    @InjectMocks
    StopoverController stopoverController;

    @Mock
    StopoverService stopoverService;

    @Mock
    FlightService flightService;

    @Test
    public void testCreateStopover() {
        Stopover stopover = new Stopover();
        stopover.setAirport("Airport Test");
        stopover.setDuration(Duration.ofHours(2));

        Flight flight = new Flight();
        flight.setId(1L);

        when(flightService.findById(stopover.getFlight().getId())).thenReturn(flight);
        when(stopoverService.createStopover(flight, stopover.getAirport(), stopover.getDuration())).thenReturn(stopover);

        Stopover result = stopoverController.createStopover(stopover);

        assertEquals(stopover.getAirport(), result.getAirport());
        assertEquals(stopover.getDuration(), result.getDuration());
    }
}
//