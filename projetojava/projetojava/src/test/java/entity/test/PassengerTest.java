package entity.test;

import com.projet.projetojava.entity.Passenger;
import org.junit.Assert;
import org.junit.Test;

public class PassengerTest {

    // Teste para verificar se o método isCpfValid funciona corretamente
    @Test
    public void testIsCpfValid() {
        Passenger passenger = new Passenger();
        Assert.assertTrue(passenger.isCpfValid("12345678909")); // CPF válido
        Assert.assertFalse(passenger.isCpfValid("1234567890")); // CPF inválido
    }

    // Teste para verificar se o método isRgValid funciona corretamente
    @Test
    public void testIsRgValid() {
        Passenger passenger = new Passenger();
        Assert.assertTrue(passenger.isRgValid("123456789")); // RG válido
        Assert.assertFalse(passenger.isRgValid("1234")); // RG inválido
    }
}
