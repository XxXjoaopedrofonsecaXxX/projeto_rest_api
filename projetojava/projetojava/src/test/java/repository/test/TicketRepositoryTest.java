package repository.test;

import com.projet.projetojava.entity.Ticket;
import com.projet.projetojava.repository.TicketRpository;

import test.TestConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ContextConfiguration(classes = TestConfig.class)
public class TicketRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TicketRpository ticketRepository;

    @Test
    public void testSaveTicket() {
        Ticket ticket = new Ticket();
        // set ticket properties...
        Ticket savedTicket = entityManager.persistAndFlush(ticket);
        Ticket foundTicket = ticketRepository.findById(savedTicket.getId()).orElse(null);
        assertThat(foundTicket).isEqualTo(savedTicket);
    }
}
