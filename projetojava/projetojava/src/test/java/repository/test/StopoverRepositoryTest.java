package repository.test;

import com.projet.projetojava.Main;
import com.projet.projetojava.entity.Stopover;
import com.projet.projetojava.repository.StopoverRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Main.class)
public class StopoverRepositoryTest {

    @Autowired
    private StopoverRepository repository;

    @Test
    @Transactional
    public void testFindById() {
        // Crie um novo Stopover e salve-o no repositório
        Stopover newStopover = new Stopover();
        newStopover.setAirport("Test Airport"); // Adicione esta linha
        repository.save(newStopover);
        repository.flush();

        // Verifique se o novo Stopover pode ser encontrado no repositório
        Stopover foundStopover = repository.findById(newStopover.getId()).orElse(null);
        assertThat(foundStopover).isEqualTo(newStopover);
    }

    // Adicione mais testes conforme necessário para cobrir outros métodos em StopoverRepository
}
