package entity.test;

import com.projet.projetojava.entity.Ticket;
import org.junit.Assert;
import org.junit.Test;

public class TicketTest {

    // Teste para verificar se o método isCpfValid funciona corretamente
    @Test
    public void testIsCpfValid() {
        Ticket ticket = new Ticket();
        Assert.assertTrue(ticket.isCpfValid("12345678909")); // CPF válido
        Assert.assertFalse(ticket.isCpfValid("1234567890")); // CPF inválido
    }

    // Teste para verificar se o método isRgValid funciona corretamente
    @Test
    public void testIsRgValid() {
        Ticket ticket = new Ticket();
        Assert.assertTrue(ticket.isRgValid("123456789")); // RG válido
        Assert.assertFalse(ticket.isRgValid("1234")); // RG inválido
    }
}
