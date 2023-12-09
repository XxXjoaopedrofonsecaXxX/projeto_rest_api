package entity.test;

import com.projet.projetojava.entity.Stopover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class StopoverTest {

    // Teste para verificar se o método getDuration funciona corretamente
    @Test
    public void testGetDuration() {
        Stopover stopover = new Stopover();
        stopover.setDuration(Duration.ofHours(2));
        Assertions.assertEquals(Duration.ofHours(2), stopover.getDuration());
    }

    // Teste para verificar se o método getAirport funciona corretamente
    @Test
    public void testGetAirport() {
        Stopover stopover = new Stopover();
        stopover.setAirport("GRU");
        Assertions.assertEquals("GRU", stopover.getAirport());
    }
}
