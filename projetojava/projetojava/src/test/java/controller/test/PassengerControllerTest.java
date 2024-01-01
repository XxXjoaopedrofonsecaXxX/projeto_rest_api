package controller.test;

import com.projet.projetojava.ProjetojavaApplication;
import com.projet.projetojava.controller.PassengerController;
import com.projet.projetojava.entity.Passenger;
import com.projet.projetojava.service.PassengerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ProjetojavaApplication.class)
public class PassengerControllerTest {

    @InjectMocks
    PassengerController passengerController;

    @Mock
    PassengerService passengerService;

    @Test
    public void testGetPassengers() {
        Passenger passenger1 = new Passenger();
        passenger1.setName("Passenger 1");

        Passenger passenger2 = new Passenger();
        passenger2.setName("Passenger 2");

        List<Passenger> passengers = Arrays.asList(passenger1, passenger2);

        when(passengerService.getPassengers()).thenReturn(passengers);

        List<Passenger> result = passengerController.getPassengers();

        assertEquals(passengers.size(), result.size());
    }

    @Test
    public void testGetPassenger() {
        Long id = 1L;
        Passenger passenger = new Passenger();
        passenger.setName("Passenger Test");

        when(passengerService.getPassenger(id)).thenReturn(passenger);

        Passenger result = passengerController.getPassenger(id);

        assertEquals(passenger.getName(), result.getName());
    }

    @Test
    public void testAddNewPassenger() {
        Passenger passenger = new Passenger();
        passenger.setName("Passenger Test");

        doNothing().when(passengerService).addNewPassenger(passenger);

        passengerController.addNewPassenger(passenger);

        verify(passengerService, times(1)).addNewPassenger(passenger);
    }

    @Test
    public void testDeletePassenger() {
        Long id = 1L;

        doNothing().when(passengerService).deletePassenger(id);

        passengerController.deletePassenger(id);

        verify(passengerService, times(1)).deletePassenger(id);
    }
}
