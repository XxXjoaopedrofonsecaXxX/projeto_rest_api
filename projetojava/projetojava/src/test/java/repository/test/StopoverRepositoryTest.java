package repository.test;

import com.projet.projetojava.ProjetojavaApplication;
import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.entity.Stopover;
import com.projet.projetojava.repository.StopoverRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProjetojavaApplication.class)
public class StopoverRepositoryTest {

    @Mock
    StopoverRepository stopoverRepository;

    @Mock
    Flight flight;

    @Test
    public void testFindById() {
        // Cria um mock de Flight
        flight.setId(1L);

        // Cria um mock de Stopover
        Stopover stopover = new Stopover(flight, "Airport Test", Duration.ofHours(2));

        // Configura os mocks para retornar os objetos esperados
        when(stopoverRepository.findById(stopover.getId())).thenReturn(java.util.Optional.of(stopover));

        // Busca o Stopover no repositório
        Stopover foundStopover = stopoverRepository.findById(stopover.getId()).orElse(null);

        // Verifica se o Stopover foi encontrado
        assertNotNull(foundStopover);
        assertEquals(stopover.getAirport(), foundStopover.getAirport());
        assertEquals(stopover.getDuration(), foundStopover.getDuration());
    }
}
