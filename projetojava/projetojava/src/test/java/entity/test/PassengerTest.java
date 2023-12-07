package entity.test;

import com.projet.projetojava.entity.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PassengerTest {

    // Teste para verificar se o método isCpfValid funciona corretamente
    @Test
    public void testIsCpfValid() {
        Passenger passenger = new Passenger();
        // Verifica se o CPF é válido
        Assertions.assertTrue(passenger.isCpfValid("12345678909"));
        // Verifica se o CPF é inválido
        Assertions.assertFalse(passenger.isCpfValid("1234567890"));
    }

    // Teste para verificar se o método isRgValid funciona corretamente
    @Test
    public void testIsRgValid() {
        Passenger passenger = new Passenger();
        // Verifica se o RG é válido
        Assertions.assertTrue(passenger.isRgValid("123456789"));
        // Verifica se o RG é inválido
        Assertions.assertFalse(passenger.isRgValid("1234"));
    }
}
